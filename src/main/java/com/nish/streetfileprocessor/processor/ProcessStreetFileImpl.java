package com.nish.streetfileprocessor.processor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nish.streetfileprocessor.model.NewspaperReportModel;
import com.nish.streetfileprocessor.model.StreetModel;
import com.nish.streetfileprocessor.service.NewspaperDeliveryService;
import com.nish.streetfileprocessor.service.ReportCreationService;
import com.nish.streetfileprocessor.service.StreetDetailsFileReaderService;
import com.nish.streetfileprocessor.service.StreetDetailsService;
import com.nish.streetfileprocessor.service.StreetFileValidationService;
import com.nish.streetfileprocessor.validationcode.ValidationCode;
import com.nish.streetfileprocessor.writer.OutputWriter;

/**
 * This is main processor class which coordinates processing of input file
 * @author nisha
 *
 */
@Component
public class ProcessStreetFileImpl implements ProcessStreetFile{
	private static final Logger log = LoggerFactory.getLogger(ProcessStreetFileImpl.class);
	
	@Autowired
	private StreetDetailsFileReaderService streetDetailsFileReaderService;
	
	@Autowired
	private StreetDetailsService streetDetailsService;
	
	@Autowired
	private StreetFileValidationService streetFileValidationService;
	
	@Autowired
	private ReportCreationService reportCreationService;
	
	@Autowired
	private NewspaperDeliveryService newspaperDeliveryService;

	@Override
	public void validateAndGroupStreetFile(String inputFileLocation) {
		StreetModel streetModel = createStreetModel(inputFileLocation);
		reportCreationService.createAndSaveStreetPlanningReport(streetModel);
	}
	private StreetModel createStreetModel(String inputFileLocation){
		StreetModel streetModel = new StreetModel();
		String fileContent = streetDetailsFileReaderService.readStreetDetails(inputFileLocation);
		log.info(fileContent);
		List<Integer> houseNumbers = streetDetailsFileReaderService.parseStreetFileContent(fileContent);
		log.info("House numbers after parsing",houseNumbers);
		List<ValidationCode> validationResults = streetFileValidationService.validateStreetFile(houseNumbers);
		if(validationResults != null && !validationResults.isEmpty()){
			log.info("Validation of file failed");
			streetModel.setValidationMessages(validationResults);
			reportCreationService.createAndSaveStreetPlanningReport(streetModel);
			return streetModel;
		}
		streetModel.setHouseNumbers(houseNumbers);
		streetModel.setNorthNumbers(streetDetailsService.getNorthHouseNumbers(houseNumbers));
		streetModel.setSouthNumbers(streetDetailsService.getSouthHouseNumbers(houseNumbers));
		return streetModel;
	}
	@Override
	public void createNewspaperDeliveryReport(String inputFileLocation) {
		StreetModel streetModel = createStreetModel(inputFileLocation);
		List<NewspaperReportModel> newspaperReportModels = new ArrayList<>();
		NewspaperReportModel newspaperReportModel = new NewspaperReportModel();
		newspaperReportModel.setNewspaperDeliveryHouseNumbersInOrder(newspaperDeliveryService.generateEastWestDeliveryReport(streetModel));
		newspaperReportModel.setNoOfTimesRoadCrossed(newspaperDeliveryService.numberOfTimeRoadCrossedInEastWestDelivery(streetModel));
		newspaperReportModels.add(newspaperReportModel);
		newspaperReportModel = new NewspaperReportModel();
		newspaperReportModel.setNewspaperDeliveryHouseNumbersInOrder(newspaperDeliveryService.generateNorthThenSouthDeliveryReport(streetModel));
		newspaperReportModel.setNoOfTimesRoadCrossed(newspaperDeliveryService.numberOfTimeRoadCrossedInNothSouthDelivey(streetModel));
		newspaperReportModels.add(newspaperReportModel);
		reportCreationService.createAndSaveNewspaperDeliveryReport(newspaperReportModels);
	}

}

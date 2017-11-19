package com.nish.streetfileprocessor.processor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nish.streetfileprocessor.model.ReportModel;
import com.nish.streetfileprocessor.service.StreetDetailsFileReaderService;
import com.nish.streetfileprocessor.service.StreetDetailsService;
import com.nish.streetfileprocessor.service.StreetFileValidationService;
import com.nish.streetfileprocessor.validationcode.ValidationCode;

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
	
	@Value("${app.file.home}")
	private String fileLocation;

	@Override
	public void validateAndGroupStreetFile() {
		String fileContent = streetDetailsFileReaderService.readStreetDetails(fileLocation);
		log.info(fileContent);
		List<Integer> houseNumbers = streetDetailsFileReaderService.parseStreetFileContent(fileContent);
		log.info("House numbers after parsing",houseNumbers);
		
		List<ValidationCode> validationResults = streetFileValidationService.validateStreetFile(houseNumbers);
		if(validationResults != null && !validationResults.isEmpty()){
			log.info("Validation of file failed");
			return;
		}
		
		List<Integer> northHouseNumbers = streetDetailsService.getNorthHouseNumbers(houseNumbers);
		List<Integer> southHouseNumbers = streetDetailsService.getSouthHouseNumbers(houseNumbers);
		ReportModel reportModel = new ReportModel();
		reportModel.setHouseNumbers(southHouseNumbers);
		reportModel.setNorthNumbers(northHouseNumbers);
		reportModel.setSouthNumbers(southHouseNumbers);
		
	}
	@Override
	public void createNewspaperDeliveryReport() {


	}

}

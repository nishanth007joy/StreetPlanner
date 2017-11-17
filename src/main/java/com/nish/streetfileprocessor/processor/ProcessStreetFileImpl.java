package com.nish.streetfileprocessor.processor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nish.streetfileprocessor.model.ReportModel;
import com.nish.streetfileprocessor.parser.StreetFileParser;
import com.nish.streetfileprocessor.reader.StreetFileReader;
import com.nish.streetfileprocessor.service.StreetDetailsService;
import com.nish.streetfileprocessor.validation.StreetFileValidator;

/**
 * This is main processor class which coordinates processing of input file
 * @author nisha
 *
 */
@Component
public class ProcessStreetFileImpl implements ProcessStreetFile{
	private static final Logger log = LoggerFactory.getLogger(ProcessStreetFileImpl.class);
	@Autowired
	private StreetFileReader streetFileReader;

	@Autowired
	private StreetFileParser streetFileParser;
	
	@Autowired
	private StreetFileValidator streetFileValidator;
	
	@Autowired
	private StreetDetailsService streetDetailsService;
	
	@Value("${app.file.home}")
	private String fileLocation;

	@Override
	public void validateAndGroupStreetFile() {
		String fileContent = streetFileReader.readFile(fileLocation);
		log.info(fileContent);
		List<Integer> houseNumbers = streetFileParser.parseHouseNumberFromSteetFile(fileContent);
		boolean isFileValid = true;
		log.info("House numbers after parsing",houseNumbers);
		if(!streetFileValidator.isHouseNumberStartsWithOne(houseNumbers)){
			log.info("Validated failed for House number started with 1");
			isFileValid =  false;
		}
		if(streetFileValidator.checkDuplicateHouseNumber(houseNumbers)){
			log.info("Validated failed for duplicate House number");
			isFileValid =  false;
		}
		if(streetFileValidator.checkMissingNumber(houseNumbers)){
			log.info("Validated failed for missing House number");
			isFileValid =  false;
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

package com.nish.streetfileprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nish.streetfileprocessor.processor.ProcessStreetFile;
/**
 * This is the main class to invoke program to create street file validation report and News paper delivery report
 * @author nisha
 *
 */
@SpringBootApplication
public class StreetFileProcessorApplication implements CommandLineRunner{
	@Autowired
	ProcessStreetFile processStreetFile;
	
	@Value("${action:World}")
	private String action;
	
	@Value("${app.file.home}")
	private String fileLocation;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StreetFileProcessorApplication.class);
		app.run(args);
	}
	@Override
	public void run(String... args) throws Exception {

		if (action.equals("VALIDATE_AND_PROCESS")) {
			processStreetFile.validateAndGroupStreetFile(fileLocation);
		} else if(action.equals("NEWS_PAPER_DELIVERY_REPORT")){
			processStreetFile.createNewspaperDeliveryReport(fileLocation);
		}
	}
}

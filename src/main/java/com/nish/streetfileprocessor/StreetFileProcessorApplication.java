package com.nish.streetfileprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nish.streetfileprocessor.processor.ProcessStreetFile;

@SpringBootApplication
public class StreetFileProcessorApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(StreetFileProcessorApplication.class, args);
		ProcessStreetFile  processStreetFile = applicationContext.getBean(ProcessStreetFile.class);
		processStreetFile.validateAndGroupStreetFile();
		processStreetFile.createNewspaperDeliveryReport();
	}
}

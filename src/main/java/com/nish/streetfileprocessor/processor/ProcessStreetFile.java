package com.nish.streetfileprocessor.processor;

public interface ProcessStreetFile {
	/**
	 * 
	 */
	public void validateAndGroupStreetFile(String inputFileLocation);
	/**
	 * 
	 */
	public void createNewspaperDeliveryReport(String inputFileLocation);
}

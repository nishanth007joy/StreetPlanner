package com.nish.streetfileprocessor.validationcode;
/**
 * This enum class hold all validation message can be returned from validation component
 * @author nismj
 *
 */
public enum ValidationCode {

	HOUSE_NUMBER_NOT_STARTING_WITH_ONE(1,"House number should start with 1")
	,HOUSE_NUMBER_HAVE_DUPLICATE(2,"House number should not contains duplicates")
	,HOUSE_NUMBER_MISSING(3,"House number cannot be missing bwteen start and end house number");

	private int value; 
	private String validationFailureDescription;

	private ValidationCode(int value, String validationFailureDescription){  
		this.value=value; 
		this.validationFailureDescription = validationFailureDescription;
	}

	public int getValue() {
		return value;
	}

	public String getValidationFailureDescription() {
		return validationFailureDescription;
	}
	
}

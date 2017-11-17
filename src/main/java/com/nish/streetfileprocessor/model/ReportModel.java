package com.nish.streetfileprocessor.model;

import java.util.List;

import com.nish.streetfileprocessor.validationcode.ValidationCode;
/**
 * This model class hold data after processing a input street file
 * @author nismj
 *
 */
public class ReportModel {

	private List<Integer> houseNumbers;

	private List<Integer> northNumbers;

	private List<Integer> southNumbers;

	private List<ValidationCode> validationMessages;

	public List<Integer> getHouseNumbers() {
		return houseNumbers;
	}

	public void setHouseNumbers(List<Integer> houseNumbers) {
		this.houseNumbers = houseNumbers;
	}

	public List<Integer> getNorthNumbers() {
		return northNumbers;
	}

	public void setNorthNumbers(List<Integer> northNumbers) {
		this.northNumbers = northNumbers;
	}

	public List<Integer> getSouthNumbers() {
		return southNumbers;
	}

	public void setSouthNumbers(List<Integer> southNumbers) {
		this.southNumbers = southNumbers;
	}

	public List<ValidationCode> getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(List<ValidationCode> validationMessages) {
		this.validationMessages = validationMessages;
	}
}

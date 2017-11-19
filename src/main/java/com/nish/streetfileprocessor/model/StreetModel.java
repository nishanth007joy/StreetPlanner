package com.nish.streetfileprocessor.model;

import java.util.List;

import com.nish.streetfileprocessor.validationcode.ValidationCode;
/**
 * This model class hold data after processing a input street file
 * @author nismj
 *
 */
public class StreetModel {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((houseNumbers == null) ? 0 : houseNumbers.hashCode());
		result = prime * result + ((northNumbers == null) ? 0 : northNumbers.hashCode());
		result = prime * result + ((southNumbers == null) ? 0 : southNumbers.hashCode());
		result = prime * result + ((validationMessages == null) ? 0 : validationMessages.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StreetModel other = (StreetModel) obj;
		if (houseNumbers == null) {
			if (other.houseNumbers != null)
				return false;
		} else if (!houseNumbers.equals(other.houseNumbers))
			return false;
		if (northNumbers == null) {
			if (other.northNumbers != null)
				return false;
		} else if (!northNumbers.equals(other.northNumbers))
			return false;
		if (southNumbers == null) {
			if (other.southNumbers != null)
				return false;
		} else if (!southNumbers.equals(other.southNumbers))
			return false;
		if (validationMessages == null) {
			if (other.validationMessages != null)
				return false;
		} else if (!validationMessages.equals(other.validationMessages))
			return false;
		return true;
	}
	
}

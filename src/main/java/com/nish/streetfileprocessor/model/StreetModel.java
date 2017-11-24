package com.nish.streetfileprocessor.model;

import java.util.List;

import com.nish.streetfileprocessor.validationcode.ValidationCode;

import lombok.Data;

/**
 * This model class hold data after processing a input street file
 * @author nismj
 *
 */
@Data
public class StreetModel {

	private List<Integer> houseNumbers;

	private List<Integer> northNumbers;

	private List<Integer> southNumbers;

	private List<ValidationCode> validationMessages;
}

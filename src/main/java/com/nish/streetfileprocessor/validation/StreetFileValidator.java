package com.nish.streetfileprocessor.validation;

import java.util.List;
/**
 * This contains all methods for validating house numbers from file input
 * @author nismj
 *
 */
public interface StreetFileValidator {
	/**
	 * This method checks whether house numbers starts with 1
	 * @param houseNumbers
	 * @return
	 */
	public boolean isHouseNumberStartsWithOne(final List<Integer> houseNumbers);
	/**
	 * This method checks whether house numbers have any duplicate
	 * @param fileContent
	 * @return
	 */
	public boolean checkDuplicateHouseNumber(final List<Integer> houseNumbers);
	/**
	 * This Method checks whether any house number is missing
	 * @param houseNumbers
	 * @return
	 */
	public boolean checkMissingNumber(final List<Integer> houseNumbers);
}

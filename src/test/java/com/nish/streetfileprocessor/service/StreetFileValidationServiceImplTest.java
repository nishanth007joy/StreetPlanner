package com.nish.streetfileprocessor.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.nish.streetfileprocessor.basetest.BaseTest;
import com.nish.streetfileprocessor.validation.StreetFileValidator;
import com.nish.streetfileprocessor.validationcode.ValidationCode;

/**
 * This test class validates all validation methods defined on validation service class
 * @author nisha
 *
 */
public class StreetFileValidationServiceImplTest extends BaseTest{
	@InjectMocks
	StreetFileValidationService streetFileValidationService = new StreetFileValidationServiceImpl();
	
	@Mock
	private StreetFileValidator streetFileValidator;
	
	/**
	 * This is a positive scenario in which if house number file is having list of house number starting with 1 and there is no duplicates 
	 * and missing house number then validate methord null as error list.
	 */
	@Test
	public void testValidateStreetFile() {
		Integer[] houseNumberArray = {1,3,2,5,4,6,8,7};
		List<Integer> houseNumbers = Arrays.asList(houseNumberArray);
		when(streetFileValidator.isHouseNumberStartsWithOne(anyListOf(Integer.class))).thenReturn(true);
		when(streetFileValidator.checkMissingNumber(anyListOf(Integer.class))).thenReturn(false);
		when(streetFileValidator.isHouseNumberStartsWithOne(anyListOf(Integer.class))).thenReturn(true);
		List<ValidationCode> validationResuls = streetFileValidationService.validateStreetFile(houseNumbers);
		assertNull(validationResuls);
	}
	/**
	 * This method test whether House number not starting validation is working correctly
	 */
	@Test
	public void testValidateHouseNumberNotStartingWithOne(){
		Integer[] houseNumberArray = {3,2,5,4,6,8,7};
		List<Integer> houseNumbers = Arrays.asList(houseNumberArray);
		when(streetFileValidator.isHouseNumberStartsWithOne(anyListOf(Integer.class))).thenReturn(false);
		when(streetFileValidator.checkMissingNumber(anyListOf(Integer.class))).thenReturn(false);
		when(streetFileValidator.checkDuplicateHouseNumber(anyListOf(Integer.class))).thenReturn(false);
		List<ValidationCode> validationResuls = streetFileValidationService.validateStreetFile(houseNumbers);
		assertThat(validationResuls, containsInAnyOrder(ValidationCode.HOUSE_NUMBER_NOT_STARTING_WITH_ONE));
	}
	/**
	 * This method checks whether Duplicate house number validation is working
	 */
	@Test
	public void testValidateHouseNumberHavingDuplicate(){
		Integer[] houseNumberArray = {1,3,2,5,4,6,8,7};
		List<Integer> houseNumbers = Arrays.asList(houseNumberArray);
		when(streetFileValidator.isHouseNumberStartsWithOne(anyListOf(Integer.class))).thenReturn(true);
		when(streetFileValidator.checkMissingNumber(anyListOf(Integer.class))).thenReturn(false);
		when(streetFileValidator.checkDuplicateHouseNumber(anyListOf(Integer.class))).thenReturn(true);
		List<ValidationCode> validationResuls = streetFileValidationService.validateStreetFile(houseNumbers);
		assertThat(validationResuls, containsInAnyOrder(ValidationCode.HOUSE_NUMBER_HAVE_DUPLICATE));
	}
	/**
	 * This method checks whether Duplicate house number validation is working
	 */
	@Test
	public void testValidateHouseNumberMissing(){
		Integer[] houseNumberArray = {1,3,2,5,4,6,8,7};
		List<Integer> houseNumbers = Arrays.asList(houseNumberArray);
		when(streetFileValidator.isHouseNumberStartsWithOne(anyListOf(Integer.class))).thenReturn(true);
		when(streetFileValidator.checkMissingNumber(anyListOf(Integer.class))).thenReturn(true);
		when(streetFileValidator.checkDuplicateHouseNumber(anyListOf(Integer.class))).thenReturn(false);
		List<ValidationCode> validationResuls = streetFileValidationService.validateStreetFile(houseNumbers);
		assertThat(validationResuls, containsInAnyOrder(ValidationCode.HOUSE_NUMBER_MISSING));
	}
	/**
	 * This method checks whether all validation fails
	 */
	@Test
	public void testValidateHouseNumberValidationFailsOnAll(){
		Integer[] houseNumberArray = {1,3,2,5,4,6,8,7};
		List<Integer> houseNumbers = Arrays.asList(houseNumberArray);
		when(streetFileValidator.isHouseNumberStartsWithOne(anyListOf(Integer.class))).thenReturn(false);
		when(streetFileValidator.checkMissingNumber(anyListOf(Integer.class))).thenReturn(true);
		when(streetFileValidator.checkDuplicateHouseNumber(anyListOf(Integer.class))).thenReturn(true);
		List<ValidationCode> validationResuls = streetFileValidationService.validateStreetFile(houseNumbers);
		assertThat(validationResuls, containsInAnyOrder(ValidationCode.HOUSE_NUMBER_MISSING,ValidationCode.HOUSE_NUMBER_HAVE_DUPLICATE,ValidationCode.HOUSE_NUMBER_NOT_STARTING_WITH_ONE));
	}
}

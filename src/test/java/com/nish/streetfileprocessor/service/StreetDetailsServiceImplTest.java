package com.nish.streetfileprocessor.service;

import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * 
 * @author nisha
 *
 */
public class StreetDetailsServiceImplTest {
	
	private StreetDetailsService streetDetailsService = new StreetDetailsServiceImpl();
	/**
	 * South house numbers filtering methord test for null input
	 */
	@Test
	public void testGetSouthHouseNumbersWithNullInput() {
		List<Integer> southHouseNumbers = streetDetailsService.getSouthHouseNumbers(null);
		assertNull(southHouseNumbers);
	}
	/**
	 * North house numbers filtering methord test for null input
	 */
	@Test
	public void testGetNorthHouseNumbersWithNullInput() {
		List<Integer> northHouseNumbers = streetDetailsService.getNorthHouseNumbers(null);
		assertNull(northHouseNumbers);
	}
	/**
	 * Test for getting north house numbers from input list
	 */
	@Test
	public void testGetNorthHouseNumbers() {
		Integer[] houseNumberArray = {1,3,2,5,4,6,8,7};
		List<Integer> houseNumbers = Arrays.asList(houseNumberArray);
		List<Integer> northHouseNumbers = streetDetailsService.getNorthHouseNumbers(houseNumbers);
		assertThat(northHouseNumbers, containsInAnyOrder(1,3,5,7));
	}
	/**
	 * Test for getting south house numbers from input list
	 */
	@Test
	public void testGetSouthHouseNumbers() {
		Integer[] houseNumberArray = {1,3,2,5,4,6,8,7};
		List<Integer> houseNumbers = Arrays.asList(houseNumberArray);
		List<Integer> southHouseNumbers = streetDetailsService.getSouthHouseNumbers(houseNumbers);
		assertThat(southHouseNumbers, containsInAnyOrder(2,4,6,8));
	}

}

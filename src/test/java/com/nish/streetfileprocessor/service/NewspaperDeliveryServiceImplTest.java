package com.nish.streetfileprocessor.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.nish.streetfileprocessor.basetest.BaseTest;
import com.nish.streetfileprocessor.model.StreetModel;

public class NewspaperDeliveryServiceImplTest extends BaseTest{
	
	private NewspaperDeliveryService newspaperDeliveryService = new NewspaperDeliveryServiceImpl();
	
	@Test
	public void testGenerateNorthThenSouthDeliveryReport() {
		StreetModel streetModel = new StreetModel();
		Integer [] houseNumbers = {1, 2, 4, 3, 6, 5, 7, 8, 9, 10, 12, 11, 13, 15, 14};
		Integer [] northNumbers = {1, 3, 5, 7, 9, 11, 13, 15};
		Integer [] southNumbers = {2, 4, 6, 8, 10, 12, 14};
		streetModel.setHouseNumbers(Arrays.asList(houseNumbers));
		streetModel.setNorthNumbers(Arrays.asList(northNumbers));
		streetModel.setSouthNumbers(Arrays.asList(southNumbers));
		List<Integer> deliveryOrder = newspaperDeliveryService.generateNorthThenSouthDeliveryReport(streetModel);
		assertThat(deliveryOrder,contains(1, 3, 5, 7, 9, 11, 13, 15, 14, 12, 10, 8, 6, 4, 2));
	}

	@Test
	public void testGenerateEastWestDeliveryReport() {
		StreetModel streetModel = new StreetModel();
		Integer [] houseNumbers = {1, 2, 4, 3, 6, 5, 7, 8, 9, 10, 12, 11, 13, 15, 14};
		Integer [] northNumbers = {1, 3, 5, 7, 9, 11, 13, 15};
		Integer [] southNumbers = {2, 4, 6, 8, 10, 12, 14};
		streetModel.setHouseNumbers(Arrays.asList(houseNumbers));
		streetModel.setNorthNumbers(Arrays.asList(northNumbers));
		streetModel.setSouthNumbers(Arrays.asList(southNumbers));
		List<Integer> deliveryOrder = newspaperDeliveryService.generateEastWestDeliveryReport(streetModel);
		assertThat(deliveryOrder, contains(1, 2, 4, 3, 6, 5, 7, 8, 9, 10, 12, 11, 13, 15, 14));
	}

	@Test
	public void testNumberOfTimeRoadCrossedInNothSouthDelivey() {
		StreetModel streetModel = new StreetModel();
		Integer [] houseNumbers = {1, 2, 4, 3, 6, 5, 7, 8, 9, 10, 12, 11, 13, 15, 14};
		Integer [] northNumbers = {1, 3, 5, 7, 9, 11, 13, 15};
		Integer [] southNumbers = {2, 4, 6, 8, 10, 12, 14};
		streetModel.setHouseNumbers(Arrays.asList(houseNumbers));
		streetModel.setNorthNumbers(Arrays.asList(northNumbers));
		streetModel.setSouthNumbers(Arrays.asList(southNumbers));
		int roadCrossedNo = newspaperDeliveryService.numberOfTimeRoadCrossedInNothSouthDelivey(streetModel);
		assertEquals(1, roadCrossedNo);
	}

	@Test
	public void testNumberOfTimeRoadCrossedInEastWestDelivery() {
		StreetModel streetModel = new StreetModel();
		Integer [] houseNumbers = {1, 2, 4, 3, 6, 5, 7, 8, 9, 10, 12, 11, 13, 15, 14};
		Integer [] northNumbers = {1, 3, 5, 7, 9, 11, 13, 15};
		Integer [] southNumbers = {2, 4, 6, 8, 10, 12, 14};
		streetModel.setHouseNumbers(Arrays.asList(houseNumbers));
		streetModel.setNorthNumbers(Arrays.asList(northNumbers));
		streetModel.setSouthNumbers(Arrays.asList(southNumbers));
		int roadCrossedNo = newspaperDeliveryService.numberOfTimeRoadCrossedInEastWestDelivery(streetModel);
		assertEquals(9, roadCrossedNo);
	}

}

package com.nish.streetfileprocessor.processor;

import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.nish.streetfileprocessor.basetest.BaseTest;
import com.nish.streetfileprocessor.model.StreetModel;
import com.nish.streetfileprocessor.service.ReportCreationService;
import com.nish.streetfileprocessor.service.StreetDetailsFileReaderService;
import com.nish.streetfileprocessor.service.StreetDetailsService;
import com.nish.streetfileprocessor.service.StreetFileValidationService;

public class ProcessStreetFileImplTest extends BaseTest{
	
	@InjectMocks
	private ProcessStreetFile processStreetFile =  new ProcessStreetFileImpl();

	@Mock
	private StreetDetailsFileReaderService streetDetailsFileReaderService;
	
	@Mock
	private StreetDetailsService streetDetailsService;
	
	@Mock
	private StreetFileValidationService streetFileValidationService;
	
	@Mock
	private ReportCreationService reportCreationService;
	
	@Test
	public void testValidateAndGroupStreetFileValid() {
		Integer[] houseNumbers = {1,2,3,4,5,6,7};
		StreetModel reportModel = new StreetModel();
		Integer[] northHouseNumbers = {1,3,5,7};
		Integer[] southHouseNumbers = {2,4,6};
		reportModel.setHouseNumbers(Arrays.asList(houseNumbers));
		reportModel.setNorthNumbers(Arrays.asList(northHouseNumbers));
		reportModel.setSouthNumbers(Arrays.asList(southHouseNumbers));
		when(streetDetailsFileReaderService.readStreetDetails(anyString())).thenReturn("1 3 2 5 7 4 6");
		when(streetDetailsFileReaderService.parseStreetFileContent(anyString())).thenReturn(Arrays.asList(houseNumbers));
		when(streetFileValidationService.validateStreetFile(anyList())).thenReturn(null);
		when(streetDetailsService.getNorthHouseNumbers(anyList())).thenReturn(Arrays.asList(northHouseNumbers));
		when(streetDetailsService.getSouthHouseNumbers(anyList())).thenReturn(Arrays.asList(southHouseNumbers));
		doNothing().when(reportCreationService).createAndSaveStreetPlanningReport(reportModel);
		processStreetFile.validateAndGroupStreetFile("");
		final ArgumentCaptor<StreetModel> argumentCaptor = 
                ArgumentCaptor.forClass(StreetModel.class);
		verify(reportCreationService, times(1)).createAndSaveStreetPlanningReport(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue().getHouseNumbers(),containsInAnyOrder(1,2,3,4,5,6,7));
		assertThat(argumentCaptor.getValue().getNorthNumbers(),containsInAnyOrder(1,3,5,7));
		assertThat(argumentCaptor.getValue().getSouthNumbers(),containsInAnyOrder(2,4,6));
	}

	@Test
	public void testCreateNewspaperDeliveryReport() {
		
	}

}

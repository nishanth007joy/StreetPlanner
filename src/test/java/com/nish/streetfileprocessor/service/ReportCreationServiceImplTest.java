package com.nish.streetfileprocessor.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.nish.streetfileprocessor.basetest.BaseTest;
import com.nish.streetfileprocessor.model.StreetModel;
import com.nish.streetfileprocessor.validationcode.ValidationCode;
import com.nish.streetfileprocessor.writer.OutputWriter;

/**
 * This test class deals with testing report creation service
 * 
 * @author nisha
 *
 */
public class ReportCreationServiceImplTest extends BaseTest {

    @InjectMocks
    private ReportCreationService ReportCreationServiceImplTest = new ReportCreationServiceImpl();

    @Mock
    private OutputWriter outputWriter;

    /**
     * Test whether report is created for a valid file correctly
     */
    @Test
    public void testCreateAndSaveReportValid() {
        doNothing().when(outputWriter).writeProcessingReport(anyString());
        StreetModel reportModel = new StreetModel();
        Integer[] houseNumbers = { 1, 3, 2, 5, 6, 7, 4 };
        Integer[] northHouseNumbers = { 1, 3, 5, 7 };
        Integer[] southHouseNumbers = { 2, 4, 6 };
        reportModel.setHouseNumbers(Arrays.asList(houseNumbers));
        reportModel.setNorthNumbers(Arrays.asList(northHouseNumbers));
        reportModel.setSouthNumbers(Arrays.asList(southHouseNumbers));
        ReportCreationServiceImplTest.createAndSaveStreetPlanningReport(reportModel);
        verify(outputWriter, times(1)).writeProcessingReport(",7,4,3,");
    }

    /**
     * Test report for invalid file with duplicate house number
     */
    @Test
    public void testCreateAndSaveReportInvalidDuplicate() {
        doNothing().when(outputWriter).writeProcessingReport(anyString());
        StreetModel reportModel = new StreetModel();
        ValidationCode[] validationArray = { ValidationCode.HOUSE_NUMBER_HAVE_DUPLICATE };
        reportModel.setValidationMessages(Arrays.asList(validationArray));
        ReportCreationServiceImplTest.createAndSaveStreetPlanningReport(reportModel);
        verify(outputWriter, times(1)).writeProcessingReport("House number should not contains duplicates,,,,");
    }

    /**
     * Test report for invalid file with house number not stating with 1
     */
    @Test
    public void testCreateAndSaveReportInvalidNotStartingOnOne() {
        doNothing().when(outputWriter).writeProcessingReport(anyString());
        StreetModel reportModel = new StreetModel();
        ValidationCode[] validationArray = { ValidationCode.HOUSE_NUMBER_NOT_STARTING_WITH_ONE };
        reportModel.setValidationMessages(Arrays.asList(validationArray));
        ReportCreationServiceImplTest.createAndSaveStreetPlanningReport(reportModel);
        verify(outputWriter, times(1)).writeProcessingReport("House number should start with 1,,,,");
    }

    /**
     * Test report for invalid file with missing house nunber
     */
    @Test
    public void testCreateAndSaveReportInvalidMissingHouse() {
        doNothing().when(outputWriter).writeProcessingReport(anyString());
        StreetModel reportModel = new StreetModel();
        ValidationCode[] validationArray = { ValidationCode.HOUSE_NUMBER_MISSING };
        reportModel.setValidationMessages(Arrays.asList(validationArray));
        ReportCreationServiceImplTest.createAndSaveStreetPlanningReport(reportModel);
        verify(outputWriter, times(1))
                .writeProcessingReport("House number cannot be missing bwteen start and end house number,,,,");
    }

    /**
     * Test report for invalid file with missing house number and not stating with 1 and duplicate house number
     */
    @Test
    public void testCreateAndSaveReportAllValidationFailure() {
        doNothing().when(outputWriter).writeProcessingReport(anyString());
        StreetModel reportModel = new StreetModel();
        ValidationCode[] validationArray = { ValidationCode.HOUSE_NUMBER_MISSING,
                ValidationCode.HOUSE_NUMBER_NOT_STARTING_WITH_ONE, ValidationCode.HOUSE_NUMBER_HAVE_DUPLICATE };
        reportModel.setValidationMessages(Arrays.asList(validationArray));
        ReportCreationServiceImplTest.createAndSaveStreetPlanningReport(reportModel);
        verify(outputWriter, times(1)).writeProcessingReport(
                "House number cannot be missing bwteen start and end house number$House number should start with 1$House number should not contains duplicates,,,,");
    }
}

package com.nish.streetfileprocessor.service;

import java.util.List;

import com.nish.streetfileprocessor.model.NewspaperReportModel;
import com.nish.streetfileprocessor.model.StreetModel;
/**
 * This service deals with logic of creation of report and/
 * @author nisha
 *
 */
public interface ReportCreationService {
	/**
	 * This will create and save street planning report
	 * @param reportModel
	 */
	public void createAndSaveStreetPlanningReport(StreetModel reportModel);
	/**
	 * This will create newspaper delivery report
	 * @param reportModel
	 */
	public void createAndSaveNewspaperDeliveryReport(List<NewspaperReportModel> newspaperReportModel);
}

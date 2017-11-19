package com.nish.streetfileprocessor.service;

import com.nish.streetfileprocessor.model.ReportModel;
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
	public void createAndSaveStreetPlanningReport(ReportModel reportModel);
	/**
	 * This will create newspaper delivery report
	 * @param reportModel
	 */
	public void createAndSaveNewspaperDeliveryReport(ReportModel reportModel);
}

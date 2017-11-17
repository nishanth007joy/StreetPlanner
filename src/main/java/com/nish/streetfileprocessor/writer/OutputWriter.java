package com.nish.streetfileprocessor.writer;

import com.nish.streetfileprocessor.model.ReportModel;

public interface OutputWriter {

	public void writeProcessingReport(ReportModel reportModel);
	
}

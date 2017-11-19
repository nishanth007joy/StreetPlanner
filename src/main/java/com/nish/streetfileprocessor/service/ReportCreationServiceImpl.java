package com.nish.streetfileprocessor.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.streetfileprocessor.model.ReportModel;
import com.nish.streetfileprocessor.validationcode.ValidationCode;
import com.nish.streetfileprocessor.writer.OutputWriter;

@Service
public class ReportCreationServiceImpl implements ReportCreationService{

	@Autowired
	private OutputWriter outputWriter;
	
	@Override
	public void createAndSaveStreetPlanningReport(ReportModel reportModel) {
		StringBuilder reportString = new StringBuilder();
		if(reportModel != null && reportModel.getValidationMessages() !=null){
			reportString.append(reportModel
					.getValidationMessages()
					.stream()
					.map(ValidationCode::getValidationFailureDescription)
					.collect(Collectors.joining("$")));
			reportString.append(",");
		}else{
			reportString.append(",");
		}
		
		if(reportModel != null && reportModel.getHouseNumbers() !=null){
			reportString.append(reportModel.getHouseNumbers().size()).append(",");
		}else{
			reportString.append(",");
		}
		
		if(reportModel != null && reportModel.getNorthNumbers()!=null){
			reportString.append(reportModel.getNorthNumbers().size()).append(",");
		}else{
			reportString.append(",");
		}
		
		if(reportModel != null && reportModel.getSouthNumbers()!=null){
			reportString.append(reportModel.getSouthNumbers().size()).append(",");
		}else{
			reportString.append(",");
		}
		outputWriter.writeProcessingReport(reportString.toString());
	}

	@Override
	public void createAndSaveNewspaperDeliveryReport(ReportModel reportModel) {
		
	}

}

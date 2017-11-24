package com.nish.streetfileprocessor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.streetfileprocessor.model.NewspaperReportModel;
import com.nish.streetfileprocessor.model.StreetModel;
import com.nish.streetfileprocessor.validationcode.ValidationCode;
import com.nish.streetfileprocessor.writer.OutputWriter;

@Service
public class ReportCreationServiceImpl implements ReportCreationService {

    @Autowired
    private OutputWriter outputWriter;

    @Override
    public void createAndSaveStreetPlanningReport(StreetModel reportModel) {
        StringBuilder reportString = new StringBuilder();
        if (reportModel != null && reportModel.getValidationMessages() != null) {
            reportString.append(reportModel.getValidationMessages().stream()
                    .map(ValidationCode::getValidationFailureDescription).collect(Collectors.joining("$")));
            reportString.append(",");
        } else {
            reportString.append(",");
        }

        if (reportModel != null && reportModel.getHouseNumbers() != null) {
            reportString.append(reportModel.getHouseNumbers().size()).append(",");
        } else {
            reportString.append(",");
        }

        if (reportModel != null && reportModel.getNorthNumbers() != null) {
            reportString.append(reportModel.getNorthNumbers().size()).append(",");
        } else {
            reportString.append(",");
        }

        if (reportModel != null && reportModel.getSouthNumbers() != null) {
            reportString.append(reportModel.getSouthNumbers().size()).append(",");
        } else {
            reportString.append(",");
        }
        outputWriter.writeProcessingReport(reportString.toString());
    }

    @Override
    public void createAndSaveNewspaperDeliveryReport(List<NewspaperReportModel> newspaperReportModels) {
        StringBuilder reportString = new StringBuilder();
        for (NewspaperReportModel newspaperReportModel : newspaperReportModels) {
            if (newspaperReportModel != null) {
                if (newspaperReportModel.getNewspaperDeliveryHouseNumbersInOrder() != null) {
                    reportString.append(newspaperReportModel.getNewspaperDeliveryHouseNumbersInOrder().stream()
                            .map(String::valueOf).collect(Collectors.joining(" "))).append(",");
                } else {
                    reportString.append(",");
                }
                reportString.append(newspaperReportModel.getNoOfTimesRoadCrossed()).append(",").append("\n");
            }
        }
        outputWriter.writeProcessingReport(reportString.toString());
    }

}

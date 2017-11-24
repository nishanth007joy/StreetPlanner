package com.nish.streetfileprocessor.model;

import java.util.List;

/**
 * 
 * @author nisha
 *
 */
public class NewspaperReportModel {
    private List<Integer> newspaperDeliveryHouseNumbersInOrder;

    private int noOfTimesRoadCrossed;

    public List<Integer> getNewspaperDeliveryHouseNumbersInOrder() {
        return newspaperDeliveryHouseNumbersInOrder;
    }

    public void setNewspaperDeliveryHouseNumbersInOrder(List<Integer> newspaperDeliveryHouseNumbersInOrder) {
        this.newspaperDeliveryHouseNumbersInOrder = newspaperDeliveryHouseNumbersInOrder;
    }

    public int getNoOfTimesRoadCrossed() {
        return noOfTimesRoadCrossed;
    }

    public void setNoOfTimesRoadCrossed(int noOfTimesRoadCrossed) {
        this.noOfTimesRoadCrossed = noOfTimesRoadCrossed;
    }

}

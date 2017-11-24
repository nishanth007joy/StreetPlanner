package com.nish.streetfileprocessor.service;

import java.util.List;

import com.nish.streetfileprocessor.model.StreetModel;

/**
 * 
 * @author nisha
 *
 */
public interface NewspaperDeliveryService {
    /**
     * 
     * @param streetModel
     * @return
     */
    public List<Integer> generateNorthThenSouthDeliveryReport(StreetModel streetModel);

    /**
     * 
     * @param streetModel
     * @return
     */
    public List<Integer> generateEastWestDeliveryReport(StreetModel streetModel);

    /**
     * 
     * @param streetModel
     * @return
     */
    public int numberOfTimeRoadCrossedInNothSouthDelivey(StreetModel streetModel);

    /**
     * 
     * @param streetModel
     * @return
     */
    public int numberOfTimeRoadCrossedInEastWestDelivery(StreetModel streetModel);
}

package com.nish.streetfileprocessor.service;

import java.util.List;

/**
 * This is the service class deals with business logic implementation
 * 
 * @author nismj
 *
 */
public interface StreetDetailsService {
    /**
     * 
     * @param houseNumbers
     * @return
     */
    public List<Integer> getNorthHouseNumbers(List<Integer> houseNumbers);

    /**
     * 
     * @param houseNumbers
     * @return
     */
    public List<Integer> getSouthHouseNumbers(List<Integer> houseNumbers);
}

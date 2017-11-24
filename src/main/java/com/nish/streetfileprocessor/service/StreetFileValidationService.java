package com.nish.streetfileprocessor.service;

import java.util.List;

import com.nish.streetfileprocessor.validationcode.ValidationCode;

/**
 * 
 * @author nisha
 *
 */
public interface StreetFileValidationService {
    /**
     * this method dealse with validation component call and return validation failures
     * 
     * @param houseNumbers
     * @return
     */
    public List<ValidationCode> validateStreetFile(List<Integer> houseNumbers);
}

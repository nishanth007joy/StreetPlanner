package com.nish.streetfileprocessor.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.streetfileprocessor.validation.StreetFileValidator;
import com.nish.streetfileprocessor.validationcode.ValidationCode;

@Service
public class StreetFileValidationServiceImpl implements StreetFileValidationService {
    private static final Logger log = LoggerFactory.getLogger(StreetFileValidationServiceImpl.class);

    @Autowired
    private StreetFileValidator streetFileValidator;

    @Override
    public List<ValidationCode> validateStreetFile(List<Integer> houseNumbers) {
        List<ValidationCode> validationErrors = null;
        if (!streetFileValidator.isHouseNumberStartsWithOne(houseNumbers)) {
            log.info("Validated failed for House number started with 1");
            validationErrors = new ArrayList<>();
            validationErrors.add(ValidationCode.HOUSE_NUMBER_NOT_STARTING_WITH_ONE);
        }
        if (streetFileValidator.checkDuplicateHouseNumber(houseNumbers)) {
            log.info("Validated failed for duplicate House number");
            if (null == validationErrors)
                validationErrors = new ArrayList<>();
            validationErrors.add(ValidationCode.HOUSE_NUMBER_HAVE_DUPLICATE);
        }
        if (streetFileValidator.checkMissingNumber(houseNumbers)) {
            log.info("Validated failed for missing House number");
            if (null == validationErrors)
                validationErrors = new ArrayList<>();
            validationErrors.add(ValidationCode.HOUSE_NUMBER_MISSING);
        }
        return validationErrors;
    }

}

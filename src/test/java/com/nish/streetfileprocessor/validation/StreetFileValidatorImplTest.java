package com.nish.streetfileprocessor.validation;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class StreetFileValidatorImplTest {
    private StreetFileValidator streetFileValidator = new StreetFileValidatorImpl();

    @Test
    public void testCheckDuplicateHouseNumber() {
        boolean isValid = streetFileValidator
                .checkDuplicateHouseNumber(Arrays.asList(1, 2, 4, 3, 6, 5, 7, 8, 9, 10, 12, 11, 13, 15, 14));
        assertFalse(isValid);
    }

    @Test
    public void testCheckMissingNumber() {
        boolean isValid = streetFileValidator
                .checkMissingNumber(Arrays.asList(1, 2, 4, 3, 6, 5, 7, 8, 9, 10, 12, 11, 13, 15, 14));
        assertFalse(isValid);
    }

    @Test
    public void testIsHouseNumberStartsWithOne() {
        boolean isValid = streetFileValidator
                .isHouseNumberStartsWithOne(Arrays.asList(1, 2, 4, 3, 6, 5, 7, 8, 9, 10, 12, 11, 13, 15, 14));
        assertTrue(isValid);
    }

}

package com.nish.streetfileprocessor.validation;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * House number validation implementation
 * @author nismj
 *
 */
@Component
public class StreetFileValidatorImpl implements StreetFileValidator{
	private static final Logger log = LoggerFactory.getLogger(StreetFileValidatorImpl.class);

	@Override
	public boolean checkDuplicateHouseNumber(final List<Integer> houseNumbers) {
		log.info("Validating checkDuplicateHouseNumber");
		Set<Integer> houseNumberSet = new HashSet<>(houseNumbers);
		return (houseNumberSet.size() < houseNumbers.size());
	}

	@Override
	public boolean checkMissingNumber(final List<Integer> houseNumbers) {
		log.info("Validating checkMissingNumber");
		int lengthOfHiuseNumber = houseNumbers.size();
		int totalOfHouseNumber = lengthOfHiuseNumber*(lengthOfHiuseNumber+1)/2;
		int totalOfHouseNumberFromFile = houseNumbers.stream().mapToInt(Integer::intValue).sum();
		int missingNumber  = totalOfHouseNumber - totalOfHouseNumberFromFile;
		return (missingNumber != 0);
	}

	@Override
	public boolean isHouseNumberStartsWithOne(final List<Integer> houseNumbers) {
		log.info("Validating isHouseNumberStartsWithOne");
		Collections.sort(houseNumbers);
		return (houseNumbers.get(0) != null && houseNumbers.get(0).intValue() == 1);
	}
}

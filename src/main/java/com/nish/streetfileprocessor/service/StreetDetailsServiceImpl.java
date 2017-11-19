package com.nish.streetfileprocessor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
/**
 * This is the business service implementation class
 * @author nismj
 *
 */
@Service
public class StreetDetailsServiceImpl implements StreetDetailsService{

	@Override
	public List<Integer> getNorthHouseNumbers(List<Integer> houseNumbers) {
		if(null == houseNumbers){
			return null;
		}
		return houseNumbers.stream().filter(houseNum -> houseNum % 2 != 0).collect(Collectors.toList());
	}

	@Override
	public List<Integer> getSouthHouseNumbers(List<Integer> houseNumbers) {
		if(null == houseNumbers){
			return null;
		}
		return houseNumbers.stream().filter(houseNum -> houseNum % 2 == 0).collect(Collectors.toList());
	}

}

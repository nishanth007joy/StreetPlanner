package com.nish.streetfileprocessor.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nish.streetfileprocessor.model.StreetModel;

@Service
public class NewspaperDeliveryServiceImpl implements NewspaperDeliveryService{

	@Override
	public List<Integer> generateNorthThenSouthDeliveryReport(StreetModel streetModel) {
		List<Integer> paperDeliveryList = new ArrayList<>();
		if(null != streetModel && streetModel.getNorthNumbers()!=null){
			paperDeliveryList.addAll(streetModel.getNorthNumbers());
		}
		if(null != streetModel && streetModel.getSouthNumbers()!=null){
			List<Integer> southNumbers = streetModel.getSouthNumbers();
			Collections.reverse(southNumbers);
			paperDeliveryList.addAll(southNumbers);
		}

		return paperDeliveryList;
	}

	@Override
	public List<Integer> generateEastWestDeliveryReport(StreetModel streetModel) {
		return streetModel.getHouseNumbers();
	}

	@Override
	public int numberOfTimeRoadCrossedInNothSouthDelivey(StreetModel streetModel) {

		return 1;
	}

	@Override
	public int numberOfTimeRoadCrossedInEastWestDelivery(StreetModel streetModel) {
		int numberOfCrossing = 0;
		boolean isNorthHouse = true;
		if(streetModel!=null && streetModel.getHouseNumbers()!=null){
			for(Integer houseNumber : streetModel.getHouseNumbers()){
				boolean isnextHouseNumberNoth = houseNumber % 2 != 0;
				if(isNorthHouse != isnextHouseNumberNoth){
					numberOfCrossing++;
					isNorthHouse = isnextHouseNumberNoth;
				}
			}
		}
		return numberOfCrossing;
	}

}

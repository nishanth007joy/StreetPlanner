package com.nish.streetfileprocessor.parser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 
 * @author nisha
 *
 */
@Component
public class StreetFileParserImpl implements StreetFileParser{
	private static final Logger log = LoggerFactory.getLogger(StreetFileParserImpl.class);
	@Override
	public List<Integer> parseHouseNumberFromSteetFile(String streetDetails) {
		log.debug("Entering parseHouseNumberFromSteetFile", streetDetails);
		if(streetDetails!=null && !streetDetails.isEmpty()){
			List<Integer> houseNumbers = Stream.of(streetDetails.split("\\s+"))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
			log.debug("Leaving parseHouseNumberFromSteetFile", houseNumbers);
			return Collections.unmodifiableList(houseNumbers);
		}
		
		return null;
	}
}

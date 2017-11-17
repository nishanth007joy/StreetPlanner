package com.nish.streetfileprocessor.parser;

import java.util.List;

public interface StreetFileParser {
	/**
	 * This function parse street details loaded from street.txt
	 * @param streetDetails
	 * @return
	 */
public List<Integer> parseHouseNumberFromSteetFile(String streetDetails);
}

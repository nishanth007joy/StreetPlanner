package com.nish.streetfileprocessor.parser;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class StreetFileParserImplTest {
	private StreetFileParser streetFileParser = new StreetFileParserImpl();
	@Test
	public void testParseHouseNumberFromSteetFile() {
		List<Integer> parsedhouseNumbers = streetFileParser.parseHouseNumberFromSteetFile("1 2 4 3 6 5 7 8 9 10 12 11 13 15 14");
		
		assertThat(parsedhouseNumbers, containsInAnyOrder(1,2,4,3,6,5,7,8,9,10,12,11,13,15,14));
	}

}

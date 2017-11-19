package com.nish.streetfileprocessor.reader;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nish.streetfileprocessor.basetest.BaseTest;
import com.nish.streetfileprocessor.exception.StreetFileProcessingException;

public class StreetFileReaderImplTest extends BaseTest{
	
	private StreetFileReader streetFileReader = new StreetFileReaderImpl();
	
	/**
	 * This chcecks values loaded from file is matching
	 */
	@Test
	public void testStreetFileRead() {
		String fileText = streetFileReader.readFile("src/test/resources/streetfile/input/street1.txt");
		assertEquals("1 2 4 3 6 5", fileText.trim());
	}
	/**
	 * This will check whether runtime exception is thrown when it can't fine the file
	 */
	@Test(expected=StreetFileProcessingException.class)
	public void testStreetFileReadWrongFile() {
		streetFileReader.readFile("src/test/resources/streetfile/input/street10.txt");
	}
}

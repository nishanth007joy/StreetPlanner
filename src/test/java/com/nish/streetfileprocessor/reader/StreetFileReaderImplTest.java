package com.nish.streetfileprocessor.reader;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nish.streetfileprocessor.exception.StreetFileProcessingException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreetFileReaderImplTest {
	@Autowired
	private StreetFileReader streetFileReader;
	
	@Before
	public void prepare() {
	    MockitoAnnotations.initMocks(this);
	}
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

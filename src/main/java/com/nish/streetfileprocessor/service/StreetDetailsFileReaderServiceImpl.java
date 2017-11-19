package com.nish.streetfileprocessor.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.streetfileprocessor.parser.StreetFileParser;
import com.nish.streetfileprocessor.processor.ProcessStreetFileImpl;
import com.nish.streetfileprocessor.reader.StreetFileReader;

@Service
public class StreetDetailsFileReaderServiceImpl implements StreetDetailsFileReaderService{
	private static final Logger log = LoggerFactory.getLogger(ProcessStreetFileImpl.class);
	@Autowired
	private StreetFileReader streetFileReader;
	
	@Autowired
	private StreetFileParser streetFileParser;
	
	@Override
	public String readStreetDetails(final String fileLocation) {
		String fileContent = streetFileReader.readFile(fileLocation);
		log.debug(fileContent);
		return fileContent;
	}

	@Override
	public List<Integer> parseStreetFileContent(String fileContent) {
		return streetFileParser.parseHouseNumberFromSteetFile(fileContent);
	}

}

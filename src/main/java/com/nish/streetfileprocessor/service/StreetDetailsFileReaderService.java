package com.nish.streetfileprocessor.service;

import java.util.List;

public interface StreetDetailsFileReaderService {
    /**
     * This method reads file from specified location with help of file reader component
     * 
     * @param fileName
     * @return
     */
    public String readStreetDetails(String fileLocation);

    /**
     * This method is the service method parse file contentg with help of file parser component
     * 
     * @param fileContent
     * @return
     */
    public List<Integer> parseStreetFileContent(String fileContent);
}

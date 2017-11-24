package com.nish.streetfileprocessor.writer;

/**
 * This deals with writing report
 * 
 * @author nisha
 *
 */
public interface OutputWriter {
    /**
     * This methods hold logic for saving processing report
     * 
     * @param reportText
     */
    public void writeProcessingReport(String reportText);

}

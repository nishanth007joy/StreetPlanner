package com.nish.streetfileprocessor.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nish.streetfileprocessor.exception.StreetFileProcessingException;

/**
 * 
 * @author nismj
 *
 */
@Component
public class OutputWriterImpl implements OutputWriter {
    private static final Logger log = LoggerFactory.getLogger(OutputWriterImpl.class);

    @Override
    public void writeProcessingReport(String reportText) {
        Path path = Paths.get("src/main/resources/streetfile/output/output.csv");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(reportText);
            writer.flush();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new StreetFileProcessingException("Error in writing report", e);
        }
    }
}

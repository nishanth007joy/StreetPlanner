package com.nish.streetfileprocessor.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nish.streetfileprocessor.exception.StreetFileProcessingException;

@Component
public class StreetFileReaderImpl implements StreetFileReader {
    private static final Logger log = LoggerFactory.getLogger(StreetFileReaderImpl.class);

    @Override
    public String readFile(String fileLocation) {
        StringBuilder contentBuilder = new StringBuilder();
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get(fileLocation), StandardCharsets.UTF_8);
            stream.forEach(s -> contentBuilder.append(s).append(" "));
            return contentBuilder.toString();
        } catch (IOException ioException) {
            log.error(ioException.getMessage(), ioException);
            throw new StreetFileProcessingException("Error in reading street file", ioException);
        } finally {
            if (stream != null)
                stream.close();
        }
    }

}

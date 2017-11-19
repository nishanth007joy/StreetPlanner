package com.nish.streetfileprocessor.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;


/**
 * 
 * @author nismj
 *
 */
@Component
public class OutputWriterImpl implements OutputWriter{



	@Override
	public void writeProcessingReport(String reportText) {
		Path path = Paths.get("src/main/resources/streetfile/output/output.csv");
		
		

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(reportText);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}

	}

}

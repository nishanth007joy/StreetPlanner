package com.nish.streetfileprocessor.steprunner;


import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nish.streetfileprocessor.StreetFileProcessorApplication;
import com.nish.streetfileprocessor.exception.StreetFileProcessingException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs{
	private static final Logger log = LoggerFactory.getLogger(StepDefs.class);

	private String output = null;
	private String action = null;


	@Given("^Input file is placed in input folder with \"([^\"]*)\" content$")
	public void input_file_is_placed_in_input_folder_with_content(String arg1) throws Throwable {
		Path path = Paths.get("src/main/resources/streetfile/input/street1.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(arg1);
			writer.flush();
		} catch (IOException e) {
			log.error(e.getMessage(),e);
			//throw new StreetFileProcessingException("Error in writing report", e);
		}

	}

	@When("^street file is processed with program input arument as \"([^\"]*)\"$")
	public void street_file_is_processed_with_program_input_arument_as(String arg1) throws Throwable {
		action = arg1;
		StreetFileProcessorApplication.main(new String[] { arg1 });
		output = readOutputContent();
		log.info("Output from file after execution is "+output);
	}

	
	private String  readOutputContent(){
		StringBuilder contentBuilder = new StringBuilder();
		Stream<String> stream = null;
		try 
		{
			stream = Files.lines( Paths.get("src/main/resources/streetfile/output/output.csv"), StandardCharsets.UTF_8);
			stream.forEach(s -> contentBuilder.append(s).append("&"));
			return contentBuilder.toString();
		} catch (IOException ioException) {
			log.error(ioException.getMessage(), ioException);
			throw new StreetFileProcessingException("Error in reading street file", ioException);
		}finally{
			if(stream!=null)
				stream.close();
		}
	}

	@Then("^North south roas crossing as  (\\d+)$")
	public void north_south_roas_crossing_as(int arg1) throws Throwable {
		int northSouthSeqRoadCrossing = Integer.parseInt(output.split("&")[1].split(",")[1]);
		
		assertEquals(arg1, northSouthSeqRoadCrossing);

	}
	
	@Then("^show file as valid with details of north south delivery as \"([^\"]*)\"$")
	public void show_file_as_valid_with_details_of_north_south_delivery_as(String arg1) throws Throwable {
		log.info("show file as valid with details of north south delivery as"+output);
		if(action != null && action.equalsIgnoreCase("--action=NEWS_PAPER_DELIVERY_REPORT")){
			String northSouthSeq = output.split("&")[1].split(",")[0];
			
			log.info("North South "+arg1);
			log.info("North South from file "+northSouthSeq);
			
			assertEquals(arg1, northSouthSeq);
		}
	}

	@Then("^East west delivery sequence as \"([^\"]*)\"$")
	public void east_west_delivery_sequence_as(String arg1) throws Throwable {
		if(action != null && action.equalsIgnoreCase("--action=NEWS_PAPER_DELIVERY_REPORT")){
			String northSouthSeq = output.split("&")[0].split(",")[0];
			
			log.info("East West "+arg1);
			log.info("East West from file "+northSouthSeq);
			
			assertEquals(arg1, northSouthSeq);
		}

	}

	@Then("^East west road crossing as (\\d+)$")
	public void east_west_road_crossing_as(int arg1) throws Throwable {
		if(action != null && action.equalsIgnoreCase("--action=NEWS_PAPER_DELIVERY_REPORT")){
			int northSouthSeqRoadCrossing = Integer.parseInt(output.split("&")[0].split(",")[1]);
			
			assertEquals(arg1, northSouthSeqRoadCrossing);
		}

	}

	@Then("^show output file valid as \"([^\"]*)\"$")
	public void show_output_file_valid_as(String arg1){
		log.info("File valid check with " + arg1);
		if(action != null && action.equalsIgnoreCase("--action=VALIDATE_AND_PROCESS")){
			String validationOut = output.split(",")[0];
			log.info(validationOut);
			assertEquals(arg1, validationOut);
		}

	}

	@Then("^House number as (\\d+)$")
	public void house_number_as(int arg1) throws Throwable {
		if(action != null && action.equalsIgnoreCase("--action=VALIDATE_AND_PROCESS")){
			int houseNumbers = 0;
			if(!output.split(",")[1].equalsIgnoreCase(""))
				houseNumbers = Integer.parseInt(output.split(",")[1]);
			assertEquals(arg1, houseNumbers);
		}
	}

	@Then("^North house number as (\\d+)$")
	public void north_house_number_as(int arg1) throws Throwable {
		int houseNumbers = 0;
		if(!output.split(",")[2].equalsIgnoreCase(""))
			houseNumbers = Integer.parseInt(output.split(",")[2]);
		assertEquals(arg1, houseNumbers);
	}

	@Then("^South house number as (\\d+)$")
	public void south_house_number_as(int arg1) throws Throwable {
		int houseNumbers = 0;
		if(!output.split(",")[3].equalsIgnoreCase(""))
			houseNumbers = Integer.parseInt(output.split(",")[3]);
		assertEquals(arg1, houseNumbers);

	}




}

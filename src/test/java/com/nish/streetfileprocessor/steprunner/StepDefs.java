package com.nish.streetfileprocessor.steprunner;


import org.junit.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.rule.OutputCapture;

import com.nish.streetfileprocessor.StreetFileProcessorApplication;
import com.nish.streetfileprocessor.steprunner.stepdef.base.SpringIntegrationTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs extends SpringIntegrationTest{
	private static final Logger log = LoggerFactory.getLogger(StepDefs.class);

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Given("^Input file is placed in input folder$")
	public void input_file_is_placed_in_input_folder() throws Throwable {

	}

	@When("^street file is processed$")
	public void street_file_is_processed() throws Throwable {
		StreetFileProcessorApplication.main(new String[] { "--action=VALIDATE_AND_PROCESS" });
	}

	@Then("^show file as valid$")
	public void show_file_as_valid() throws Throwable {
		log.info("entering ----------------");
		//String output = this.outputCapture.toString();
		//assertThat(!output.contains("Validation of file failed"));
	}
}

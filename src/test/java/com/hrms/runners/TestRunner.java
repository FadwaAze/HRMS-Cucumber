package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// here we run JUnit test
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", // specify which feature file to run
		// in our case we do say to run all features inside features package
		glue = "com/hrms/steps", // where we can find implementation code for gherkin steps?
		// we specify just package
		dryRun = true, // if set to true it will quickly scan that all gherkin steps have
						// implementation code
						// if set to true no actual execution will happen
						// if set to false than the actual test will run
		monochrome = true, // Translate the console data to more understandable info.
		//strict = true, // will fail your Scenario if there is one unimplemented / undefined step 
		tags = "@smoke or @regression" // will run only tests with @smoke tag //tags="@regression" //--> run only test
						// with @regression tags
                        // ={"sprint11, sprint12 , sprint13"}

)

//Background --> used to define steps that are common for all tests in the feature file

public class TestRunner {

}
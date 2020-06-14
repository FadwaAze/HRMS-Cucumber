package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)// this come from JUnit
@CucumberOptions(features = "src/test/resources/features/", 
		glue = "com/hrms/steps", 
		
		dryRun =false, 
		monochrome = true, 
		strict = true,  
		tags = "@reporting", 
		plugin= {
				"pretty",
				//"html:target/cucumber-default-report",
				"json:target/cucumber.json",
				"rerun:target/failed.txt"// generate all failed scenarios together 
		}

)


public class TestRunner {

}
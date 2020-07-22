package com.hrms.steps;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {// Block of code execute before and after scenarios
	
	@Before
	public void start() {
		BaseClass.setUp();
	}

	
	@After // will always execute even if there are fails in our tests
	public void end(Scenario scenario) {//Scenario is an interface 
		byte[]pic;
		if(scenario.isFailed()) {                 //scenario.getName will be the name of the screenshot
			pic=CommonMethods.takeScreenShot("failed/"+scenario.getName());
			
		}else {
			pic=CommonMethods.takeScreenShot("passed/"+scenario.getName());
		}
		scenario.attach(pic, "image/png", scenario.getName());
		BaseClass.tearDown();
	}
	
	

}

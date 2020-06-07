package com.hrms.steps;

import com.hrms.testbase.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {// Block of code execute before and after scenarios
	
	@Before
	public void sstart() {
		BaseClass.setUp();
	}

	
	@After // will always execute even if there are fails in our tests
	public void end() {
		BaseClass.tearDown();
	}
	
	

}

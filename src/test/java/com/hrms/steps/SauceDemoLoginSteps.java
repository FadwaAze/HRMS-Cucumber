package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLoginSteps extends CommonMethods{
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		BaseClass.driver.get(ConfigsReader.getProperty("url"));
	}

	@When("user enters invalid username")
	public void user_enters_invalid_username() {
		sendText(sauceLogin.userName, "Admin");
	    
	}

	@When("user enters invalid password")
	public void user_enters_invalid_password() {
		sendText(sauceLogin.password, "Admin@123"); 
	}

	@When("click on login button")
	public void click_on_login_button() {
		click(sauceLogin.LoginBTN);
	}

	@Then("user should see the error message")
	public void user_should_see_the_error_message() {
	    System.out.println("error message displayed");
	}
	
	
	@When("user enters invalid username as {string}")
	public void user_enters_invalid_username_as(String username) {
	    System.out.println(username);
	}

	@When("user enters invalid password as {string}")
	public void user_enters_invalid_password_as(String password) {
		System.out.println(password);
	    
	}
	
	@When("user validates below paragraph")
	public void user_validates_below_paragraph(String docString) {
	    System.out.println("User validate: Each day has a promise to brighten up the day you must first let the sun come your way");
	}

	@When("user enters invalid username as username as below")
	public void user_enters_invalid_username_as_username_as_bellow(DataTable dataT) {
	    for(Map<String, String> data : dataT.asMaps()){
	    
	    	//System.out.println(data.get("username");
			
		}
	}

}

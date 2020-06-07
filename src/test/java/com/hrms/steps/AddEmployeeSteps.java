package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddEmployeeSteps extends CommonMethods {
	@When("user enters employees first name and last name")
	public void user_enters_employees_first_name_and_last_name() {
		dashboard.navigateToAddEmployee();
		sendText(addEmp.firstName, ConfigsReader.getProperty("firstname"));
		sendText(addEmp.lastName, ConfigsReader.getProperty("lastname"));
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		click(addEmp.saveBtn);
	}

	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
	    String expectedEmpName="Fadwa Azer";
	    String actualEmpName=dashboard.welcome.getText();
	    Assert.assertEquals(" Employee First name and Last name is not added ",expectedEmpName, actualEmpName);
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
	    addEmp.employeeId.clear();
	}

	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
	    click(addEmp.checkboxLoginDetails);
	}

	@When("user enters login credentials")
	public void user_enters_login_credentials() {
	   sendText(addEmp.username, "FadwaAz");
	   sendText(addEmp.password,"Syntax123@");
	   sendText(addEmp.confirmPassword,"Syntax123@");
	   click(addEmp.saveBtn);
	   
	}

}

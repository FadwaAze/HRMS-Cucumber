package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModifyEMployeesteps extends CommonMethods{

	@When("user add employee and employee is displayed succssfully")
	public void user_add_employee_and_employee_is_displayed_succssfully(DataTable dataTable) {
		List<Map<String, String>> addNewEmp = dataTable.asMaps();

		for (Map<String, String> map : addNewEmp) {
			String fName = map.get("FirstName");
			String mName = map.get("MiddleName");
			String lName = map.get("LastName");
			
			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));
			
			click(addEmp.saveBtn);
			
			String actual=pDetails.profilePic.getText();
			String expected=fName+" "+mName+" "+lName;
			Assert.assertEquals("Employee is not added successfully", expected, actual );

		}

	}

	@Then("user updates employee personal details then employee is updated")
	public void user_updates_employee_personal_details_then_employee_is_updated(DataTable dataTable) {
           List<Map<String, String>> modifyEmp = dataTable.asMaps();
           for (Map<String, String> map : modifyEmp) {
        	   
        	   String expectedEmp=pDetails.employeeId.getAttribute("value");
        	   
        	   click(pDetails.editBtn);
        	   
        	   sendText(pDetails.licenseExpiryDate, map.get("License Expiry Date "));
        	   sendText(pDetails.ssnNum, map.get("SSN"));
        	   sendText(pDetails.sinNum, map.get("SIN"));
        	   wait(2);
        	   
        	   selectDdValue(pDetails.maritalStatus, map.get("Marital Status"));
        	   
        	   wait(3);
        	   selectDdValue(pDetails.nationalityDD, map.get("Nationality"));
        	   wait(2);
        	   sendText(pDetails.DOB, map.get("Date of Birth"));
        	   pDetails.DOB.sendKeys(Keys.ENTER);
        	   wait(2);
        	   
        	   sendText(pDetails.nickName, map.get("Nick Name"));
        	   sendText(pDetails.militarySer, map.get("Military Service"));
        	   wait(3);
        	   
        	   click(pDetails.saveBtn);
        	   takeScreenShot("Add & Modify Emp Info");
        	   
        	   String actualEmp=pDetails.employeeId.getAttribute("value");
        	   
        	   
        	   
        	   Assert.assertTrue("employe personal Details is not added successfuly ", expectedEmp.equals(actualEmp));
        	   
			
		}
	}

}

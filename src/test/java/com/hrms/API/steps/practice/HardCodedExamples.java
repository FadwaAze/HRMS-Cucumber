package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import org.junit.*;
import org.junit.runners.MethodSorters;
/**
 * We may use below - please comment out
 */
//import org.apache.hc.core5.http.ContentType;

/**
 *This @FixMethodOrder(MethodSorters.NAME_ASCENDING) will execute @Test annotation in ascending 
 *alphabetical order
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {
	/**
	 * Rest Assured
	 * 
	 * given - prepare your request when - you are making the call to the endPoint
	 * then - validating
	 * 
	 * @param args
	 */

	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg1MzUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMTczNSwidXNlcklkIjoiNjUxIn0.YY2YlrdhiKeZIBdZ520se5Ru0Ff0vDghafszVuhS-pI";
	static String employeeID;

//	public static void main(String[] args) {
//		/**
//		 * BaseURI for all calls
//		 */
//		
//		RestAssured.baseURI= "http://18.232.148.34/syntaxapi/api";
//		
//		/**
//		 * JWT required for all calls - expires every 12 hours
//		 */
//		
//		String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUwOTQ4MzYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTEzODAzNiwidXNlcklkIjoiNjUxIn0.-Rg3uPz-2wTeiwL4qKziBxcK7oGudEi-9VgzhtrPlJg";
//		
//		/**
//		 * 
//		 * Preparing /getOneEmployee.php request
//		 * .log().all() --> print all details info about the call when used with get
//		 */
//		RequestSpecification getOneEmployeeRequest = given().header("Content-Type","application/json")
//				.header("Authorization", token).queryParam("employee_id","16239A").log().all();
//		
//		/**
//		 *Storing response
//		 */
//		
//		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
//	
//		/**
//		 * Two ways to print response
//		 * prety print() method converts JSON object into String and prints - no need to SOP
//		 */
//		
//		 getOneEmployeeResponse.prettyPrint();
//		 //String response = getOneEmployeeResponse.body().asString();
//		 //System.out.println(response);
//		
//		 /**
//		  *Verifying response status code is 200
//		  */
//		 getOneEmployeeResponse.then().assertThat().statusCode(200);
//		
//	}

	public void sampleTest() {
		/**
		 * BaseURI for all calls
		 */

		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		/**
		 * JWT required for all calls - expires every 12 hours
		 */

		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg1MzUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMTczNSwidXNlcklkIjoiNjUxIn0.YY2YlrdhiKeZIBdZ520se5Ru0Ff0vDghafszVuhS-pI";

		/**
		 * 
		 * Preparing /getOneEmployee.php request .log().all() --> print all details info
		 * about the call when used with get
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16239A").log().all();

		/**
		 * Storing response
		 */

		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");

		/**
		 * Two ways to print response pretty print() method converts JSON object into
		 * String and prints - no need to SOP
		 */

		getOneEmployeeResponse.prettyPrint();
		// String response = getOneEmployeeResponse.body().asString();
		// System.out.println(response);

		/**
		 * Verifying response status code is 200
		 */
		getOneEmployeeResponse.then().assertThat().statusCode(200);

	}

	public void sampleTestNotes() {

	}

	@Test
	public void aPOSTcreateEmployee() {
		/**
		 * Preparing request for /createEmployee.php
		 */
		RequestSpecification CreateEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\n" + "  \"emp_firstname\": \"Sophia\",\n" + "  \"emp_lastname\": \"Smith\",\n"
						+ "  \"emp_middle_name\": \"SS\",\n" + "  \"emp_gender\": \"F\",\n"
						+ "  \"emp_birthday\": \"1999-07-11\",\n" + "  \"emp_status\": \"Employee\",\n"
						+ "  \"emp_job_title\": \"IT Support Manager\"\n" + "}")
				.log().all();
		/**
		 * Storing response into CreateEmployeeResponse
		 */
		Response CreateEmployeeResponse = CreateEmployeeRequest.when().post("/createEmployee.php");

		/**
		 * Printing response using prettyPrint() method
		 */
		CreateEmployeeResponse.prettyPrint();

		/**
		 * jsonPath() to view response body which lets us get the employee ID we store
		 * employee ID as a global variable so that we may we use it
		 * 
		 */
		employeeID = CreateEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		System.out.println(employeeID);

		/**
		 * Verifying response status code is 201
		 */
		CreateEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * we have to import org.hamcrest.Matchers.*; manually --> does not come with
		 * the error as option to import Verifying message using equalTo() method -
		 * manually import the library
		 */

		CreateEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		/**
		 * Verifying bodu contains first name and server header content using
		 * then().header().
		 */
		CreateEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Sophia"));
		CreateEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		CreateEmployeeResponse.then().header("Content-Type", "application/json");
		CreateEmployeeResponse.then().header("Access-Control-Allow-Headers",
				"Access-Control-Allow-Headers,Content-Type,Access-Control-Allow-Methods, Authorization, X-Requested-With");

		/**
		 * Verifying header content using assertThat().header()
		 */
		CreateEmployeeResponse.then().assertThat().header("X-Powered-By", "PHP/7.2.18");

	}

	@Test
	public void bGETcreateEmployee() {
		/**
		 * Preparing request for /getOneEmployee.php
		 */
		RequestSpecification getCreateEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();

		/**
		 * Making call to retrieve created employee
		 */
		Response getCreatedEmployeeResponse = getCreateEmployeeRequest.when().get("/getOneEmployee.php");

		String response = getCreatedEmployeeResponse.prettyPrint();
		/**
		 * Storing response employeeID into empID which will be used for verification
		 * against stored global EmployeeID
		 */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		System.out.println(empID);
		/**
		 * Matching exact employeeID's
		 */
		boolean verifyingEmployeeIDMatch = empID.equalsIgnoreCase(employeeID);
		System.out.println("Employee ID's match : "+verifyingEmployeeIDMatch);

		/**
		 * Asserting employee ID's match
		 */
		Assert.assertTrue(verifyingEmployeeIDMatch);
		/**
		 *Verifying status code is 200 
		 */
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);
		
	System.out.println("=============Using Json class to retrieve values=============== ");
		/**
		 * Using Json class to retrieve values from response body as string
		 */
		
		JsonPath js = new JsonPath(response);
		String emplID = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String lastName = js.getString("employee[0].emp_lastname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String empBDay = js.getString("employee[0].emp_birthday");
		String empGender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String empStatus = js.getString("employee[0].emp_status");

		System.out.println(emplID);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(middleName);
		System.out.println(empBDay);
		
		System.out.println("============== Verifying expected employee details match actual employee details==========================");
		Assert.assertTrue(emplID.contentEquals(employeeID));
		// second way of asserting only for employeeID since we store it as variable
		Assert.assertEquals(employeeID, emplID);
		
		Assert.assertTrue(firstName.contentEquals("Sophia"));
		Assert.assertTrue(lastName.contentEquals("Smith"));
		Assert.assertTrue(middleName.contentEquals("SS"));
		Assert.assertTrue(empBDay.contentEquals("1999-07-11"));
		Assert.assertTrue(empGender.contentEquals("Female"));
		Assert.assertTrue(jobTitle.contentEquals("IT Support Manager"));
		Assert.assertTrue(empStatus.contentEquals("Employee"));	
		
	}
	
	@Test
	public void cGETallEmployee() {
		/**
		 * Preparing /getAllEmployees.php request
		 */
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type","application/json").header("Authorization",token);
	
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");
		/**
		 * Printing all employees
		 */
		//getAllEmployeesResponse.prettyPrint();
		String allEmployee = getAllEmployeesResponse .body().asString();
		System.out.println(allEmployee);
		
		/**
		 * this will pass but incorrect
		 */
		//allEmployees.contains(employeeID);
		
		/**
		 * Retrieving size of employees list 
		 */
		JsonPath js = new JsonPath(allEmployee);
		int sizeOfList = js.getInt("Employees.size()");
		System.out.println(sizeOfList);
		
		/**
		 * Print out all employee ID's
		 * if statement inside for loop to find stored employee ID and break the loop when found
		 */
		
		for(int i=0; i<sizeOfList; i++) {
			
			// ["+i+"] --> We concatenate i to increment otherwise inside quotes it will be hardcoded
			String allEmployeeIDs = js.getString("Employees["+i+"].employee_id");
			//System.out.println(allEmployeeIDs);
			
			
			/**
			 * iterate and print the employeeID we store as variable
			 */
			
			if(allEmployeeIDs.contentEquals(employeeID)) {
				System.out.println("EMployee ID : "+employeeID+ " is present in body");
				String employeeFirstName = js.getString("Employees["+i+"].emp_firstname");
				System.out.println(employeeFirstName);
				break;
			}			
		}
		
		
		
		
		
		
	}

	@Test
	public void dPUTupdatedCreatedEmployee() {
		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).body(HardcodeContants.updateCreatedEmpBody());
		
		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
		String response = updateCreatedEmployeeResponse.prettyPrint();
		System.out.println(response);
	}
}



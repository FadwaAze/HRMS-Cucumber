package com.hrms.API.steps.practice;

public class HardcodeContants {
	
	public static String updateCreatedEmpBody() {
		String updateBody ="{\n" + 
				"  \"employee_id\": \""+HardCodedExamples.employeeID+"\",\n" + 
				"  \"emp_firstname\": \"Samia\",\n" + 
				"  \"emp_lastname\": \"Alexie\",\n" + 
				"  \"emp_middle_name\": \"SS\",\n" + 
				"  \"emp_gender\": \"F\",\n" + 
				"  \"emp_birthday\": \"1999-07-11\",\n" + 
				"  \"emp_status\": \"Employee\",\n" + 
				"  \"emp_job_title\": \"Application Developer\"\n" + 
				"}";
		return updateBody;
		
	}

}

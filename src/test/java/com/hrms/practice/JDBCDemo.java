package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo {
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	
	// jdbc: driver type:hostname: port/db name
	
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test   // will execute our test 
	public void abc() throws SQLException {
		//create connection between eclipse and DB --> sql exception if any connection failed
		Connection conn= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("BD connection is successful");
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from hs_hr_employees");
		//move the cursor
		rs.next();
		String firstname=rs.getString("emp_firstname");
		
		System.out.println(firstname);
		rs.next();
		String firstname2= rs.getObject("emp_firstname").toString(); // --> same as String firstname2=rs.getString("emp_firstname");
		System.out.println(firstname2);
		
		String allData;
		while(rs.next()){
			allData=rs.getObject("emp_firstname").toString();
			System.out.println(allData);
		}
		// close all db connection
		rs.close();// close resultSet
		st.close(); // close statement
		conn.close(); // close the whole connection between Eclipse and DataBase to protect data

	
	
	
	
	}
	

}

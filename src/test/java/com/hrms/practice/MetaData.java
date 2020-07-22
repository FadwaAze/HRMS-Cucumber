package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;



public class MetaData {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";

	// jdbc: driver type:hostname: port/db name

	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	//@Test
	public void dbMetadata() throws SQLException {
		// create connection between eclipse and DB --> sql exception if any connection
		// failed
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		// an interface that provide addition info about our data Base
		DatabaseMetaData dbMetaData= conn.getMetaData();
		String driverName=dbMetaData.getDriverName();
		
		String dbVersion =dbMetaData.getDatabaseProductVersion();
		System.out.println(driverName);
		System.out.println(dbVersion);
		
	}
	
	// query display all info about employee whose emp_number is 14688
	@Test
	public void rsMetadata() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees where emp_number = 14688");
		
		// with ResultSetMetaData ---> able to return extra data of resultset
		
		ResultSetMetaData rsMetadata = rs.getMetaData();
		int colNum=rsMetadata.getColumnCount();
		System.out.println(colNum);
		
		String colName1=rsMetadata.getColumnLabel(1);
		System.out.println(colName1);
		// retrieve all column names 
		for (int i=1; i<=colNum; i++) {
			String colNames=rsMetadata.getColumnName(i);
			System.out.println(colNames);
		}
		
	}
	
}

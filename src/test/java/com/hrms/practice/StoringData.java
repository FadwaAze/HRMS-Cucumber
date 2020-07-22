package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StoringData {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";

	// jdbc: driver type:hostname: port/db name

	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	// @Test
	public void getAndStoreData() throws SQLException {
		// 1- create connection
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id, name,country_code from ohrm_location");

		// Retrieveing all the data
		List<Map<String, String>> listOfdata = new ArrayList<>();

		// need another map in order to store data in side while loop
		Map<String, String> mapData;

		// we use while loop because we don't know how many time we need to iterate-->
		// so no for loop
		while (rs.next()) {
			// use Linked hashMap to retrieve data in order
			// we need to initialize our mapData here bcz we need to initialize new map for
			// each unique id on each while loop
			// if we put it outside we will have ONLY ONE id value, country and name values
			// that will be overwritten
			mapData = new LinkedHashMap<>();
			mapData.put("Location id", rs.getObject("id").toString());
			// System.out.println(mapData);
			mapData.put("Office name", rs.getObject("name").toString());
			// System.out.println(mapData);
			mapData.put("Country code ", rs.getObject("country_code").toString());
			System.out.println(mapData);

			// on each iteration add it to our list of map
			listOfdata.add(mapData);
		}
		System.out.println(listOfdata);

		rs.close();
		st.close();
		conn.close();

	}

	//@Test
	public void retieveAndStoreDataEnhance() throws SQLException {
		// 1- create connection, Statement, and Result objects
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title");
		// get column name and column count : data about data = metadata
		// that's why we use ResultSetMetaData
		ResultSetMetaData rsMetaData = rs.getMetaData();

		List<Map<String, String>> listData = new ArrayList<>(); // we use Array List to initialize the List of Maps
		// create seprate map to store it inside the list
		Map<String, String> mapData;

		while (rs.next()) {// iterate trough rows
			// to avoid overwrite our data we need to create new map every time we iterate
			mapData = new LinkedHashMap<>();
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {// iterate through columns
				// --> get ColumnName will get only clumn name as key
				// --> getObject to get the actual data
				mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			}
			listData.add(mapData);
		}
		System.out.println(listData);
		rs.close();
		st.close();
		conn.close();

	}
	// display all the info from nationality table
	// but display id "nationality id ", name ="nationality"

	@Test
	public void taskEnhanceMethod() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_nationality;");
		
		ResultSetMetaData rsMetaData=rs.getMetaData();
		
		List<Map<String, String>> listData= new ArrayList<>();
		Map<String, String>  mapData;
		
		while(rs.next()){
			mapData =new LinkedHashMap<>();
			for(int i=1; i<=rsMetaData.getColumnCount(); i++) {
				mapData.put("nationality_id "+rsMetaData.getColumnName(i),"nationality "+rs.getObject(i).toString());
			}
			listData.add(mapData);
		}
		System.out.println(listData);
	}

}

package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Task {
	
	// retrieve all the job titles and store them in arrayList and display in console
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	
	// jdbc: driver type:hostname: port/db name
	
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	@Test
    public void AlijonTask() throws SQLException {
        Connection c=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement st=c.createStatement();
        ResultSet rslt=st.executeQuery("select * from ohrm_job_title");
        
        List <String> arrData = new ArrayList<>();
        
        while(rslt.next()){
            arrData.add(rslt.getString("job_title"));
        }
        System.out.println(arrData.toString());
        
        for(String data:arrData) {
            System.out.println(data);
        }
    }

}

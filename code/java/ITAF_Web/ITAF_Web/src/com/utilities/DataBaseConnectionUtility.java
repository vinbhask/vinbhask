package com.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import library.UtilLib;

public class DataBaseConnectionUtility {
	
    
    public  Statement getConnection(String Environment){
    	Statement stmt=null;
    	if(Environment.equalsIgnoreCase("Oracle")){
    		try{
    		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    		//oracleProdDBURL = "jdbc:oracle:thin:@//"+UtilLib.getEnvVar("oracleDBHostName");
    		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@"+UtilLib.getEnvVar("oracleDBHostName"), UtilLib.getEnvCredentials("oracleDBUsername"), UtilLib.decrypt(UtilLib.getEnvCredentials("oracleDBPassword")));
    	    stmt = conn.createStatement();
    	    
    		}
    		
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	else if(Environment.equalsIgnoreCase("Postgres")){
    		try{
    			Class.forName("org.postgresql.Driver");
		    	  Connection connection = null;
		    	  connection = DriverManager.getConnection("jdbc:postgresql://"+UtilLib.getEnvVar("postgresDBURL"),UtilLib.getEnvCredentials("postgresDBUsername"), UtilLib.decrypt(UtilLib.getEnvCredentials("postgresDBPassword"))); 
		    	  stmt = connection.createStatement();
    	    
    		}
    		
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
		return stmt;
    	
    	
    }
}

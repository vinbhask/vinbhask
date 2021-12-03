package com.implementations;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import com.beans.ShowDetails;

import com.utilities.DataBaseConnectionUtility;

public class FetchDatabaseDetailsDAO {
	 static Statement stmt=null;
	 static ResultSet RS=null;
	 static ResultSet TargetRS=null;
	 	
	public static ResultSet getDatabaseDetails(String Environment){
		
		DataBaseConnectionUtility fetchDetails =new DataBaseConnectionUtility();
		if(Environment.equalsIgnoreCase("Oracle")){
			try{
				stmt=fetchDetails.getConnection("Oracle");
				String OracleQuery="SELECT USERNAME FROM ALL_USERS ORDER BY USERNAME";
				RS = stmt.executeQuery(OracleQuery);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(Environment.equalsIgnoreCase("Postgres")){
			try{
				stmt=fetchDetails.getConnection("Postgres");
				String PostgresQuery="SELECT NSPNAME FROM PG_CATALOG.PG_NAMESPACE ORDER BY NSPNAME";
				RS = stmt.executeQuery(PostgresQuery);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return RS;
		
		
	}
	
public static ResultSet getTableDetails(String Schema, String Environment){
		
		DataBaseConnectionUtility fetchDetails =new DataBaseConnectionUtility();
		if(Environment.equalsIgnoreCase("Oracle")){
			try{
				stmt=fetchDetails.getConnection("Oracle");
				String OracleQuery="SELECT TABLE_NAME FROM ALL_TABLES WHERE OWNER="+"'" + Schema + "'";
				//System.out.println(OracleQuery);
				RS = stmt.executeQuery(OracleQuery);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
		if(Environment.equalsIgnoreCase("Postgres")){
			try{
				stmt=fetchDetails.getConnection("Postgres");
				String PostgresQuery="SELECT TABLE_NAME FROM information_schema.tables WHERE table_schema = "+"'" + Schema + "'";
				//System.out.println(PostgresQuery);
				RS = stmt.executeQuery(PostgresQuery);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
			return RS;	
	}

public static ResultSet getColumnDetails(String Table,String Environment){
	
	DataBaseConnectionUtility fetchDetails =new DataBaseConnectionUtility();
		if(Environment.equalsIgnoreCase("Oracle")){
		try{
			stmt=fetchDetails.getConnection("Oracle");
			String OracleQuery="SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = "+"'" + Table + "'";
			//System.out.println(OracleQuery);
			RS = stmt.executeQuery(OracleQuery);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}}
		if(Environment.equalsIgnoreCase("Postgres")){
			try{
				stmt=fetchDetails.getConnection("Postgres");
				String PostgresQuery="SELECT COLUMN_NAME FROM information_schema.columns WHERE table_name   = "+"'" + Table + "'";
				//System.out.println(PostgresQuery);
				RS = stmt.executeQuery(PostgresQuery);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
		return RS;	
}

public static void createTableInTarget(String TableName,String ColsNDataTypes, String Environment){
	DataBaseConnectionUtility fetchDetails =new DataBaseConnectionUtility();
	try{
		if(Environment.equalsIgnoreCase("Source")){
		stmt=fetchDetails.getConnection("Postgres");
		String PostgresQuery="Create table "+"\""+"Reports"+"\""+"."+"\""+TableName+"_SRC"+"\""+"( "+ColsNDataTypes.replaceAll(",$", "")+")";
		//System.out.println(PostgresQuery);
		stmt.executeUpdate(PostgresQuery);
		}
		if(Environment.equalsIgnoreCase("Target")){
			stmt=fetchDetails.getConnection("Postgres");
			String PostgresQuery="Create table "+"\""+"Reports"+"\""+"."+"\""+TableName+"_TGT"+"\""+"( "+ColsNDataTypes.replaceAll(",$", "")+")";
			//System.out.println(PostgresQuery);
			stmt.executeUpdate(PostgresQuery);
			}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
public static void insertIntoTestCaseTable(String Query){
	DataBaseConnectionUtility insertDetails =new DataBaseConnectionUtility();
	try{
		stmt=insertDetails.getConnection("Postgres");
		
		//System.out.println(Query);
		stmt.executeUpdate(Query);
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList displayAllExistingTests(){
	DataBaseConnectionUtility displayDetails =new DataBaseConnectionUtility();
	ArrayList testCaseDetails=new ArrayList();
	try{
		stmt=displayDetails.getConnection("Postgres");
		String PostgresQuery="SELECT "+"\"" +"testcasename"+"\"" +","+"\"" +"sourcetablename"+"\"" +","+"\""+"targettablename"+"\""+","+"\"" +"sourcequery"+"\"" +","+"\"" +"targetquery"+"\"" +","+"\"" +"type"+"\""+ " FROM "+"\"" +"Reports"+"\""+"."+"\"" +"TESTCASE_MAPPING"+"\"";
		//System.out.println("All TestcaseQuery: "+PostgresQuery);
		RS = stmt.executeQuery(PostgresQuery);
		
		while (RS.next ()){

			  //Add records into data list

			testCaseDetails.add(new ShowDetails(RS.getString("TestCaseName"),RS.getString("SourceTableName"),RS.getString("TargetTableName"),RS.getString("SourceQuery"),RS.getString("TargetQuery"),RS.getString("Type")));

			  }

		System.out.println(testCaseDetails);
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return testCaseDetails;
}

public static ResultSet columnDetails(String TestCaseName){
	DataBaseConnectionUtility displayDetails =new DataBaseConnectionUtility();

	try{
		stmt=displayDetails.getConnection("Postgres");
		String PostgresQuery="SELECT "+"\"" +"testcasename"+"\"" +","+"\"" +"sourcetablename"+"\"" +","+"\""+"targettablename"+"\""+","+"\"" +"sourcepk"+"\""+","+"\"" +"targetpk"+"\"" +","+"\"" +"sourcecolumns"+"\"" +","+"\"" +"targetcolumns"+"\"" +","+"\"" +"type"+"\""+ " FROM "+"\"" +"Reports"+"\""+"."+"\"" +"TESTCASE_MAPPING"+"\""+" WHERE testcasename in ("+TestCaseName+")";
		//System.out.println("All TestcaseQuery: "+PostgresQuery);
		RS = stmt.executeQuery(PostgresQuery);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return RS;
	
}
public static void getData(String Environment, String Query, String TableName){
	DataBaseConnectionUtility fetchDetails =new DataBaseConnectionUtility();
	
	if(Environment.equalsIgnoreCase("Oracle")){
		try{
			String rowVal="";
			String colnVal="";
			
			final int batchSize = 1000;
			int count = 0;
			stmt=fetchDetails.getConnection("Oracle");
			Statement postgresstmt = fetchDetails.getConnection("Postgres");
			//String OracleQuery="SELECT USERNAME FROM ALL_USERS ORDER BY USERNAME";
			RS = stmt.executeQuery(Query);
			ResultSetMetaData srcrsmd = RS.getMetaData();
		    int srcnumCols = srcrsmd.getColumnCount();
		    /****** Insert the Data *******/
		    while (RS.next()) {
		    	//Print one row          
		    	for(int i = 1 ; i <= srcnumCols; i++){
		    	      //System.out.print(orares.getString(i) + " "); //Print one element of a row
		    		colnVal=colnVal+"'"+((RS.getString(i) == null) ? "" : RS.getString(i).trim().replace(".0", "").replaceAll("null", ""))+"'"+",";
		    	}
		    	rowVal=rowVal+" SELECT "+colnVal.replaceAll(",$", "")+" union all ";
		    	colnVal="";
		    		    	
		    	if(++count % batchSize == 0) {
		    		String InsertQuery="INSERT INTO "+"\""+"Reports"+"\""+"."+"\""+TableName+"_SRC"+"\""+rowVal.replaceAll(" union all $", "");
		    		//System.out.println(InsertQuery);
					postgresstmt.executeUpdate(InsertQuery);
					System.out.println("[Info]: "+count+" source records have been written to source table");
					rowVal="";
					count=0;
				}
		    	
		    	  //System.out.println();//Move to the next line to print the next row.           
		    	    }
		    if(rowVal.length()>0){
		    	String InsertQuery="INSERT INTO "+"\""+"Reports"+"\""+"."+"\""+TableName+"_SRC"+"\""+rowVal.replaceAll(" union all $", "");
		    	//System.out.println(InsertQuery);
		    	postgresstmt.executeUpdate(InsertQuery);
			  }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	 if(Environment.equalsIgnoreCase("Postgres")){
		try{
			String rowVal1="";
			Statement stmt=null;
			stmt=fetchDetails.getConnection("Postgres");
			Statement postgresstmt = fetchDetails.getConnection("Postgres");
			String colnVal1="";
			ResultSet postgress = null;
			final int batchSize = 1000;
			int count = 0;
			stmt=fetchDetails.getConnection("Postgres");
			
			
			postgress = stmt.executeQuery(Query);
			ResultSetMetaData postgressrmd = postgress.getMetaData();
		    
		    int tgtnumCols = postgressrmd.getColumnCount();
		  
		   
		   
		   /****** Insert the Data IN TO TARGET *******/
			
		    while (postgress.next()) {
		    	//Print one row  
		    	
		    	for(int i = 1 ; i <= tgtnumCols; i++){
		    	
		    	      //System.out.print(orares.getString(i) + " "); //Print one element of a row
		    		colnVal1=colnVal1+"'"+((postgress.getString(i) == null) ? "" : postgress.getString(i).trim().replace(".0", "").replaceAll("null", ""))+"'"+",";
		    	}
		    	rowVal1=rowVal1+" SELECT "+colnVal1.replaceAll(",$", "")+" union all ";
		    	colnVal1="";
		    		    	
		    	if(++count % batchSize == 0) {
		    		String InsertQuery="INSERT INTO "+"\""+"Reports"+"\""+"."+"\""+TableName+"_TGT"+"\""+rowVal1.replaceAll(" union all $", "");
		    		//System.out.println(InsertQuery);
		    		postgresstmt.executeUpdate(InsertQuery);
					System.out.println("[Info]: "+count+" target records have been written to target table");
					rowVal1="";
					count=0;
				}
		    	
		    	  //System.out.println();//Move to the next line to print the next row.           
		    	    }
		    if(rowVal1.length()>0){
		    	String InsertQuery="INSERT INTO "+"\""+"Reports"+"\""+"."+"\""+TableName+"_TGT"+"\""+rowVal1.replaceAll(" union all $", "");
		    	//System.out.println(InsertQuery);
		    	postgresstmt.executeUpdate(InsertQuery);
			  }
		   
		    System.out.println("** Target table created and loaded... proceeding with comparison... **");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

}

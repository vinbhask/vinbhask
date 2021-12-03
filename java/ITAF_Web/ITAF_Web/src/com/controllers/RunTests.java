package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.implementations.FetchDatabaseDetailsDAO;
import com.utilities.DataBaseConnectionUtility;

/**
 * Servlet implementation class RunTests
 */
@WebServlet("/RunTests")
public class RunTests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunTests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    static ResultSet srccountsres=null;
	static ResultSet tgtcountsres=null;
	static String srcCount="";
	static String tgtCount="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String[] Testcases=request.getParameterValues("ExistingTestCases");
		String SourceColumns="";
		String TargetColumns="";
		String SourceTableName="";
		String TargetTableName="";
		String TestCaseNames="";
		String TestCaseName="";
		String SourcePK="";
		String TargetPK="";
		String Type="";
		String SourcecolnDT="";
		String TargetcolnDT="";
		String SourceQuery="";
		String TargetQuery="";
		String CountsCheckStatus="";
		
		
		for(String s:Testcases){
			TestCaseNames+="'"+s+"'"+",";
		}
		ResultSet TestCaseDetails=FetchDatabaseDetailsDAO.columnDetails(TestCaseNames.replaceAll(",$", ""));
		
		try{
		while(TestCaseDetails.next()){
			TestCaseName=TestCaseDetails.getString(1);
			SourceTableName=TestCaseDetails.getString(2);
			TargetTableName=TestCaseDetails.getString(3);
			SourcePK=TestCaseDetails.getString(4);
			TargetPK=TestCaseDetails.getString(5);
			SourceColumns=TestCaseDetails.getString(6);
			TargetColumns=TestCaseDetails.getString(7);
			Type=TestCaseDetails.getString(8);
			SourcecolnDT=SourcePK+" character varying(150),";
			TargetcolnDT=TargetPK+" character varying(150),";
			
			for(String cols: SourceColumns.split(",")){
				SourcecolnDT=SourcecolnDT+cols+" character varying(150),";
				TargetcolnDT=TargetcolnDT+cols+" character varying(150),";
				}
			SourceQuery="SELECT "+SourcePK+","+SourceColumns.replaceAll(",$", "")+" FROM "+SourceTableName;
			//System.out.println(SourceQuery);
			FetchDatabaseDetailsDAO.createTableInTarget(SourceTableName, SourcecolnDT, "Source");
			FetchDatabaseDetailsDAO.getData("Oracle", SourceQuery, SourceTableName);
			DataBaseConnectionUtility fetchDetails =new DataBaseConnectionUtility();
			Statement postgresstmt = fetchDetails.getConnection("Postgres");
			TargetQuery="SELECT "+TargetPK+","+TargetColumns.replaceAll(",$", "")+" FROM "+"\""+"Reports"+"\""+"."+"\""+TargetTableName+"\"";
			//System.out.println(TargetQuery);
			FetchDatabaseDetailsDAO.createTableInTarget(TargetTableName, TargetcolnDT, "Target");
			FetchDatabaseDetailsDAO.getData("Postgres", TargetQuery, TargetTableName);
			final String SrcCountsQuery;
			final String TgtCountsQuery;
			final String MissingPKsQuery;
			SrcCountsQuery="select count(distinct "+SourcePK+")"+" from "+"\""+"Reports"+"\""+"."+"\""+SourceTableName+"_SRC"+"\"" ;
			TgtCountsQuery="select count(distinct "+TargetPK+")"+" from "+"\""+"Reports"+"\""+"."+"\""+TargetTableName+"_TGT"+"\"" ;
			MissingPKsQuery=" SELECT "
					+"'" + Type + "'"+" AS TYPE,"
					+"'" + TestCaseName + "'"+" AS TESTCASENAME,"
					+ SourcePK +" AS SourcePK"
					+" FROM "
					+"\""+"Reports"+"\""+"."+"\""+SourceTableName+"_SRC"+"\""
					+" WHERE "
					+ SourcePK + " NOT IN(SELECT DISTINCT "+TargetPK+" from "+"\""+"Reports"+"\""+"."+"\""+TargetTableName+"_TGT"+"\""+")" ;
			//System.out.println("MissingPKQuery: "+MissingPKsQuery);
			postgresstmt.executeUpdate("Insert into "+"\""+"Reports"+"\""+"."+"\"MISSING_KEYS_DETAILS\""+MissingPKsQuery);
			
			
			int rowsUpdated=0;
			int F2FMismatchCounter=0;
			String F2FValidationStatus="";
			String dateStart = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date());
			String F2FQuery=" SELECT "
					+"\'" + TestCaseName + "\' AS TESTCASENAME,"
					+ "\'" + SourceTableName + "\' AS SRCTBLNM,"
					+ "\'" + TargetTableName + "\' AS TGTTBLNM,"
					+ " A."+SourcePK + " AS SourcePK,"
					+ " B."+TargetPK + " AS TargetPK,"
					+"A."+ SourceColumns.replaceAll(",$", "").replaceAll(",", "|| A.")+" AS SourceCols,"
					+"B." +TargetColumns.replaceAll(",$", "").replaceAll(",", "|| B.")+" AS TargetCols,"
							+ " CURRENT_TIMESTAMP AS LASTRUNDATE"
							+ " FROM "
							+"\""+"Reports"+"\""+"."+"\""+SourceTableName+"_SRC"+"\""+" A "
							+" INNER JOIN "+"\""+"Reports"+"\""+"."+"\""+TargetTableName+"_TGT"+"\""+" B "
							+" ON A."+SourcePK+" = "+"B."+TargetPK
							+" WHERE COALESCE(UPPER(TRIM(CAST((A."+SourceColumns.replaceAll(",$", "").replaceAll(",", "|| A.")+") AS CHARACTER VARYING))),'') <> COALESCE(UPPER(TRIM(CAST((B."+TargetColumns.replaceAll(",$", "").replaceAll(",", "|| B.")+") AS CHARACTER VARYING))),'')"
							+" LIMIT 10 ";
			//System.out.println("Insert into "+"\""+"Reports"+"\""+"."+"\"F2F_DTLS_TBL\""+F2FQuery);
			rowsUpdated=postgresstmt.executeUpdate("Insert into "+"\""+"Reports"+"\""+"."+"\"F2F_DTLS_TBL\""+F2FQuery);
			F2FMismatchCounter=F2FMismatchCounter+rowsUpdated;
			
			//System.out.println("[Info]: Validation for source column :"+SrcColSplit[i]+" completed. "+(i+1)+" out of "+SrcColSplit.length+" completed ");
			
			
			/*Thread sourcecountsfetchthread = new Thread("GetSourceCounts") {
	 		    public void run() {
					try{	*/		
						System.out.println("******** Starting thread to fetch source counts **************");
						//System.out.println(SrcCountsQuery);
						srccountsres=postgresstmt.executeQuery(SrcCountsQuery);
						while(srccountsres.next()){
							srcCount=srccountsres.getString(1);
						}
						/*}
				  catch (Exception e){
						e.printStackTrace();
					}}
				};
				sourcecountsfetchthread.start();*/
				
			/*Thread targetcountsfetchthread = new Thread("GetTargetCounts") {
		 		    public void run() {
				try{	*/		
					System.out.println("******** Starting thread to fetch target counts **************");
					//System.out.println(TgtCountsQuery);
					tgtcountsres=postgresstmt.executeQuery(TgtCountsQuery);
					while(tgtcountsres.next()){
					tgtCount=tgtcountsres.getString(1);
					}
					//System.out.println(tgtCount);
				/*}
					  catch (Exception e){
							e.printStackTrace();
						}}
					};
					targetcountsfetchthread.start();
					sourcecountsfetchthread.join();
					targetcountsfetchthread.join();*/
					
					if(!srcCount.equalsIgnoreCase(tgtCount)){
						CountsCheckStatus="FAILED";
					}
					else CountsCheckStatus="PASSED";
					//System.out.println("The counter: "+F2FMismatchCounter);
					if(F2FMismatchCounter==0 || F2FMismatchCounter==1){		 	 				
		 					F2FValidationStatus="PASSED"; 	 								 	 				
		 			}
				else F2FValidationStatus="FAILED";
					String	ComparisonMasterLogQuery=" SELECT "+"\'"+TestCaseName+ "\'"+","+"\'"+SourceTableName+ "\'"+","+"\'"+TargetTableName+ "\'"+","+"\'"+CountsCheckStatus+ "\'"+","+srcCount+","+tgtCount+","
							+"\'"+F2FValidationStatus+ "\'"+","+"\'"+dateStart+"\'";
					//System.out.println(ComparisonMasterLogQuery);
					
					postgresstmt.executeUpdate("Insert into "+"\""+"Reports"+"\""+"."+"\"AUDIT_SUMMARY\""+ComparisonMasterLogQuery);
		}
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("************* Done ********************");
		RequestDispatcher rd = request.getRequestDispatcher("Landing.jsp");
	    rd.forward(request, response);
	    
	}
	

}

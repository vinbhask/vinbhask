package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.implementations.FetchDatabaseDetailsDAO;

import library.UtilLib;

/**
 * Servlet implementation class MapNRun
 */
@WebServlet("/MapNRun")
public class MapNRun extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapNRun() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SourcePK=request.getParameter("SourcePK");
		String TargetPK=request.getParameter("TargetPK");
		String TestCaseName=request.getParameter("TestCaseName");
		String ScenarioType=request.getParameter("ScenarioType");
		String SourceServer=request.getParameter("SourceServer");
		String SourceSchema=request.getParameter("SourceSchema");
		String SourceTable=request.getParameter("SourceTable");
		String TargetServer=request.getParameter("TargetServer");
		String TargetSchema=request.getParameter("TargetSchema");
		String TargetTable=request.getParameter("TargetTable");
		String SourceColumns="";
		String TargetColumns="";
		String SourceQuery="";
		String TargetQuery="";
		/*String SourcecolnDT="";
		String TargetcolnDT="";*/
		String TestCaseTableName=UtilLib.getEnvVar("AuditTestCaseTbl");
		System.out.println("Scenario type: "+ScenarioType);
		
		int NumOfCols=Integer.parseInt(request.getParameter("NumOfCols"));
		
		for(int i=1;i<=NumOfCols;i++){
			/*sourceCols.add(request.getParameter("sosource"+i));
			targetCols.add(request.getParameter("sotarget"+i));*/
			SourceColumns=SourceColumns+request.getParameter("sosource"+i)+",";
			TargetColumns=TargetColumns+request.getParameter("sotarget"+i)+",";
		}
		//System.out.println(SourceColumns.replaceAll(",$", ""));
		//System.out.println(TargetColumns.replaceAll(",$", ""));
		//SourcecolnDT=request.getParameter("SourcePK")+" character varying(150),";
		//TargetcolnDT=request.getParameter("TargetPK")+" character varying(150),";
		/*for(int j=1;j<=NumOfCols;j++){
			SourcecolnDT=SourcecolnDT+request.getParameter("sosource"+j)+" character varying(150),";
			TargetcolnDT=TargetcolnDT+request.getParameter("sotarget"+j)+" character varying(150),";
		}*/
		if(SourceServer.equalsIgnoreCase("Oracle")){
		SourceQuery="SELECT "+SourceColumns.replaceAll(",$", "")+" FROM "+SourceSchema+"."+SourceTable;
		//System.out.println("Source Query: "+SourceQuery);
		//FetchDatabaseDetailsDAO.createTableInTarget(SourceTable, SourcecolnDT, "Source");
		}
		if (TargetServer.equalsIgnoreCase("Postgres")){
		TargetQuery="SELECT "+TargetColumns.replaceAll(",$", "")+" FROM "+"\""+TargetSchema+"\""+"."+"\""+TargetTable+"\"";
		//System.out.println("Target Query: "+TargetQuery);
		//FetchDatabaseDetailsDAO.createTableInTarget(TargetTable, TargetcolnDT, "Target");insertIntoTestCaseTable
		}
		//System.out.println(SourceQuery+"-----"+TargetQuery);
		//System.out.println(ScenarioType);
		String TestCaseQuery="INSERT INTO "+TestCaseTableName+" SELECT "+"'"+TestCaseName+"'"+","+"'"+SourceTable+"'"+","+"'"+TargetTable+"'"+","+"'"+SourcePK+"'"+","+"'"+TargetPK+"'"+","+"'"+SourceColumns.replaceAll(",$", "")+"'"+","+"'"+TargetColumns.replaceAll(",$", "")+"'"+","+"'"+SourceQuery+"'"+","+"'"+TargetQuery+"'"+","+"'"+ScenarioType+"'";
		System.out.println(TestCaseQuery);
		FetchDatabaseDetailsDAO.insertIntoTestCaseTable(TestCaseQuery);
		ArrayList testCaseDetails=FetchDatabaseDetailsDAO.displayAllExistingTests();
		HttpSession session=request.getSession();
		session.setAttribute("TestCaseDetails", testCaseDetails);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("ExistingTestCase.jsp");
	    rd.forward(request, response);
	    
	    
		
	}

}

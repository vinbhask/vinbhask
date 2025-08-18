package com.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.implementations.FetchDatabaseDetailsDAO;

/**
 * Servlet implementation class FetchDatabaseDetails
 */
@WebServlet("/FetchDatabaseDetails")
public class FetchDatabaseDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchDatabaseDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("nothing to display here");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SourceServer=request.getParameter("SourceServer");
		String SourceSchema=request.getParameter("SourceSchema");
		String SourceTable=request.getParameter("SourceTable");
		String TargetServer=request.getParameter("TargetServer");
		String TargetSchema=request.getParameter("TargetSchema");
		String TargetTable=request.getParameter("TargetTable");
		String ColumnSelector=request.getParameter("Counter");
		//System.out.println("The column selector value is:"+((ColumnSelector==null)? "---" :ColumnSelector));
		//HttpSession session=request.getSession();
		//System.out.println(request.getParameter("sosource1"));
		//System.out.println(request.getParameter("sosource2"));
		
		
		Map<String, String> options = new LinkedHashMap<>();
		Map<String, String> toptions = new LinkedHashMap<>();
		Map<String, String> soptions = new LinkedHashMap<>();
		
		
		if( ((SourceServer==null)? "" :SourceServer).equalsIgnoreCase("Oracle") && ((SourceSchema==null)? "" :SourceSchema).length()==0 && ((SourceTable==null)? "" :SourceTable).length()==0){
			
			ResultSet SourceSchemaDetails=FetchDatabaseDetailsDAO.getDatabaseDetails("Oracle");
			try{
				
				options.put("", "-- select an schema --");
				while(SourceSchemaDetails.next()){
				options.put(SourceSchemaDetails.getString(1), SourceSchemaDetails.getString(1));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		if(((SourceSchema==null)? "" :SourceSchema).length()!=0  && ((SourceTable==null)? "" :SourceTable).length()==0 ){
			//System.out.println("going to select source table");
			ResultSet SourceTableDetails=FetchDatabaseDetailsDAO.getTableDetails(SourceSchema,SourceServer);
			try{			
				options.put("", "-- select an source table --");
				while(SourceTableDetails.next()){
				options.put(SourceTableDetails.getString(1), SourceTableDetails.getString(1));
				}
		   		}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		if(((SourceTable==null)? "" :SourceTable).length()!=0 ){
			//System.out.println("going to select source columns");
			ResultSet SourceColumnDetails=FetchDatabaseDetailsDAO.getColumnDetails(SourceTable,SourceServer);
			try{
				
				//options.put("", "-- select Columns --");
				soptions.put("", "-- select an source column --");
				while(SourceColumnDetails.next()){
				//options.put(SourceColumnDetails.getString(1), SourceColumnDetails.getString(1));
				soptions.put(SourceColumnDetails.getString(1), SourceColumnDetails.getString(1));
				}
				//session.setAttribute("sourceColumns", options);
		    	}

			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		 if ( ((TargetServer==null)? "" :TargetServer).equalsIgnoreCase("Postgres") && ((TargetSchema==null)? "" :TargetSchema).length()==0 && ((TargetTable==null)? "" :TargetTable).length()==0){
			 //System.out.println("going to select target schema");
			 ResultSet TargetSchemaDetails=FetchDatabaseDetailsDAO.getDatabaseDetails("Postgres");
			try{
				
				options.put("", "-- select an schema --");
				while(TargetSchemaDetails.next()){
				options.put(TargetSchemaDetails.getString(1), TargetSchemaDetails.getString(1));
				}
		   			}

			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		if(((TargetSchema==null)? "" :TargetSchema).length()!=0  && ((TargetTable==null)? "" :TargetTable).length()==0 ){
			//System.out.println("going to select target table");
			ResultSet TargetTableDetails=FetchDatabaseDetailsDAO.getTableDetails(TargetSchema,TargetServer);
			try{
				
				options.put("", "-- select an table --");
				while(TargetTableDetails.next()){
				options.put(TargetTableDetails.getString(1), TargetTableDetails.getString(1));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		if(((TargetTable==null)? "" :TargetTable).length()!=0 ){
			//System.out.println("going to select target columns");
			ResultSet TargetColumnDetails=FetchDatabaseDetailsDAO.getColumnDetails(TargetTable,TargetServer);
			try{
				
				toptions.put("", "-- select an target column --");
				while(TargetColumnDetails.next()){
				//options.put(TargetColumnDetails.getString(1), TargetColumnDetails.getString(1));
				toptions.put(TargetColumnDetails.getString(1), TargetColumnDetails.getString(1));
				
				}
				//System.out.println("Inside while loop :"+toptions);
				//session.setAttribute("targetColumns", options);
			}

			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		if(((ColumnSelector==null)? "" :ColumnSelector).length()==0 ){
			
		String json = new Gson().toJson(options);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	    //System.out.println(options);
	    
		}
		if(((ColumnSelector==null)? "" :ColumnSelector).length()!=0  ){
			
			String json1 = new Gson().toJson(soptions); 
			String json2 = new Gson().toJson(toptions);
			
			String bothJson = "["+json1+","+json2+"]";
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(bothJson);
		    //System.out.println(bothJson);
		}
		
	}

}

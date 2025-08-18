package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.implementations.Login_Implementation;

import library.UtilLib;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Username=request.getParameter("userName");
		String Password=request.getParameter("password");
		String FilePath=UtilLib.getEnvVar("ConfigXMLFilePath");
		//System.out.println("Inside Login controller");
		Login_Implementation Validate_Login=new Login_Implementation();
		String Pword=Validate_Login.Login(FilePath, Username);
		
		HttpSession session=request.getSession();
		session.setAttribute("User", Username);
		
		
		boolean Status= Password.equalsIgnoreCase(Pword);
		//System.out.println("matched status: "+Status);
		
		
		if(Status==true){
			RequestDispatcher rd = request.getRequestDispatcher("Landing.jsp");
		    rd.forward(request, response);
		}
		
		else{
			request.setAttribute("Error", "Invalid password."); 
			RequestDispatcher rd = request.getRequestDispatcher("LoginError.jsp");
		    rd.forward(request, response);
		}
	}

}

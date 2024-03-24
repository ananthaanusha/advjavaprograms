package com.satya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username=request.getParameter("username");
		 String password=request.getParameter("Password");
		 
		 String status;
		 if(username.equals("Anusha") && password.equals("anusha@123"))
			 status="Login Succesfull....";
		 else
			 status="Login Fail...";
		 
		 PrintWriter writer=response.getWriter();
		   response.setContentType("text/html");
		   writer.println("<html>");
		   writer.println("Login Information is.."+status);
		   writer.println("</html>");
    	}

	
}

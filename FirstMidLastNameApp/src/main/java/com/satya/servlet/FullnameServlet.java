package com.satya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FullnameServlet")
public class FullnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String firstname=request.getParameter("firstname");
			String middlename=request.getParameter("middlename");
			String lastname=request.getParameter("lastname");
			
			String status=firstname+middlename+lastname;
						
			
			PrintWriter writer=response.getWriter();
			response.setContentType("text/html");
			writer.println("<html>");
			writer.println("Full Name is " + status);
			writer.println("</html>");
	}



}

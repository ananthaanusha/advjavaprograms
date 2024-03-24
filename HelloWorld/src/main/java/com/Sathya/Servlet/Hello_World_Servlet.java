package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class Hello_World_Servlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter writer=response.getWriter();
			response.setContentType("text/html");
			writer.println("<html>");
			writer.println("<h1>Hello welcome to adv java<h1>");
			writer.println("<h5>Hello welcome to ratan sir classes!</h5>");
			writer.println("</html>");

   	}

	

}

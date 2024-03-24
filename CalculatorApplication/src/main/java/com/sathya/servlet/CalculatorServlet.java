package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int first=Integer.parseInt(request.getParameter("first"));
		int second=Integer.parseInt(request.getParameter("second"));
		String operation=request.getParameter("operation");
		
		//2.process data
		int result=0;
		switch(operation) {
		case "+":result=first+second;
				 break;
		case "-":result=first-second;
		 		 break;
		case "*":result=first*second;
		 		 break;
		case "/":result=first/second;
		 		 break;
		case "%":result=first%second;
		 		 break;
		 		
		}
		
		//render response to client
 		
 		PrintWriter writer=response.getWriter();
 		response.setContentType("text/html");
 		
 		writer.println("<html>");
 		writer.println("<body>");
 		writer.println("<h2>Arthimetic Calculator</h2>" );
 		writer.println("<br><br>");
 		writer.println("<b>Your First Number is:</b>" +first);
 		writer.println("<br><br>");
 		writer.println("<b>Your Second Number is:</b>" +second);
 		writer.println("<br><br>");
 		writer.println("<b>Performed Operation is:</b>" +operation);
 		writer.println("<br><br>");
 		writer.println("<b>Your Operation Result is :</b>"+result);
 		writer.println("<br><br>");
 		writer.println("</body>");
 		writer.println("</html>");
		
	}
}

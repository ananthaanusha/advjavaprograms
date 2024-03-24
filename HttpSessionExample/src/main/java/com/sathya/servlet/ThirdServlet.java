package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
//    		String email= request.getParameter("email");
//    		Long phone= Long.parseLong(request.getParameter("phone"));
    		//create session object
    		HttpSession session=request.getSession(false);
//    		session.setAttribute("email", email);
//    		session.setAttribute("phone", phone);
    		    		
    		//send the response back
    		response.setContentType("text/html");
    		PrintWriter writer=response.getWriter();
    		writer.println("<html>");
    		writer.println("<body>");
    		writer.println("<pre style='color:blue;'>");
    		writer.println("<h1>The Submitted Form Details are as follows...</h1>");
    		writer.println("<b>User Name:</b>"+session.getAttribute("username"));
    		writer.println("<b>User Age:</b>"+session.getAttribute("age"));
    		writer.println("<b>User Qualification:</b>"+session.getAttribute("qualification"));
    		writer.println("<b>User Designation:</b>"+session.getAttribute("designation"));
    		writer.println("<b>User Email:</b>"+request.getParameter("email"));
    		writer.println("<b>User Phone:</b>"+request.getParameter("phone"));
    		writer.println("</pre>");
    		writer.println("</body>");
    		writer.println("</html>");
	}

}

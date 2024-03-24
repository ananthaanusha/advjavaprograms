package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		long mobile=Long.parseLong(request.getParameter("number"));
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String[] quals=request.getParameterValues("qualification");
		String country=request.getParameter("country");
		String[] languages=request.getParameterValues("laguage");
		String comments=request.getParameter("comments");
		
		//Step-2:-Process data
		String q=String.join(",", quals);
		String l=String.join(",", languages);
		
		//Step-3 render response to client
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("User name:"+username+"<br>");
		writer.println("Passwors :"+password+"<br>");
		writer.println("Number :"+mobile+"<br>");
		writer.println("User Email:"+email+"<br>");
		writer.println("Gender:"+gender+"<br>");
		writer.println("DOB:"+dob+"<br>");
		writer.println("Qualification :"+q+"<br>");
		writer.println("Country:"+country+"<br>");
		writer.println("Languages known:"+l+"<br>");
		writer.println("Comments:"+comments+"<br>");
		writer.println("</body>");
		writer.println("</html>");
		
				
    	}

}

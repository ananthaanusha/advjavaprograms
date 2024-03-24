package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.get the data from client
		int empId=Integer.parseInt(request.getParameter("employeeId"));
		String empName=request.getParameter("employeeName");
		double empSalary=Double.parseDouble(request.getParameter("employeeSalary"));
		
		//2.process the data
		double HRA,DA,PF,grossSalary;
		if(empSalary<25000) {
			HRA=empSalary*0.10;
			DA=empSalary*0.03;
			PF=empSalary*0.02;
			grossSalary=empSalary+HRA+DA-PF;
		}
		else if(empSalary >25000 && empSalary <50000) {
			HRA=empSalary*0.20;
			DA=empSalary*0.05;
			PF=empSalary*0.03;
			grossSalary=empSalary+HRA+DA-PF;
		}
		else {
			HRA=empSalary*0.30;
			DA=empSalary*0.10;
			PF=empSalary*0.06;
			grossSalary=empSalary+HRA+DA-PF;
		}
		
		//3. render response to client
		PrintWriter writer=response.getWriter();
		   response.setContentType("text/html");
		   writer.println("<html>");
		   writer.println("<body>");
		   writer.println("<b>Employee Id :</b> "+empId);
		   writer.println("<br><br>");
		   writer.println("<b>Employee Name : </b>"+empName);
		   writer.println("<br><br>");
		   writer.println("<b>Employee Salary :</b> "+empSalary);
		   writer.println("<br><br>");
		   writer.println("<b>HRA Amount :</b> "+HRA);
		   writer.println("<br><br>");
		   writer.println("<b>DA Amount :</b> "+DA);
		   writer.println("<br><br>");
		   writer.println("<b>PF Amount: </b>"+PF);
		   writer.println("<br><br>");
		   writer.println("<b>Gross Salary :</b> "+grossSalary);
		   writer.println("<br><br>");
		   writer.println("</body>");
		   writer.println("</html>");
	}

	

}

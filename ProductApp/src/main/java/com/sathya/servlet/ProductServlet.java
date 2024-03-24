package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		//1.Read the Requested data
		int proId=Integer.parseInt(request.getParameter("proId"));
		String proName=request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		int proQuantity=Integer.parseInt(request.getParameter("proQuantity"));
		
		//2.Process the data
		/*
		 total bill <1000            :no discount
		 total bill	>1000            :5% discount
		 total bill	>5000  & <10000  :10% discount
		 total bill	>10000           :15% discount
		 */
		double discount,totalBill,netAmount;
		
		if(proPrice <1000)
		{
			discount=proPrice*0;
			totalBill=proPrice*proQuantity;
			netAmount=totalBill - discount;
		    
		}
		else if(proPrice > 1000 && proPrice <5000)
		{
			discount=proPrice*0.05;
			totalBill=proPrice*proQuantity;
			netAmount=totalBill - discount;
		}
		
		else if(proPrice > 5000 && proPrice < 10000)
		{
			discount=proPrice*0.10;
			totalBill=proPrice*proQuantity;
			netAmount=totalBill - discount;
		}
		else 
		{
			discount=proPrice*0.15;
			totalBill=proPrice*proQuantity;
			netAmount=totalBill - discount;
		}
		
		//3.Render the response 
     	PrintWriter writer=response.getWriter();
     	   response.setContentType("text/html");
     	   
           writer.println("<html>");
           writer.println("<body>");
           writer.println("<b>Product Id:<b>" + proId);
           writer.println("<br><br>");
           writer.println("<b>Product Name:</b>" + proName);
           writer.println("<br><br>");
           writer.println("<b>Product Price:</b> $" + proPrice);
           writer.println("<br><br>");
           writer.println("<b>Product Quantity:</b>" + proQuantity);
           writer.println("<br><br>");
           writer.println("<b>Total Bill Amount:</b> $" + totalBill);
           writer.println("<br><br>");
           writer.println("<b>Discount Amount:</b> $" + discount);
           writer.println("<br><br>");
           writer.println("<b>Net Amount to pay:</b> $" + netAmount);
           writer.println("<br><br>");
           writer.println("</body>");
           writer.println("</html>");
           
           
		
		}
}

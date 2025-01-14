package com.sathya;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SearchServlet")
@MultipartConfig
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String proName=request.getParameter("proName");
	ProductDao product=new ProductDao();
	Product product2=product.searchByName(proName);
	//forward the data to jsp
//	request.setAttribute("product", product2);
	RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
	dispatcher.forward(request, response);
	}

}

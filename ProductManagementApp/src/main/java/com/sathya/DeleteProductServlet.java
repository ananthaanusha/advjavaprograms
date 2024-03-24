package com.sathya;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String proId=request.getParameter("proId");
    		//call delete by id()
    		ProductDao dao=new ProductDao();
    		int result=0;
    		try {
				 result=dao.deleteById(proId);
			} catch (ClassNotFoundException |SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    		if(result==1) {
    			request.setAttribute("delete", result);
    			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
    			dispatcher.forward(request, response);
    		}
    		else
    		{
    			request.setAttribute("delete", result);
    			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
    			dispatcher.forward(request, response);
    		}
    		
	}



}

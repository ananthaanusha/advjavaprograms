package com.sathya;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proId");
		ProductDao dao=new ProductDao();
		
		Product existingProduct=dao.findById(proId);
		
		//pass this existing product to editForm.jsp file
		request.setAttribute("existingProduct", existingProduct);
		RequestDispatcher dispatcher=request.getRequestDispatcher("editForm.jsp");
		dispatcher.forward(request, response);
	}

	

}

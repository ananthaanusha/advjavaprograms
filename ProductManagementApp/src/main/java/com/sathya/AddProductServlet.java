package com.sathya;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reading data from form
    	String proId=request.getParameter("proId");   
		String proName=request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String madeIn=request.getParameter("madeIn");
		Date mDate=Date.valueOf(request.getParameter("mDate"));
		Date eDate=Date.valueOf(request.getParameter("eDate"));
		
		//read image data
		Part part=request.getPart("proImage");
		InputStream inputStream=part.getInputStream();
		byte[] image=IOUtils.toByteArray(inputStream);
		
		
		
		
		//create product object
		Product product=new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(madeIn);
		product.setProMDate(mDate);
		product.setProEDate(eDate);
		product.setProImage(image);

		
		//Create Product Dao class
		ProductDao dao=new ProductDao();
		int	result = dao.save(product);
		
		if(result==1) {
			request.setAttribute("saveResult", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data Insertion Fail Check Once..."+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("addProduct.html");
			dispatcher.include(request, response);
		}
	}

}

package com.sathya;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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


@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updatedProId=request.getParameter("proId");   
		String updatedProName=request.getParameter("proName");
		double updatedProPrice=Double.parseDouble(request.getParameter("proPrice"));
		String updatedProBrand=request.getParameter("proBrand");
		String updatedProMadeIn=request.getParameter("madeIn");
		Date updatedProMfgDate=Date.valueOf(request.getParameter("mDate"));
		Date updatedProExpDate=Date.valueOf(request.getParameter("eDate"));
		
		//create product object
				Product product=new Product();
				product.setProId(updatedProId);
				product.setProName(updatedProName);
				product.setProPrice(updatedProPrice);
				product.setProBrand(updatedProBrand);
				product.setProMadeIn(updatedProMadeIn);
				product.setProMDate(updatedProMfgDate);
				product.setProEDate(updatedProExpDate);
				
		//Reading image and validating
				
				Part filePart=request.getPart("newProImage");
				if(filePart.getSize() > 0) {	
						InputStream inputStream=filePart.getInputStream();
						byte[] proImage = IOUtils.toByteArray(inputStream);
						product.setProImage(proImage);
					} else {
						String s = request.getParameter("existingImage");
						byte[] proImage = Base64.getDecoder().decode(s);
						product.setProImage(proImage);
					
				}
				
//				//reading audio and validating
//				Part filePart1=request.getPart("newProAudio");
//				if(filePart1.getSize() > 0) {
//					InputStream inputStream=filePart1.getInputStream();
//					byte[] newAudioData=IOUtils.toByteArray(inputStream);
//					product.setProImage(newAudioData);
//				}
//				else {
//					Part file=request.getPart("existingAudio");
//					InputStream inputStream=file.getInputStream();
//					byte[] existingAudio=IOUtils.toByteArray(inputStream);
//					product.setProImage(existingAudio);
//				}
//				//reading video and validating
//				Part filePart2=request.getPart("newProVideo");
//				if(filePart2 != null && filePart2.getSize() > 0) {
//					InputStream inputStream=filePart2.getInputStream();
//					byte[] newVideoData=IOUtils.toByteArray(inputStream);
//					product.setProImage(newVideoData);
//				}
//				else {
//					Part file=request.getPart("existingVideo");
//					InputStream inputStream=file.getInputStream();
//					byte[] existingVideo=IOUtils.toByteArray(inputStream);
//					product.setProImage(existingVideo);
//				}
				
				ProductDao dao=new ProductDao();
				
				int	result=dao.updateById(product);
				request.setAttribute("result", result);
				if(result==1) {
					
					RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter writer=response.getWriter();
					writer.println("Data Updation Fail Check Once..."+result);
					RequestDispatcher dispatcher=request.getRequestDispatcher("editForm.jsp");
					dispatcher.include(request, response);
				}
				
	}

}

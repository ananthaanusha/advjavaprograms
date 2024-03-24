package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/EvenOddPerfectStrongApplication")
public class EvenOddPerfectStrongApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start=Integer.parseInt(request.getParameter("start"));
		int end=Integer.parseInt(request.getParameter("end"));
		String operation=request.getParameter("operation");
		ArrayList<Integer> a=new ArrayList<>();
		//2.
		
		for(int i=start;i<=end;i++) {
			switch(operation) {
			case "even":if(i%2==0)
						a.add(i);						
						break;
						
			case "odd":if(i%2 !=0)
						a.add(i);
					   break;
					   
			case "prime":int number=i,count=0;
						 for(int j=2;j<=number/2;j++) {
							 if(number%j ==0)
								 count++;
							 
						 }
						 if(count==0 && number!=1)
							 a.add(number);
						 break;
						 
			case "perfect": int sum=0;
							for(int j=1;j<=i/2;j++) {
								if(i%j==0) {
									sum=sum+j;
								}								
							}
							if(sum==i)
								a.add(i);
							break;
							
			case "strong":int originalNum,rem,fact,sum1=0,j;
							originalNum=i;
							while(i!=0) {
							 rem=i%10;
				             fact=1;
				            for(j=1;j<=rem;j++){
				            fact*=j;
				               }
					            sum1+=fact;
					            i=i/10;
						 }
							if(sum1==originalNum)
								a.add(sum1);
						 break;

			
			}
			
		}
		//3.render the response to client
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("result:"+a);
		writer.println("</html>");
		
    	}
}

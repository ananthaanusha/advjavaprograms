package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data from client
		String username=request.getParameter("username");
		String age=request.getParameter("age");
		
		//create the cookie object for each property
		Cookie cookie1=new Cookie("username", username);
		Cookie cookie2=new Cookie("age", age);
		//pass these cookies into response object
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		//call another form
		RequestDispatcher dispatcher=request.getRequestDispatcher("form2.html");
		dispatcher.forward(request, response);
		
	}

}

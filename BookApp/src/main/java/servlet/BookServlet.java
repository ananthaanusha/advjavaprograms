package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid=Integer.parseInt(request.getParameter("bid"));
		String bname= request.getParameter("bname");
		String btitle= request.getParameter("btitle");
		String bauthor= request.getParameter("bauthor");
		String bdate= request.getParameter("bdate");
		double bprice=Double.parseDouble(request.getParameter("bprice"));
		
		
		
		
		
		
	}

	

}

package com.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entered");
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		AddBean ab = new AddBean();
		AddDao ad = new AddDao();
		
		String str = request.getParameter("add");
	if(str.equals("add") )
		{
			ab.setQuantity(3);
			ab.setPrice(100);
			ab.setPid(1);
			ab.setCustid(1);
			ab.setCid(1);
			ab.setBid(1);
			System.out.println("calling addcart");
		ab=ad.AddCart(ab);
		
		if(ab.isOperation()==true){
			pw.print("Added to cart");
		}
		}
	}
}

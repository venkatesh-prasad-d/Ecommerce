package com.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CategorySelect")
public class CategorySelect extends HttpServlet {
	
    
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("entered");
			CategoryBean ub = new CategoryBean();
			ArrayList<CategoryBean> al= new ArrayList<CategoryBean>();
			al = CategoryDAO.doIt(ub);
		//	System.out.println("\n" + ub.getCatName() + " " + ub.getCid() + " " + ub.getDescription());
			
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();	
			/*pw.print("<!DOCTYPE html>");
			pw.print("<html>");
			pw.print("<head>");
			pw.print("<title> Lowe's Shopping Cart</title>");
			pw.print("</head>");
			pw.print("<body>");
			pw.print("<p>");*/
			CategoryBean  [] u=new CategoryBean[5];
			for(int i=0;i<al.size();i++){
			
				u[i] = al.get(i);
			}
			
			pw.print("<html>");
			pw.print("<body>");
			pw.print("<form action='BrandSelect' method=\"post\">" );
			pw.print(u[0].getCatName()+"<br>");
			pw.print("<input type = \"submit\" value = \"one\"  name=\"select\" />");
			pw.print(u[1].getCatName()+"<br>");
			pw.print("<input type = \"submit\" value = \"two\"  name=\"select\" />");
			pw.print(u[2].getCatName()+"<br>");
			pw.print("<input type = \"submit\" value = \"three\"  name=\"select\" />");
			pw.print(u[3].getCatName()+"<br>");
			pw.print("<input type = \"submit\" value = \"four\"  name=\"select\" />");
			pw.print(u[4].getCatName()+"<br>");
			pw.print("<input type = \"submit\" value = \"five\"  name=\"select\" />");
			pw.print("</form>");
			pw.print("</body>");
			pw.print("</html>");
			}
			/*
			pw.print("</p>" + "<br>");
			
			pw.print("<img src = \"images/Desert.jpg\" alt = \"desert\" width = \"100\" height = \"100\"/>");
			pw.print("</body>");
			pw.print("</html>");*/
		
	
		protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("entered");
			doPost(request,response);
			
		}
}

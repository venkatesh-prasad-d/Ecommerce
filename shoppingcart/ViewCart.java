package com.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		ViewCartBean vc = new ViewCartBean();
		ViewCartDAO vcd= new ViewCartDAO();
		
		ArrayList<ViewCartBean> ar = new ArrayList();
		
		try {
			ar = vcd.viewCart();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<ar.size();i++){
			vc = ar.get(i);
			pw.print(vc.getName());
			pw.print(vc.getQuantity());
			pw.print(vc.getPrice());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

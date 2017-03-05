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

@WebServlet("/BrandSelect")
public class BrandSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BrandSelect() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		ArrayList<BrandBean> al= new ArrayList<BrandBean>();
		BrandBean bb = new BrandBean();
		BrandDao bd = new BrandDao();
		String str ;
		str = request.getParameter("select");
		
		switch (str){
		case "one": bb.setCid(1);
					break;
		case "two": bb.setCid(2);
		break;
		case "three": bb.setCid(3);
		break;
		case "four": bb.setCid(4);
		break;
		case "five": bb.setCid(5);
		break;
		
		}
		try {
			al=bd.getBrand(bb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrandBean [] b = new BrandBean[2];
		for(int i=0 ; i<al.size();i++){
		
			b[i]= al.get(i);
		}
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<form action='ProductSelect' method=\"post\">" );
		pw.print(b[0].getName()+"<br>");
		String strB =Integer.toString( b[0].getBid());
		pw.print("<input type = \"submit\" value = "+strB+"  name=\"select\" />");
		pw.print(b[1].getName()+"<br>");
		strB = Integer.toString(b[1].getBid());
		pw.print("<input type = \"submit\" value = "+strB+"  name=\"select\" />");

		pw.print("</form>");
		pw.print("</body>");
		pw.print("</html>");
		
		}
	}


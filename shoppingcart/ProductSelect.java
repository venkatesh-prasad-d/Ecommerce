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


@WebServlet("/ProductSelect")
public class ProductSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProductSelect() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		ProductBean pb = new ProductBean();
		ProductDao pd = new ProductDao();
		String Sbid = request.getParameter("select");
		int bid = Integer.parseInt(Sbid);
		pb.setBid(bid);
		ArrayList<ProductBean> al = new ArrayList();
		try {
			al = pd.showProd(pb);
			ProductBean[] p = new ProductBean[2];
			for(int i = 0; i< al.size();i++){
				p[i]=al.get(i);
			}
			pw.print("<html>");
			pw.print("<body>");
			pw.print("<form action='ProductSelect' method=\"post\">" );
			pw.print(p[0].getImage()+"<br>"+p[0].getName()+"<br>"+p[0].getDescription());
			String strB =Integer.toString( p[0].getBid());
			pw.print("<input type = \"submit\" value = "+strB+"  name=\"select\" />");
			pw.print(p[1].getImage()+"<br>"+p[1].getName()+"<br>"+p[1].getDescription());
			strB = Integer.toString(p[1].getBid());
			pw.print("<input type = \"submit\" value = "+strB+"  name=\"select\" />");

			pw.print("</form>");
			pw.print("</body>");
			pw.print("</html>");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package com.shoppingcart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewCartDAO {
	ResultSet rs;
	ViewCartBean r;
	Connection con = CategoryConnection.getConnection();
	public ArrayList<ViewCartBean> viewCart() throws SQLException{
	String str = "select p.productname,o.quantity,o.price from products as p ,orders as o where p.pid = o.pid";
	Statement smt = con.createStatement();
	rs = smt.executeQuery(str);
	ArrayList<ViewCartBean> vcb = new ArrayList();
	
	while(rs.next()){
		r = new ViewCartBean();
		r.setName(rs.getString(1));
		r.setQuantity(rs.getInt(2));
		r.setPrice(rs.getInt(3));
		vcb.add(r);
	}
	
	
	return vcb;
	}

}

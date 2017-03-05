package com.shoppingcart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shoppingcart.CategoryConnection;

public class AddDao {
	ResultSet rs;
	Connection con = CategoryConnection.getConnection();
	
	public AddBean AddCart(AddBean b){
		System.out.println("inside addcart");
		
		try{
			String str = "insert into orders(quantity,unitprice,pid,bid,cid,custid) values(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(str);
		System.out.println("hi....");
		ps.setInt(1, b.getQuantity());
		ps.setInt(2, b.getPrice());
		ps.setInt(3, b.getPid());
		ps.setInt(4, b.getBid());
		ps.setInt(5, b.getCid());
		ps.setInt(6, b.getCustid());
		ps.executeUpdate();
		System.out.println("Added to cart");
		b.setOperation(true);
		
	}catch(Exception e){ 
		e.printStackTrace();
	}
		return b;
	}


}

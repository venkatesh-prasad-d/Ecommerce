package com.shoppingcart;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDAO {
	
	public static ArrayList<CategoryBean> doIt(CategoryBean b){
		ArrayList<CategoryBean> al = null;
		try {
		Connection conn;
		conn = CategoryConnection.getConnection();
		System.out.println("Connected");
		
		ResultSet rs;
		
		String str = "select * from category";
		Statement smt = conn.createStatement();
		//PreparedStatement ps=connect.prepareStatement(str);
		rs = smt.executeQuery(str);
		System.out.println("Executed");
		al= new ArrayList<CategoryBean>();
		CategoryBean r;
		
		while(rs.next()){
			r=new CategoryBean();
			r.setCid(rs.getInt(1));
			System.out.println(r.getCid());
			r.setCatName(rs.getString(2));
			r.setDescription(rs.getString(3));
			al.add(r);
		}
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return al;
	
	

	}
}



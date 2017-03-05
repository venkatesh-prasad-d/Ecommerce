package com.shoppingcart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BrandDao {

	Connection conn=CategoryConnection.getConnection();
	ResultSet rs;
	BrandBean r;
	public ArrayList<BrandBean> getBrand(BrandBean b) throws SQLException{
		
		String str="Select * from brand b,category c where b.cid=c.cid and c.cid"+b.getCid();
		Statement st= conn.createStatement();
		rs= st.executeQuery(str);
		ArrayList<BrandBean> ab = new ArrayList<BrandBean>();
		while(rs.next()){
			r = new BrandBean();
			r.setBid(rs.getInt(1));
			r.setName(rs.getString(2));
			r.setDesc(rs.getString(3));
			ab.add(r);
			
		}
		return ab;
	}
}

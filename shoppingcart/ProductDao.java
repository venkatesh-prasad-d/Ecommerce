package com.shoppingcart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import com.shoppingcart.CategoryConnection;

public class ProductDao {
	
		ResultSet rs;
		Connection con = CategoryConnection.getConnection();
		
		public ArrayList<ProductBean> showProd(ProductBean p) throws SQLException{
			
			String str = "select * from products p , brand b where p.bid = b.bid and b.bid="+ p.getBid();
			PreparedStatement ps = con.prepareStatement(str);
			ArrayList <ProductBean> ap = new ArrayList();
			rs = ps.executeQuery();
			ProductBean pb;
			while(rs.next()){
				pb= new ProductBean();
				pb.setPid(rs.getInt(1));
				pb.setName(rs.getString(2));
				pb.setDescription(rs.getString(3));
				pb.setImage(rs.getString(4));
				pb.setPrice(rs.getInt(5));
				pb.setCid(rs.getInt(7));
			ap.add(pb);
			}
			
			
			
			return ap;
	
			
		}

}

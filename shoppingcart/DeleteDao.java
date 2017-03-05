package com.shoppingcart;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.shoppingcart.CategoryConnection;

public class DeleteDao {

	public DeleteBean deleteItem(DeleteBean b) throws SQLException{
		
		Connection conn= CategoryConnection.getConnection();
		
		String str="Delete  from orders where oid=?";
		PreparedStatement ps= conn.prepareStatement(str);
		
		ps.setInt(1, b.getOid());
		
		 ps.executeUpdate();
		System.out.println("Deleted");
		b.setDeleted(true);
		
		
		return b;
		
	}
}

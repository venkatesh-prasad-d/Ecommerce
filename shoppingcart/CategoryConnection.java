package com.shoppingcart;
import java.sql.*;

public class CategoryConnection {
	static Connection con=null;
 public static Connection getConnection(){
		try {
			
			System.out.println("Connecting....");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart","root","");
			System.out.println("connected");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	
	 
	 
	
	
}

}

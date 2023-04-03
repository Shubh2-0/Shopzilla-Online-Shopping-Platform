package com.masai.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	
	static final String url;
	static final String username;
	static final String password;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("DB_Details");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");

	}
	
	static {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	public static void closeConnection(Connection con) {
		
		try {
			
			if(con!=null)
				con.close();
			
		} catch (Exception e) {
			
			
		}
		
	}
	
	
//	public static void main(String[] args) {
//		
//		System.out.println(getConnection());
//		
//	}
	
	
	
	
	
	
	
	

}

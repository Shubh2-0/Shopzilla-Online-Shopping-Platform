package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.masai.Dto.BuyerImpl;
import com.masai.Dto.SellerImpl;

public class SellerDaoImpl implements SellerDao {
 
	static SellerImpl seller = null;
	 
	@Override
	public SellerImpl loginUser(String username, String password) {
		
		
		Connection con = null;
		
		try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "SELECT * FROM SELLER WHERE username = ? AND password = ? AND is_deleted != 1";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				seller = new SellerImpl(set.getString(1), 
						set.getString(2), 
						set.getString(3), 
						set.getString(4), 
						set.getString(5), 
						set.getString(6),
						set.getDouble(7)
						);
			}
		
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally {
			
			DBUtils.closeConnection(con);
		}
			
			
			
		return seller;
		
		
		
		
		
		
	}
	
	
	
	@Override
	public SellerImpl getSellerByUsername(String username) {
		
		
		Connection con = null;
		
		SellerImpl seller2 = null;
		
		try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "SELECT UserName, password, first_name ,last_name, mobile_no, "
					+ "address, income  FROM SELLER WHERE username = ? AND is_deleted != 1";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
			
			statement.setString(1, username);
			
			
			
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				seller2 = new SellerImpl(set.getString(1), 
						set.getString(2), 
						set.getString(3), 
						set.getString(4), 
						set.getString(5), 
						set.getString(6),
						set.getDouble(7)
						);
			}
		
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}finally {
			
			DBUtils.closeConnection(con);
		}
			
			
			
		return seller2;
		
		
		
		
		
		
	}
	
	
	
	
	

}

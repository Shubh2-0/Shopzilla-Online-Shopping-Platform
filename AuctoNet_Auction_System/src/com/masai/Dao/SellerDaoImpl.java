package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.masai.Dto.BuyerImpl;
import com.masai.Dto.SellerImpl;

public class SellerDaoImpl implements SellerDao {
 
	static Connection con = null;
	static BuyerImpl buyer = null;
	static SellerImpl seller = null;
	static BuyerDao buyerDao = new BuyerDaoImpl();
	static ProductDao productDao = new ProductDaoImpl();
	
	
	
	
	@Override
	public SellerImpl loginSeller(String username, String password) {
	
		seller = null;
		
	try {
		
		con = DBUtils.getConnection();
		
		String SELECT_QUERY = "SELECT UserName, password, first_name, last_name, mobile_no, address, income FROM seller WHERE username = ? AND password = ? AND is_deleted = 0";
		
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
	
	@Override
	public String updateSellerDetails(SellerImpl u) {
		
		if(!u.getFirstName().equals("")) {
			buyer.setFirstName(u.getFirstName());
		}
		if(!u.getLastName().equals("")) {
			buyer.setLastName(u.getLastName());
		}
		
		if(!u.getMobileNo().equals("")) {
			buyer.setMobileNo(u.getMobileNo());
		}
		
		if(!u.getAddress().equals("")) {
			buyer.setAddress(u.getAddress());
		}
		
		
		
		try {
			
			con = DBUtils.getConnection();
			
			String UPDATE_QUERY = "UPDATE seller SET  first_name = ?, last_name = ?, mobile_no = ? , address = ? WHERE UserName = ? AND password = ?";
			
			PreparedStatement statement = con.prepareStatement(UPDATE_QUERY);
			
			statement.setString(1, seller.getFirstName());
			statement.setString(2, seller.getLastName());
			statement.setString(3, seller.getMobileNo());
			statement.setString(4, seller.getAddress());
			statement.setString(5, seller.getSellerUserName());
			statement.setString(6, seller.getPassword());
			
			
			int ans = statement.executeUpdate();
			
			if(ans > 0)
				return "Information Updated Successfullt...";
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return "Faild to Update....";
		
	}
	
	
	
	
	

}

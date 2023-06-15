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
    public double getSellerIncome(String username) {
		
		double income = 0.0;
		
		try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "SELECT income FROM seller WHERE username = ? AND is_deleted != 1";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
			
			statement.setString(1, username);
			
			
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				
				income = set.getDouble("income");
				
			}
		
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return income;
		
		
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
			seller.setFirstName(u.getFirstName());
		}
		if(!u.getLastName().equals("")) {
			seller.setLastName(u.getLastName());
		}
		
		if(!u.getMobileNo().equals("")) {
			seller.setMobileNo(u.getMobileNo());
		}
		
		if(!u.getAddress().equals("")) {
			seller.setAddress(u.getAddress());
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

	
	
	
	@Override
	public String registerNewSeller(SellerImpl s) {
		
		seller = s;
		
		try {
			
			con = DBUtils.getConnection();
			String INSERT_QUERY = "INSERT INTO seller(UserName, password, first_name, last_name, mobile_no, address, income, is_deleted) VALUES(?,?,?,?,?,?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			
			statement.setString(1, s.getSellerUserName());
			statement.setString(2, s.getPassword());
			statement.setString(3, s.getFirstName());
			statement.setString(4, s.getLastName());
			statement.setString(5, s.getMobileNo());
			statement.setString(6, s.getAddress());
			statement.setDouble(7, s.getIncome());
			statement.setInt(8, 0);
			
			int ans = statement.executeUpdate();
			
			if(ans > 0)
				return "Acount Created Successfully....";
			
		    	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return "Something Went Wrong...";
		
	}
	
	
	
	
	
	@Override
	public ResultSet getAllSellerProducts() {
		
		 
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT product_id AS Product_ID, product_name AS Product_Name, price_per_piece AS Price_Per_Piece, seller_name AS Seller_Name, quantity, description, category_id AS Category_ID FROM product WHERE seller_username = ?";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				ResultSet set = statement.executeQuery();
				
				statement.setString(1, seller.getSellerUserName());
				
					
					
					
					return set;
					
						
						
		
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			
			return null;
			
		
	}
	
	
	
	
	
	@Override
	public boolean unhideSellerProducts(String username) {
		     
          try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "UPDATE product SET is_hide = 0 WHERE seller_username = ?";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
			
			statement.setString(1, username);
			
			
			int ans = statement.executeUpdate();
			
			if(ans > 0) return true;
			
			
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
			
			
		return false;
			
		
	}
	
	
	
	
	@Override
	public boolean hideSellerProducts(String username) {
		     
          try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "UPDATE product SET is_hide = 1 WHERE seller_username = ?";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
			
			statement.setString(1, username);
		
			
			
			int ans = statement.executeUpdate();
			
			if(ans > 0 ) return true;
			
			
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
			
			
		return false;
			
		
	}
	
	
	
	
	
	 @Override
	public ResultSet getSellerAllProductsByCategory(String item, String username) {
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT product_id AS Product_ID, product_name AS Product_Name, price_per_piece AS Price_Per_Piece, seller_name AS Seller_Name, quantity, description, category_id AS Category_ID FROM product WHERE CATEGORY_ID = (SELECT CAT_ID FROM CATEGORY WHERE CAT_NAME = ?) AND seller_username = ?";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				statement.setString(1, item);
				statement.setString(2, username);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			
			return null;
			
			
		}
	
	 
	 
	 
	@Override
    public boolean amountWithrowBySeller(double amount,String unsername) {
			
			
			try {
				
				con = DBUtils.getConnection();
				
				String SELECT_QUERY = "UPDATE income SET income = ? WHERE username = ?";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
				
				statement.setDouble(1, amount);
				statement.setString(2, unsername);
				
			
				
				int ans = statement.executeUpdate();
				
				if(ans > 0) return true;
				
				
				
			} catch (Exception e) {
				
				System.out.println(e);
				
			}
				
				
		
			
			
			
			
			
			return false;
		} 
	
	
	
	
	@Override
	public boolean deleteSeller(String username,String password) {
		
		try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "UPDATE seller SET deleted_date = NOW() , is_deleted = 1 WHERE username = ? AND password = ?";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			
			int ans = statement.executeUpdate();
			
			if(ans > 0) return true;
			
			
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
			
			
		return false;
			
		
		
		
	}
	
	

}

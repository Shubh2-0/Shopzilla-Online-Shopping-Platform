package com.masai.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import com.masai.Exceptions.InvalidCredentialsException;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.Dto.BuyerImpl;
import com.masai.Dto.ProductImpl;
import com.masai.Dto.SellerImpl;
import com.masai.Dto.TransactionImpl;



public class AdminDaoImpl implements AdminDao {

	static Connection con = null;
	
	
	@Override
	public Boolean loginAdmin(String adminId, String password) {
	
		try {
		
			if(adminId.equals("admin") && password.equals("admin"))
				return true;
			
			
		} catch (Exception InvalidCredentialsException) {
			
			
			new InvalidCredentialsException("Invalid Id or Passowrd");
		}
		
		
			
			
		
			return false;
		
		
		
		
		
	}


	@Override
	public ResultSet getAllBuyer() throws RecordNotFoundException {
		
		
		try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT username UserName, first_name FirstName, last_name LastName, mobile_no MobileNumber, address Adress FROM Buyer where is_deleted != 1";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			
			ResultSet set = statement.executeQuery();
			
				
				
				
			return set;
				
				
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return null;
	}


	
	
	@Override
	public ResultSet getAllSeller(){
		
       ArrayList<SellerImpl>  list = new ArrayList<>();
		
		try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT username UserName, first_name FirstName, last_name LastName, mobile_no MobileNumber, address Adress FROM SELLER where is_deleted != 1";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			
			ResultSet set = statement.executeQuery();
		   return set;
				
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return null;
		
		
	}


	@Override
	public ResultSet getAllProducts()throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT product_id ID, product_name Name, price_per_piece Price_Per_Unit, seller_id SellerID, seller_name SellerName, quantity Quantity, description Description, category_id CategoryID FROM PRODUCT";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
				
				
				
				
			} catch (Exception e) {
				
				throw new RecordNotFoundException("Not record Found");
				
			}
			
		
		
	}

	
	

	@Override
	public ResultSet getAllSoldProducts()throws RecordNotFoundException {
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT product_id ID, product_name Name, price_per_piece Price_Per_Unit, seller_id SellerID, seller_name SellerName, quantity Quantity, description Description, category_id CategoryID FROM PRODUCT WHERE sold_status != 0";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;
	}

	

	@Override
	public ResultSet getAllProductsByCategory(String CatName)throws RecordNotFoundException {
		 
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT product_id ID, product_name Name, price_per_piece Price_Per_Unit, seller_id SellerID, seller_name SellerName, quantity Quantity, description Description, category_id CategoryID FROM PRODUCT WHERE CATEGORY_ID = (SELECT CAT_ID FROM CATEGORY WHERE CAT_NAME = ?)";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				statement.setString(1, CatName);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;
	}
	
	
	@Override
	public ResultSet getAllProductsBySellerId(String sellerId)throws RecordNotFoundException {
		 
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT product_id ID, product_name Name, price_per_piece Price_Per_Unit, seller_id SellerID, seller_name SellerName, quantity Quantity, description Description, category_id CategoryID FROM PRODUCT WHERE Seller_id = ?";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				statement.setString(1, sellerId);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;
	}
	
	@Override
	public ResultSet getAllProductsByInAccendingOrderByPrice()throws RecordNotFoundException {
		 
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT product_id ID, product_name Name, price_per_piece Price_Per_Unit, seller_id SellerID, seller_name SellerName, quantity Quantity, description Description, category_id CategoryID FROM PRODUCT ORDER BY price_per_piece";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;
	}
	
	@Override
	public ResultSet getAllProductsByQuantity(int from, int to)throws RecordNotFoundException {
		 
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT product_id ID, product_name Name, price_per_piece Price_Per_Unit, seller_id SellerID, seller_name SellerName, quantity Quantity, description Description, category_id CategoryID FROM PRODUCT WHERE quantity BETWEEN ? AND ?";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				statement.setInt(1, from);
				statement.setInt(2, to);
				
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;
	}
	


	
	
	
	@Override
	public ResultSet getAllTransaction()throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT * FROM TRANSACTIONS";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
		
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
		
		
		
	}


	@Override
	public ResultSet getAllTransactionbyDateRange(LocalDate startDate, LocalDate endDate)throws RecordNotFoundException {
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT * FROM TRANSACTIONS WHERE PURCHASE_DATE BETWEEN ? AND ?";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				Date s = Date.valueOf(startDate);
				Date e = Date.valueOf(endDate);
		
				statement.setDate(1, s);
				statement.setDate(2, e);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
				return set;
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
		
	}


	@Override
	public ResultSet getTransactionById(int id) throws RecordNotFoundException{
		
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT * FROM TRANSACTIONS WHERE TRANSACTION_ID = ?";
				
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				
				
				statement.setInt(1, id);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
				return set;
					
					
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;
	}
  
	
	@Override
	public ResultSet getAllTransactionByPurchaseDate()throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT * FROM TRANSACTIONS ORDER BY purchase_date";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
		
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
		
		
		
	}
	
	@Override
	public ResultSet getAllTransactionByQuantity()throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT * FROM TRANSACTIONS ORDER BY quantity";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
		
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
		
		
		
	}
	
	@Override
	public ResultSet getAllTransactionByGSTPercentage()throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT * FROM TRANSACTIONS ORDER BY gst_percentage";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
		
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
		
		
		
	}
	
	@Override
	public ResultSet getAllTransactionByTotalPrice()throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT * FROM TRANSACTIONS ORDER BY total_price";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
		
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
		
		
		
	}
	
	

	
	
	

}

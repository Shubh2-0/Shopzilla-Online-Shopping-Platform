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
			String SELECT_QUERY = "SELECT * FROM BUYER";
			
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
			String SELECT_QUERY = "SELECT * FROM SELLER";
			
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
				String SELECT_QUERY = "SELECT * FROM PRODUCT";
				
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
				String SELECT_QUERY = "SELECT * FROM PRODUCT WHERE SOLD_STATUS = 1";
				
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
				String SELECT_QUERY = "SELECT * FROM PRODUCT WHERE CATEGORY_ID = (SELECT CAT_ID FROM CATEGORY WHERE CAT_NAME = ?)";
				
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
  
	
	

	
	
	

}

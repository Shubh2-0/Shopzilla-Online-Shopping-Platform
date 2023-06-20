package com.masai.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.Dto.ReturnProduct;

public class TransactionDaoImpl implements TransactionDao{
	
	static Connection con = null;
	
	@Override
	public List<Integer> getAllTransactionIdByParticularBuyer(String buyerUsername){
	
		List<Integer> list = new ArrayList<>();
		
		try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT transaction_id FROM transactions WHERE buyer_id = ?";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			
	       
			statement.setString(1, buyerUsername);
			
			ResultSet set = statement.executeQuery();
			
			if(set.isAfterLast() && set.getRow()==0) return null;
			
			while(set.next()) {
				
				
				list.add(set.getInt(1));
				
			}
				
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return list;	

		
		
		
	}
	
	@Override
	public List<String> getProductNameAndProductIdAndQuantityAndDateByIdAndReturn(int id) {
		
		List<String> list = new ArrayList<>();
		
	   try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_name, product_id, quantity, purchase_date, return_policy FROM transactions WHERE transaction_id = ?";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			
	       
			statement.setInt(1, id);
			
			ResultSet set = statement.executeQuery();
			
			if(set.isAfterLast() && set.getRow() == 0) return null;
			
			while(set.next()) {
				
				list.add(set.getString(1));
				list.add(set.getInt(2)+"");
				list.add(set.getInt(3)+"");
				list.add(set.getDate(4)+"");
				list.add(set.getInt(5)+"");
				
			}
						
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
			
		return list;
		
	}
	
	@Override
	public boolean returnProductTransaction(ReturnProduct returnProduct) {
		
		
		  try {
				
				con = DBUtils.getConnection();
				String INSERT_QUERY = "INSERT INTO returnproduct(product_id, product_name, reason_for_return, return_date, buyer_id, buyer_name, quantity, return_type) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
				
				
		       
				statement.setInt(1, returnProduct.getProdunctId());
				statement.setString(2, returnProduct.getProductName());
				statement.setString(3, returnProduct.getReasonForRefund());
				statement.setDate(4, Date.valueOf(returnProduct.getRefundDate()));
				statement.setString(5, returnProduct.getBuyerId());
				statement.setString(6, returnProduct.getBuyerName());
				statement.setInt(7, returnProduct.getQuantity());
				statement.setString(8, returnProduct.getType());
				
				
				if(statement.executeUpdate() > 0) return true;
							
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
				
			
			
		
		
		
		
		
		return false;
		
		
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}

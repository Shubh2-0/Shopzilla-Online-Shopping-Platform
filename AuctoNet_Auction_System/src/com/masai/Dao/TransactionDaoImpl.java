package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public List<String> getProductNameAndProductIdAndQuantityById(int id) {
		
		List<String> list = new ArrayList<>();
		
	   try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_name, product_id, quantity FROM transactions WHERE transaction_id = ?";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			
	       
			statement.setInt(1, id);
			
			ResultSet set = statement.executeQuery();
			
			if(set.isAfterLast() && set.getRow() == 0) return null;
			
			while(set.next()) {
				
				list.add(set.getString(1));
				list.add(set.getInt(2)+"");
				list.add(set.getInt(3)+"");
				
				
			}
						
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
			
		return list;
		
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}

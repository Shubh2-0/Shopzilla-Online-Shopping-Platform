package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDaoImpl implements ProductDao {
	
	
	@Override
	public boolean updateQuantity(int productId, int quantity) {
		
		Connection con = null;

		try {
			
			con = DBUtils.getConnection();
			
			String UPDATE_QUERY2 = "UPDATE PRODUCT SET quantity = ? WHERE product_id = ?";
			PreparedStatement statement3 = con.prepareStatement(UPDATE_QUERY2);
			
			statement3.setInt(1, quantity);
			statement3.setInt(2, productId);
			
			int ans3 = statement3.executeUpdate();
			
			System.out.println(ans3+" UPDATE PRODUCT");
			
			if(ans3 > 0) return true;
			
			
		} catch (Exception e) {
			
			
			
		}finally {
			
			DBUtils.closeConnection(con);
			
		}
			
			
			
			
			return false;
			
			
	
		
		
		
		
	}
	
	
	@Override
	public int getGStPercentage(int productId) {
		
		
		Connection con = null;
		int gst = 0;

		try {
			
			con = DBUtils.getConnection();
			
			String UPDATE_QUERY2 = "SELECT GST_PER FROM CATEGORY WHERE CAT_ID = (SELECT CATEGORY_ID FROM PRODUCT WHERE PRODUCT_ID = ?)";
			PreparedStatement statement3 = con.prepareStatement(UPDATE_QUERY2);
			
			
			statement3.setInt(1, productId);
			
		   ResultSet set = statement3.executeQuery();
		   
		   
		   
		   
		   while(set.next()) {
			   
			   gst = set.getInt("gst_per");
			   
		   }
		   
		   
			
		   
			
			
		} catch (Exception e) {
			
			
			
		}finally {
			
			DBUtils.closeConnection(con);
			
		}
			
			
			
			
			
			
			
			return gst;
	
		
		
		
		
		
		
	}
	

	

}

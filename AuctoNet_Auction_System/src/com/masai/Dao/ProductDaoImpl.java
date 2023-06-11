package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	

}

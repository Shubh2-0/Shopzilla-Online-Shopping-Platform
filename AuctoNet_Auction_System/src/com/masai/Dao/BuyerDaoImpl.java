package com.masai.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.masai.Dto.BuyerImpl;
import com.masai.Dto.ProductImpl;
import com.masai.Dto.RefundProductImpl;
import com.masai.Dto.TransactionImpl;


public class BuyerDaoImpl implements BuyerDao {

	static Connection con = null;
	static BuyerImpl buyer = null;
	
	
	@Override
	
	public BuyerImpl loginBuyer(String username, String password) {
	
	try {
		
		con = DBUtils.getConnection();
		
		String SELECT_QUERY = "SELECT * FROM BUYER WHERE USERNAME = ? AND PASSWORD = ?";
		
		PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
		
		statement.setString(1, username);
		statement.setString(2, password);
		
		
		ResultSet set = statement.executeQuery();
		
		while(set.next()) {
			buyer = new BuyerImpl(set.getString(1), 
					set.getString(2), 
					set.getString(3), 
					set.getString(4), 
					set.getString(5), 
					set.getString(6));
		}
		
		
		
	} catch (Exception e) {
		
		System.out.println(e);
		
	}finally {
		
		DBUtils.closeConnection(con);
	}
		
		
		
	return buyer;
		
		
	}
	
	

	@Override
	public String registerNewBuyer(BuyerImpl u) {
		
		buyer = u;
		
		try {
			
			con = DBUtils.getConnection();
			String INSERT_QUERY = "INSERT INTO BUYER VALUES(?,?,?,?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			
			statement.setString(1, u.getBuyerUserName());
			statement.setString(2, u.getPassword());
			statement.setString(3, u.getFirstName());
			statement.setString(4, u.getLastName());
			statement.setString(5, u.getMobileNo());
			statement.setString(6, u.getAddress());
			
			int ans = statement.executeUpdate();
			
			if(ans > 0)
				return "Acount Created Successfully....";
			
		    	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			DBUtils.closeConnection(con);
		}
		
		
		return "Something Went Wrong...";
		
	}

	
	
	@Override
	public String updateBuyerDetails(BuyerImpl u) {
		
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
			
			String UPDATE_QUERY = "UPDATE BUYER SET  FIRST_NAME = ?, LAST_NAME = ?, MOBILE_NO = ? , ADDRESS = ? WHERE USERNAME = ? AND PASSWORD = ?";
			
			PreparedStatement statement = con.prepareStatement(UPDATE_QUERY);
			
			statement.setString(1, buyer.getFirstName());
			statement.setString(2, buyer.getLastName());
			statement.setString(3, buyer.getMobileNo());
			statement.setString(4, buyer.getAddress());
			statement.setString(5, buyer.getBuyerUserName());
			statement.setString(6, buyer.getPassword());
			
			
			int ans = statement.executeUpdate();
			
			if(ans > 0)
				return "Information Updated Successfullt...";
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return "Faild to Update....";
		
	}

	@Override
	public ResultSet getAllProductForSell() {
		
		 
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT * FROM PRODUCT WHERE SOLD_STATUS = 0";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
						
						
		
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;
			
		
	}

	@Override
	public String purchaseItem(int productId, int quantity) {
	
		int totalQuantity = 0;
		
		try {
			
			con = DBUtils.getConnection();
			String SELCET_QUERY = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ? AND SOLD_STATUS = 0";
			
			PreparedStatement statement = con.prepareStatement(SELCET_QUERY);
			statement.setInt(1, productId);
			
			ResultSet set = statement.executeQuery();
			
			if(!set.isBeforeFirst() && set.getRow()==0)
				return "Product Out Of Stock....";
			
			while(set.next()) {
			
				totalQuantity = set.getInt("QUANTITY");
			}
			
			
			
		
			
			if(quantity!=0) {
				
			
			
				
			String INSERT_QUERY = "  INSERT INTO transactions ("
					+ "      product_id,"
					+ "      product_name,"
					+ "      buyer_id,"
					+ "      buyer_name,"
					+ "      quantity,"
					+ "      purchase_date,"
					+ "      amount_per_piece,"
					+ "      price, "
					+ "      gst_percentage,"
					+ "      tax_amount,"
					+ "      total_price,"
					+ "      return_policy) values("
					+ "      ?,"
					+ "       (SELECT product_name FROM product WHERE product_id=?),"
					+ "      ?,"
					+ "      (SELECT CONCAT(first_name, ' ', last_name) FROM buyer WHERE username=?),"
					+ "      ?,"
					+ "      ?,"
					+ "      (SELECT price_per_piece FROM product WHERE product_id=?),"
					+ "      amount_per_piece*?,"
					+ "      (SELECT GST_PER FROM CATEGORY WHERE CAT_ID = (SELECT CATEGORY_ID FROM PRODUCT WHERE PRODUCT_ID = ?)),"
					+ "      price*gst_percentage/100, "
					+ "     price + tax_amount, "
					+ "      1)";	
				 
			PreparedStatement statement2 = con.prepareStatement(INSERT_QUERY);
			
			statement2.setInt(1, productId);
			statement2.setInt(2, productId);
			statement2.setString(3,buyer.getBuyerUserName());
			statement2.setString(4,buyer.getBuyerUserName());
			statement2.setInt(5, quantity);
			statement2.setDate(6, Date.valueOf(LocalDate.now()));
		 statement2.setInt(7, productId);
		 statement2.setInt(8, quantity);
		 statement2.setInt(9, productId);
				
				int ans = statement2.executeUpdate();
				
				
				
				if(ans > 0) {
					
					String UPDATE_QUERY2 = "UPDATE PRODUCT SET QUANTITY = ? WHERE PRODUCT_ID = ?";
					
					PreparedStatement statement3 = con.prepareStatement(UPDATE_QUERY2);
					
					statement3.setInt(1, totalQuantity-quantity);
					statement3.setInt(2, productId);
				
					int ans3 = statement3.executeUpdate();
					
					if(ans3 > 0)
					return "Purchase Done...";
				}
				
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return "Something Went Wrong....";
		
	}

//	@Override
//	public String returnGoods(LocalDate date, int productId,int transactionId) {
//		
//		
//		try {
//			
//			con =  DBUtils.getConnection();
//			String SELECT_QUERY = "SELECT * FROM TRANSACTIONS WHERE TRANSACTION_ID = ?";
//		   	
//			
//			
//			
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		}finally {
//			DBUtils.closeConnection(con);
//		}
//	}

	@Override
	public ResultSet viewAllTransactions() {
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT * FROM TRANSACTIONS WHERE BUYER_ID = ?";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
		
				statement.setString(1, buyer.getBuyerUserName());
	   
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
	}

//	@Override
//	public ArrayList<RefundProductImpl> viewAllretuirnProduct() {
//		try {
//			
//			DBUtils.getConnection();
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		}finally {
//			DBUtils.closeConnection(con);
//		}
//	}
//
//	@Override
//	public String deleteAcount(String BuyerId, String password) {
//		try {
//			
//			DBUtils.getConnection();
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		}finally {
//			DBUtils.closeConnection(con);
//		}
//	}
//
//	
//	
	
	public static void main(String[] args) {
		BuyerDaoImpl h = new BuyerDaoImpl();
		System.out.println(h.loginBuyer("buyer1", "password1"));
		
		BuyerImpl b = new BuyerImpl("buyer1", "password1", null, "Sharma", "5783722441", "44 Sagar St, Delhi");
		
		System.out.println(h.updateBuyerDetails(b));
		
		System.out.println(h.loginBuyer("buyer1", "password1"));
	}



	public ResultSet getAllProductsByCategory(String item) {
		try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT * FROM PRODUCT WHERE CATEGORY_ID = (SELECT CAT_ID FROM CATEGORY WHERE CAT_NAME = ?)";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			
			statement.setString(1, item);
			
			ResultSet set = statement.executeQuery();
			
				
				
				
				return set;
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return null;
		
		
	}
	
	
	public ResultSet getProductsByProductId(int id) {
		try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
			
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

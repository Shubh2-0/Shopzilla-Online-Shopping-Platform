package com.masai.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.masai.Exceptions.InvalidCredentialsException;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.Dto.*;



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
			String SELECT_QUERY = "SELECT username UserName, first_name 'First Name', last_name 'Last Name', mobile_no 'Mobile Number', address Address FROM Buyer WHERE is_deleted != 1";
			
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
		
       ArrayList<Seller>  list = new ArrayList<>();
		
		try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT username UserName, first_name 'First Name', last_name 'Last Name', mobile_no 'Mobile Number', address Address FROM SELLER where is_deleted != 1";
			
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
				String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE sold_status = 0 AND is_hide = 0";


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
				String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE sold_status = 1 AND is_hide = 0";


				
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
				String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE category_id = (SELECT cat_id FROM category WHERE cat_name = ?) AND sold_status = 0 AND  is_hide = 0";

				
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
	public ResultSet getAllProductsBySellerUsername(String username)throws RecordNotFoundException {
		 
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE seller_username = ? AND sold_status = 0 AND is_hide = 0";

				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				statement.setString(1, username);
				
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
				String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE sold_status = 0 AND is_hide = 0 ORDER BY price_per_piece ";

				
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
				String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE quantity BETWEEN ? AND ? AND is_hide = 0 ORDER BY quantity";

				
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
				String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0";
				
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
				String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE PURCHASE_DATE BETWEEN ? AND ? AND is_hide = 0 ORDER BY PURCHASE_DATE";
				
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
				String SELECT_QUERY = "SELECT transaction_id AS `Transa/ction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE transaction_id = ? AND is_hide = 0";
				
				
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
				String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0 ORDER BY purchase_date";
				
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
				String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0 ORDER BY quantity";
				
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
				String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0 ORDER BY gst_percentage";
				
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
				String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0 ORDER BY total_price";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
		
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
		
		
		
	}
	
	
	

	

	
	
	

}

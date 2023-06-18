package com.masai.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import com.masai.Dto.BuyerImpl;
import com.masai.Dto.SellerImpl;
import com.masai.Exceptions.RecordNotFoundException;



public class BuyerDaoImpl implements BuyerDao {

	static Connection con = null;
	static BuyerImpl buyer = null;
	static SellerImpl seller = null;
	static SellerDao sellerDao = new SellerDaoImpl();
	static ProductDao productDao = new ProductDaoImpl();
	
	
	
	
	@Override
	public BuyerImpl loginBuyer(String username, String password) {
	
		buyer = null;
		
	try {
		
		con = DBUtils.getConnection();
		
		String SELECT_QUERY = "SELECT * FROM BUYER WHERE username = ? AND password = ? AND is_deleted != 1";
		
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
					set.getString(6),
					set.getDouble(7)
					);
		}
	
		
		
	} catch (Exception e) {
		
		System.out.println(e);
		
	}
		
		
		
	return buyer;
		
		
	}
	
	
	
	
	@Override
    public double getBalance(String username) {
		
		double balance = 0.0;
		
		try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "SELECT balance FROM BUYER WHERE username = ? AND is_deleted != 1";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
			
			statement.setString(1, username);
			
			
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				
				balance = set.getDouble("balance");
				
			}
		
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return balance;
		
		
	}
		
	
	
	
	@Override
	public BuyerImpl getBuyerByUsername(String username) {
	username = username.trim();
	BuyerImpl buy = null;
	
	try {
		
		con = DBUtils.getConnection();
		
		String SELECT_QUERY = "SELECT * FROM BUYER WHERE USERNAME = ? AND is_deleted != 1";
		
		PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
		
		statement.setString(1, username);
	
		
		
		ResultSet set = statement.executeQuery();
		
		while(set.next()) {
			buy = new BuyerImpl(set.getString(1), 
					set.getString(2), 
					set.getString(3), 
					set.getString(4), 
					set.getString(5), 
					set.getString(6),
					set.getDouble(7));
		}
		
		
		
	} catch (Exception e) {
		
		System.out.println(e);
		
	}

		
		
	return buy;
		
		
	}
	
	
	
	
	@Override
	public String registerNewBuyer(BuyerImpl u) {
		
		buyer = u;
		
		try {
			
			con = DBUtils.getConnection();
			String INSERT_QUERY = "INSERT INTO BUYER VALUES(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			
			statement.setString(1, u.getBuyerUserName());
			statement.setString(2, u.getPassword());
			statement.setString(3, u.getFirstName());
			statement.setString(4, u.getLastName());
			statement.setString(5, u.getMobileNo());
			statement.setString(6, u.getAddress());
			statement.setDouble(7, u.getBalance());
			statement.setInt(8, 0);
			statement.setDate(9, null);
			
			int ans = statement.executeUpdate();
			
			if(ans > 0)
				return "Acount Created Successfully....";
			
		    	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
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
				String SELECT_QUERY = "SELECT product_id AS 'Product ID', product_name AS 'Name', price_per_piece AS 'Price Per Unit', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category Number', IF(return_policy = 1, 'Applicable', 'Not Applicable') AS 'Return' FROM product WHERE sold_status = 0 AND is_hide = 0";
				
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
		double perUnitPrice = 0.0;
		int seller_Id  = 0;
		String usernmae = buyer.getBuyerUserName();
		String sellerusername = null;
		int gst = productDao.getGStPercentage(productId);	
		int returnPolicy = 0;
		
		
		try {
			
			con = DBUtils.getConnection();
			String SELCET_QUERY = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ? AND SOLD_STATUS = 0 AND is_hide = 0";
			
			PreparedStatement statement = con.prepareStatement(SELCET_QUERY);
			statement.setInt(1, productId);
			
			ResultSet set = statement.executeQuery();
			
			if(!set.isBeforeFirst() && set.getRow()==0)
				return "Product Out Of Stock....";
			
			while(set.next()) {
			
				totalQuantity = set.getInt("quantity");
				perUnitPrice = set.getDouble("price_per_piece");
				seller_Id = set.getInt("seller_unique_num");
				sellerusername = set.getString("seller_username");
				returnPolicy = set.getInt("return_policy");
				
				
			}
			
			
			
			
			double bill = perUnitPrice*quantity;
			
			double balance = buyer.getBalance();
			
			if(balance < bill) {
				
				return "Not enough balance";
				
			}
		
			if(quantity > totalQuantity) {
				
				return "Quantity is high";
				
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
					+ "      ?)";	
				 
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
	     statement2.setInt(10, returnPolicy);			
				int ans = statement2.executeUpdate();
				
				
				
				if(ans > 0) {
	
					
					seller = sellerDao.getSellerByUsername(sellerusername);
					
					
					
					
					
					String UPDATE_QUERY3 = "UPDATE BUYER SET balance = ? WHERE UserName = ?";
					
					String UPDATE_QUERY4 = "UPDATE SELLER SET income = ? WHERE SellerId = ?";
					
					
					
					PreparedStatement statement4 = con.prepareStatement(UPDATE_QUERY3);
					PreparedStatement statement5 = con.prepareStatement(UPDATE_QUERY4);
					
					
					
					
					
				
					
					double sellerBalance = 0.0;
					
					sellerBalance = seller.getIncome();
					
					
					
				
					
					
		            
		              
					
			
					
					
					
					if(totalQuantity-quantity == 0) {
						
						String UPDATE_QUERY7 = "UPDATE Product SET sold_status = 1 WHERE product_id = ?";
						
						PreparedStatement statement7 = con.prepareStatement(UPDATE_QUERY7);
						statement7.setInt(1, productId);
						
						int ans8 = statement7.executeUpdate();
						
						
						
						
					}
					
					
					double tax = bill*gst/100;
					bill+=tax;
					
					
					statement4.setDouble(1, balance-bill);
					statement4.setString(2, usernmae);
					
					statement5.setDouble(1, sellerBalance+bill);
					statement5.setInt(2, seller_Id);
					
					
				
					
					int ans4 = statement4.executeUpdate();
					int ans5 = statement5.executeUpdate();
					
					if(productDao.updateQuantity(productId, totalQuantity-quantity) && ans4 > 0 && ans5 > 0) {
					
						bill = Math.round(bill * 100.0) / 100.0;
						
						return "PURCHASE DONE\n"+
						       "A MESSAGE FROM SELLER : \n"+"Dear ,"+buyer.getFirstName()+"Thank you for your purchase! We appreciate your patronage\n"+
						       "Total bill : "+bill;
		                       				                      
						
						
						
						
					}
					
				}
				
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return "Something Went Wrong....LAST";
		
	}
 
	
	
	
	
	@Override
	public boolean unhideTransactions(String username) {
		     
          try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "UPDATE transactions SET is_hide = 0 WHERE buyer_id = ?";
			
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
	public boolean hideTransactions(String username,String name) {
		     
          try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "UPDATE transactions SET is_hide = 1 WHERE buyer_id = ? AND buyer_name = ?";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
			
			statement.setString(1, username);
			statement.setString(2, name);
			
			
			int ans = statement.executeUpdate();
			
			if(ans > 0 ) return true;
			
			
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
			
			
		return false;
			
		
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
				String SELECT_QUERY = "SELECT transaction_id AS 'Transaction ID', product_id AS 'Product ID', product_name AS 'Product Name', quantity AS Quantity, purchase_date AS 'Purchase Date', amount_per_piece AS 'Price Per Unit', price AS 'Total Price Before Tax', gst_percentage AS 'GST Percentage', tax_amount AS 'Tax Amount', total_price AS 'Final Price', If(return_policy = 1,'YES','NO') AS 'Return Applicable' FROM transactions WHERE buyer_id = ?";
				
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

	
	
	
	
    @Override
	public ResultSet getAllProductsByCategory(String item) {
		try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_id AS 'Product ID', product_name AS 'Name', price_per_piece AS 'Price Per Unit', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category Number', IF(return_policy = 1, 'Applicable', 'Not Applicable') AS 'Return' FROM product WHERE CATEGORY_ID = (SELECT CAT_ID FROM CATEGORY WHERE CAT_NAME = ?) AND sold_status = 0 AND is_hide = 0";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			
			statement.setString(1, item);
			
			ResultSet set = statement.executeQuery();
			
				
				
				
				return set;
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
		return null;
		
		
	}
	
    
    
    
	@Override
	public ResultSet getProductsByProductId(int id) {
		try {
			
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_id AS 'Product ID', product_name AS 'Name', price_per_piece AS 'Price Per Unit', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category Number',  IF(return_policy = 1, 'Applicable', 'Not Applicable') AS 'Return' FROM product WHERE sold_status = 0 AND is_hide = 0 AND PRODUCT_ID = ?";
			
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
	public boolean addAmountToBuyerBalance(double amount,String unsername) {
		
		
		try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "UPDATE buyer SET balance = ? WHERE username = ?";
			
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
	public boolean deleteBuyer(String username,String password) {
		
		try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "UPDATE buyer SET deleted_date = NOW() , is_deleted = 1, balance = 0.00 WHERE username = ? AND password = ?";
			
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
	
	
	@Override
	public String recoverBuyerAcount(String username, String password, LocalDate date) {
		
		String tempDate = null;
		
		try {
			
			con = DBUtils.getConnection();
			
			String SELECT_QUERY = "SELECT * FROM BUYER WHERE username = ? AND password = ? AND is_deleted = 1";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY); 
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				
				tempDate = set.getDate("deleted_date").toString();
			}
		
			if(tempDate == null) return "We couldn't find any account associated with the provided username and password for the purpose of recovery";
			
			
			LocalDate deletedDate = LocalDate.parse(tempDate);
			
			if(ChronoUnit.DAYS.between(deletedDate, date) > 30) return "We regret😢 to inform you that the account recovery period has expired. We understand that this may be disappointing news.\n"
					+ "Unfortunately, it is not possible to recover your account as it has been more than 30 days since it was deleted.\n"
					+ "We apologize for any inconvenience caused. If you wish to continue using our services, we encourage you to create a new account.";
			 
			
			String UPDATE_QUERY = "UPDATE buyer SET is_deleted = 0, deleted_date = null WHERE UserName = ? AND password = ?" ;
           
			
            statement = con.prepareStatement(UPDATE_QUERY); 
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			int ans = statement.executeUpdate();
			
			
			
			if(ans > 0 && unhideTransactions(username)) return "Congratulations! Your account has been successfully recovered.\n"
					+ "We are thrilled to have you back and ready to explore and purchase new products.\n"
					+ "Let's embark on this exciting journey together and discover a world of amazing offerings.\n"
					+ "                                            😊😊Happy shopping!😊😊"; 
			
			

			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
			
		
		
		
		
		
		
		return "Something Went Wrong";
		
	}
	
   
	@Override
	public ResultSet getBuyerAllTransactionbyDateRange(LocalDate startDate, LocalDate endDate, String username)throws RecordNotFoundException {
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT transaction_id AS 'Transaction ID', product_id AS 'Product ID', product_name AS 'Product Name', quantity AS Quantity, purchase_date AS 'Purchase Date', amount_per_piece AS 'Price Per Unit', price AS 'Total Price Before Tax', gst_percentage AS 'GST Percentage', tax_amount AS 'Tax Amount', total_price AS 'Final Price', If(return_policy = 1,'YES','NO') AS 'Return Applicable' FROM transactions WHERE PURCHASE_DATE BETWEEN ? AND ? AND buyer_id = ? ORDER BY PURCHASE_DATE";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				Date s = Date.valueOf(startDate);
				Date e = Date.valueOf(endDate);
				
		
				statement.setDate(1, s);
				statement.setDate(2, e);
				statement.setString(3, username);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
				return set;
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
		
	}

	
	@Override
	public ResultSet getBuyerAllTransactionByPurchaseDate(String username)throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT transaction_id AS 'Transaction ID', product_id AS 'Product ID', product_name AS 'Product Name', quantity AS Quantity, purchase_date AS 'Purchase Date', amount_per_piece AS 'Price Per Unit', price AS 'Total Price Before Tax', gst_percentage AS 'GST Percentage', tax_amount AS 'Tax Amount', total_price AS 'Final Price', If(return_policy = 1,'YES','NO') AS 'Return Applicable' FROM transactions WHERE buyer_id = ? ORDER BY purchase_date";
				
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
	public ResultSet getBuyerAllTransactionByQuantity(String username) throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT transaction_id AS 'Transaction ID', product_id AS 'Product ID', product_name AS 'Product Name', quantity AS Quantity, purchase_date AS 'Purchase Date', amount_per_piece AS 'Price Per Unit', price AS 'Total Price Before Tax', gst_percentage AS 'GST Percentage', tax_amount AS 'Tax Amount', total_price AS 'Final Price', If(return_policy = 1,'YES','NO') AS 'Return Applicable' FROM transactions WHERE buyer_id = ? ORDER BY quantity";
				
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
	public ResultSet getBuyerAllTransactionByGSTPercentage(String username)throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT transaction_id AS 'Transaction ID', product_id AS 'Product ID', product_name AS 'Product Name', quantity AS Quantity, purchase_date AS 'Purchase Date', amount_per_piece AS 'Price Per Unit', price AS 'Total Price Before Tax', gst_percentage AS 'GST Percentage', tax_amount AS 'Tax Amount', total_price AS 'Final Price', If(return_policy = 1,'YES','NO') AS 'Return Applicable' FROM transactions WHERE buyer_id = ? ORDER BY gst_percentage";
				
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
	public ResultSet getBuyerAllTransactionByTotalPrice(String username)throws RecordNotFoundException {
	
		
			
			try {
				
				con = DBUtils.getConnection();
				String SELECT_QUERY = "SELECT transaction_id AS 'Transaction ID', product_id AS 'Product ID', product_name AS 'Product Name', quantity AS Quantity, purchase_date AS 'Purchase Date', amount_per_piece AS 'Price Per Unit', price AS 'Total Price Before Tax', gst_percentage AS 'GST Percentage', tax_amount AS 'Tax Amount', total_price AS 'Final Price', If(return_policy = 1,'YES','NO') AS 'Return Applicable' FROM transactions WHERE buyer_id = ? ORDER BY total_price";
				
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
		       
				statement.setString(1, username);
				
				ResultSet set = statement.executeQuery();
				
					
					
					
					return set;
					
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			return null;	
		
		
		
	}
	
	
	

	
}

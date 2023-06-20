package com.masai.Dao;


import java.sql.ResultSet;
import java.time.LocalDate;
import com.masai.Dto.*;
import com.masai.Exceptions.InvalidCredentialsException;
import com.masai.Exceptions.RecordNotFoundException;

public interface BuyerDao {
	
	Buyer loginBuyer(String username, String password)throws InvalidCredentialsException;
	
	String registerNewBuyer(Buyer buyer);
	
	String updateBuyerDetails(Buyer bueyr);
	
	ResultSet getAllProductForSell() throws RecordNotFoundException;
	
	public String purchaseItem(int productId, int quantity);
	
//	String returnGoods(LocalDate date,int productId,int transactionId);
	
	ResultSet viewAllTransactions();
	
	public ResultSet getAllProductsByCategory(String item);

	ResultSet getProductsByProductId(int id);

	Buyer getBuyerByUsername(String username);

	double getBalance(String username);

	boolean addAmountToBuyerBalance(double amount, String unsername);

	boolean deleteBuyer(String username, String password);

	boolean hideTransactions(String username);

	String recoverBuyerAcount(String username, String password, LocalDate date);

	boolean unhideTransactions(String username);

	ResultSet getBuyerAllTransactionbyDateRange(LocalDate startDate, LocalDate endDate, String username)
			throws RecordNotFoundException;

	ResultSet getBuyerAllTransactionByTotalPrice(String username) throws RecordNotFoundException;

	ResultSet getBuyerAllTransactionByGSTPercentage(String username) throws RecordNotFoundException;

	ResultSet getBuyerAllTransactionByQuantity(String username) throws RecordNotFoundException;

	ResultSet getBuyerAllTransactionByPurchaseDate(String username) throws RecordNotFoundException;

	boolean purchaseReturnItem(int productId, int quantity);

	ResultSet getAllReturnProduct(String username);

	ResultSet getAllReturnProductOfBuyerByType(String username, String type);
		
//	ArrayList<RefundProductImpl> viewAllrefundProduct();

    

	
	
}

package com.masai.Dao;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import com.masai.Dto.BuyerImpl;
import com.masai.Dto.ProductImpl;
import com.masai.Dto.RefundProductImpl;
import com.masai.Dto.TransactionImpl;
import com.masai.Exceptions.InvalidCredentialsException;
import com.masai.Exceptions.RecordNotFoundException;

public interface BuyerDao {
	
	BuyerImpl loginBuyer(String username, String password)throws InvalidCredentialsException;
	
	String registerNewBuyer(BuyerImpl buyer);
	
	String updateBuyerDetails(BuyerImpl bueyr);
	
	ResultSet getAllProductForSell() throws RecordNotFoundException;
	
	public String purchaseItem(int productId, int quantity);
	
//	String returnGoods(LocalDate date,int productId,int transactionId);
	
	ResultSet viewAllTransactions();
	
	public ResultSet getAllProductsByCategory(String item);

	ResultSet getProductsByProductId(int id);

	BuyerImpl getBuyerByUsername(String username);

	double getBalance(String username);

	
//	ArrayList<RefundProductImpl> viewAllrefundProduct();
	
//    String deleteAcount(String BuyerId,String password);
    

	
	
}

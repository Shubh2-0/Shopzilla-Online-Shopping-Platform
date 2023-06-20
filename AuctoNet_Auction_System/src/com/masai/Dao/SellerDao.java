package com.masai.Dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.masai.Dto.*;


public interface SellerDao {
	
	Seller getSellerByUsername(String username);

	Seller loginSeller(String username, String password);

	String updateSellerDetails(Seller u);

	double getSellerIncome(String username);

	String registerNewSeller(Seller s);


	boolean unhideSellerProducts(String username);

	boolean hideSellerProducts(String username);

	ResultSet getSellerAllProductsByCategory(String item, String username);

	boolean amountWithrowBySeller(double amount, String unsername);

	boolean deleteSeller(String username, String password);

	ResultSet getAllSellerProducts(String username);

	List<Integer> getSellerProductsID(String username);

	ResultSet getAllSellerProductsOrderByQuantity(String username);

	ResultSet getAllSellerProductsOrderByPrice(String username);

	double getSellerPendingAmount(String username);



	boolean sellerPaidPendingAmount(double pendingAamount, String username, double income);

	boolean addSellerPendingAmount(String username, double newPaidAmount);

	double refundToBuyer(int productId, int quantity);

	boolean reopenSeller(String username, String password);
    
}

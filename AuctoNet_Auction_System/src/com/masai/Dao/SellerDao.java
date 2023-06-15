package com.masai.Dao;

import java.time.LocalDate;
import java.util.ArrayList;

import com.masai.Dto.BuyerImpl;
import com.masai.Dto.ProductImpl;
import com.masai.Dto.RefundProductImpl;
import com.masai.Dto.SellerImpl;
import com.masai.Dto.TransactionImpl;


public interface SellerDao {
	
//	String registerSeller(UserImpl u);
//	String updateSellerDetails(UserImpl u);
//	ArrayList<ProductImpl> getAllProductForSell();
//	String purchaseItem(int productId);
//	String returnGoods(LocalDate date,int productId);
//	ArrayList<TransactionImpl> viewAllTransactions(String UuserName);
//	ArrayList<RefundProductImpl> viewAllrefundProduct();
//	String updateProductDetails(ProductImpl product);
//    String deleteAcount(String username,String password);
//    
//    

	SellerImpl getSellerByUsername(String username);

	SellerImpl loginSeller(String username, String password);

	String updateSellerDetails(SellerImpl u);
    
}

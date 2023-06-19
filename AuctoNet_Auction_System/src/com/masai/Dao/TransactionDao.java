package com.masai.Dao;

import java.util.List;

import com.masai.Dto.ReturnProduct;

public interface TransactionDao {

	List<Integer> getAllTransactionIdByParticularBuyer(String buyerUsername);


	List<String> getProductNameAndProductIdAndQuantityById(int id);


	boolean returnProductTransaction(ReturnProduct returnProduct);
	
	
	

}

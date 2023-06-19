package com.masai.Dao;

import java.util.List;

public interface TransactionDao {

	List<Integer> getAllTransactionIdByParticularBuyer(String buyerUsername);


	List<String> getProductNameAndProductIdAndQuantityById(int id);
	
	
	

}

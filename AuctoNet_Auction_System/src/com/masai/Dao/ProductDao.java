package com.masai.Dao;

public interface ProductDao {

	boolean updateQuantity(int productId, int quantity);

	int getGStPercentage(int productId);

}

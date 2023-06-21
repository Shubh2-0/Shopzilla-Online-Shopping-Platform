package com.masai.Dao;

import java.util.List;

import com.masai.Dto.ReturnProduct;

public interface TransactionDao {

	/**
	 * Retrieves all transaction IDs associated with a particular buyer.
	 *
	 * @param buyerUsername The username of the buyer.
	 */
	List<Integer> getAllTransactionIdByParticularBuyer(String buyerUsername);

	/**
	 * Retrieves the product name, product ID, quantity, and date of a transaction
	 * by its ID and return status.
	 *
	 * @param id The ID of the transaction.
	 * @return A list containing the product name, product ID, quantity, and date.
	 */
	List<String> getProductNameAndProductIdAndQuantityAndDateByIdAndReturn(int id);

	/**
	 * Processes the return of a product as a transaction.
	 *
	 * @param returnProduct The return product object.
	 * @return {@code true} if the return transaction was successfully processed,
	 *         {@code false} otherwise.
	 */
	boolean returnProductTransaction(ReturnProduct returnProduct);

}

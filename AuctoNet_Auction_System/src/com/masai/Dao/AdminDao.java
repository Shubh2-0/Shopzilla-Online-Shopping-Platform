package com.masai.Dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import com.masai.Exceptions.InvalidCredentialsException;
import com.masai.Exceptions.RecordNotFoundException;

public interface AdminDao {

	/**
	 * Login as an admin.
	 *
	 * @param adminId  The admin ID.
	 * @param password The admin password.
	 * @return True if the login is successful, False otherwise.
	 * @throws InvalidCredentialsException If the admin ID or password is invalid.
	 */
	Boolean loginAdmin(String adminId, String password);

	/**
	 * Retrieve all active buyers.
	 *
	 * @return A ResultSet containing information about all active buyers.
	 * @throws RecordNotFoundException If no active buyers are found.
	 */
	ResultSet getAllBuyer() throws RecordNotFoundException;

	/**
	 * Retrieve all active sellers.
	 *
	 * @return A ResultSet containing information about all active sellers.
	 * @throws RecordNotFoundException If no active sellers are found.
	 */
	ResultSet getAllSeller();

	/**
	 * Retrieve all products.
	 *
	 * @return A ResultSet containing information about all products.
	 * @throws RecordNotFoundException If no products are found.
	 */
	ResultSet getAllProducts() throws RecordNotFoundException;

	/**
	 * Retrieve all sold products.
	 *
	 * @return A ResultSet containing information about all sold products.
	 * @throws RecordNotFoundException If no sold products are found.
	 */
	ResultSet getAllSoldProducts() throws RecordNotFoundException;

	/**
	 * Retrieve all products belonging to a specific category.
	 *
	 * @param categoryName The name of the category.
	 * @return A ResultSet containing information about all products in the
	 *         specified category.
	 * @throws RecordNotFoundException If no products are found in the specified
	 *                                 category.
	 */
	ResultSet getAllProductsByCategory(String CatName) throws RecordNotFoundException;

	/**
	 * Retrieve all products belonging to a specific seller's username.
	 *
	 * @param username The username of the seller.
	 * @return A ResultSet containing information about all products belonging to
	 *         the specified seller.
	 * @throws RecordNotFoundException If no products are found for the specified
	 *                                 seller.
	 */
	ResultSet getAllProductsBySellerUsername(String username) throws RecordNotFoundException;

	/**
	 * Retrieve all products sorted in ascending order of price.
	 *
	 * @return A ResultSet containing information about all products sorted by price
	 *         in ascending order.
	 * @throws RecordNotFoundException If no products are found.
	 */
	ResultSet getAllProductsByInAccendingOrderByPrice() throws RecordNotFoundException;

	/**
	 * Retrieve all products within a specified quantity range.
	 *
	 * @param from The minimum quantity.
	 * @param to   The maximum quantity.
	 * @return A ResultSet containing information about all products within the
	 *         specified quantity range.
	 * @throws RecordNotFoundException If no products are found within the specified
	 *                                 quantity range.
	 */
	ResultSet getAllProductsByQuantity(int from, int to) throws RecordNotFoundException;

	/**
	 * Retrieve all transactions.
	 *
	 * @return A ResultSet containing information about all transactions.
	 * @throws RecordNotFoundException If no transactions are found.
	 */
	ResultSet getAllTransaction() throws RecordNotFoundException;

	/**
	 * Retrieve all transactions within a specific date range.
	 *
	 * @param startDate The start date of the range.
	 * @param endDate   The end date of the range.
	 * @return A ResultSet containing information about all transactions within the
	 *         specified date range.
	 * @throws RecordNotFoundException If no transactions are found within the
	 *                                 specified date range.
	 */
	ResultSet getAllTransactionbyDateRange(LocalDate startDate, LocalDate endDate) throws RecordNotFoundException;

	/**
	 * Retrieve a transaction by its ID.
	 *
	 * @param id The ID of the transaction.
	 * @return A ResultSet containing information about the transaction with the
	 *         specified ID.
	 * @throws RecordNotFoundException If no transaction is found with the specified
	 *                                 ID.
	 */
	ResultSet getTransactionById(int id) throws RecordNotFoundException;

	/**
	 * Retrieve all transactions sorted by purchase date.
	 *
	 * @return A ResultSet containing information about all transactions sorted by
	 *         purchase date.
	 * @throws RecordNotFoundException If no transactions are found.
	 */
	ResultSet getAllTransactionByPurchaseDate() throws RecordNotFoundException;

	/**
	 * Retrieve all transactions sorted by quantity.
	 *
	 * @return A ResultSet containing information about all transactions sorted by
	 *         quantity.
	 * @throws RecordNotFoundException If no transactions are found.
	 */
	ResultSet getAllTransactionByQuantity() throws RecordNotFoundException;

	/**
	 * Retrieve all transactions sorted by GST percentage.
	 *
	 * @return A ResultSet containing information about all transactions sorted by
	 *         GST percentage.
	 * @throws RecordNotFoundException If no transactions are found.
	 */
	ResultSet getAllTransactionByGSTPercentage() throws RecordNotFoundException;

	/**
	 * Retrieve all transactions sorted by total price.
	 *
	 * @return A ResultSet containing information about all transactions sorted by
	 *         total price.
	 * @throws RecordNotFoundException If no transactions are found.
	 */
	ResultSet getAllTransactionByTotalPrice() throws RecordNotFoundException;

}

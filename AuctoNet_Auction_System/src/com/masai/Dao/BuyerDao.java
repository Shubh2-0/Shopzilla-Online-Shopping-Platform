package com.masai.Dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import com.masai.Dto.*;
import com.masai.Exceptions.InvalidCredentialsException;
import com.masai.Exceptions.RecordNotFoundException;

public interface BuyerDao {

	/**
	 * Login as a buyer.
	 *
	 * @param username The buyer's username.
	 * @param password The buyer's password.
	 * @return The Buyer object representing the logged-in buyer.
	 * @throws InvalidCredentialsException If the username or password is invalid.
	 */
	Buyer loginBuyer(String username, String password);

	/**
	 * Retrieve buyer balance by username.
	 *
	 * @param username The username of the buyer.
	 * @return The balance of the buyer with the specified username.
	 */
	double getBalance(String username);

	/**
	 * Retrieve buyer details by username.
	 *
	 * @param username The username of the buyer.
	 * @return The Buyer object representing the buyer with the specified username.
	 */
	Buyer getBuyerByUsername(String username);

	/**
	 * Register a new buyer.
	 *
	 * @param buyer The Buyer object containing the buyer's information.
	 * @return A message indicating the success or failure of the registration
	 *         process.
	 */
	String registerNewBuyer(Buyer u);

	/**
	 * Update buyer details.
	 *
	 * @param buyer The Buyer object containing the updated buyer's information.
	 * @return A message indicating the success or failure of the update process.
	 */
	String updateBuyerDetails(Buyer u);

	/**
	 * Retrieve all products available for sale.
	 *
	 * @return A ResultSet containing information about all products available for
	 *         sale.
	 * @throws RecordNotFoundException If no products for sale are found.
	 */
	ResultSet getAllProductForSell();

	/**
	 * Purchase return items.
	 *
	 * @param productId The ID of the product to return.
	 * @param quantity  Thequantity to return.
	 * 
	 * @return True if the return is successful, False otherwise.
	 */
	boolean purchaseReturnItem(int productId, int quantity);

	/**
	 * Purchase an item.
	 *
	 * @param productId The ID of the product to purchase.
	 * @param quantity  The quantity to purchase.
	 * @return A message indicating the success or failure of the purchase process.
	 */
	String purchaseItem(int productId, int quantity);

	/**
	 * Unhide buyer transactions .
	 *
	 * @param username The username of the buyer.
	 * @return True if the transactions are successfully unhidden, False otherwise.
	 */
	boolean unhideTransactions(String username);

	/**
	 * Hide buyer transactions .
	 *
	 * @param username The username of the buyer.
	 * @return True if the transactions are successfully hidden, False otherwise.
	 */
	boolean hideTransactions(String username);

	/**
	 * View all transactions.
	 *
	 * @return A ResultSet containing information about all transactions.
	 */
	ResultSet viewAllTransactions();

	/**
	 * Retrieve all products by category.
	 *
	 * @param category The category of the products.
	 * @return A ResultSet containing information about all products in the
	 *         specified category.
	 * @throws RecordNotFoundException If no products are found in the specified
	 *                                 category.
	 */
	ResultSet getAllProductsByCategory(String item);

	/**
	 * Retrieve product by product ID.
	 *
	 * @param id The ID of the product.
	 * @return A ResultSet containing information about the product with the
	 *         specified ID.
	 * @throws RecordNotFoundException If no product is found with the specified ID.
	 */
	ResultSet getProductsByProductId(int id);

	/**
	 * Adds a specified amount to the buyer's balance.
	 *
	 * @param amount   The amount to add to the buyer's balance.
	 * @param username The username of the buyer.
	 * @return {@code true} if the balance was successfully updated, {@code false}
	 *         otherwise.
	 */
	boolean addAmountToBuyerBalance(double amount, String unsername);

	/**
	 * Deletes a buyer based on their username and password.
	 *
	 * @param username The username of the buyer.
	 * @param password The password of the buyer.
	 * @return {@code true} if the buyer was successfully deleted, {@code false}
	 *         otherwise.
	 */
	boolean deleteBuyer(String username, String password);

	/**
	 * Recovers a buyer's account based on their username, password, and recovery
	 * date.
	 *
	 * @param username The username of the buyer.
	 * @param password The password of the buyer.
	 * @param date     The recovery date of the buyer's account.
	 * @return The recovered buyer account as a string.
	 */
	String recoverBuyerAcount(String username, String password, LocalDate date);

	/**
	 * Retrieves all transactions of a buyer within a specified date range.
	 *
	 * @param startDate The start date of the date range.
	 * @param endDate   The end date of the date range.
	 * @param username  The username of the buyer.
	 * @return A ResultSet containing the transactions within the date range.
	 * @throws RecordNotFoundException If no transactions are found within the
	 *                                 specified date range.
	 */
	ResultSet getBuyerAllTransactionbyDateRange(LocalDate startDate, LocalDate endDate, String username)
			throws RecordNotFoundException;

	/**
	 * Retrieves all transactions of a buyer based on the purchase date of the
	 * transactions.
	 *
	 * @param username The username of the buyer.
	 * @return A ResultSet containing the transactions.
	 * @throws RecordNotFoundException If no transactions are found for the buyer.
	 */
	ResultSet getBuyerAllTransactionByPurchaseDate(String username) throws RecordNotFoundException;

	/**
	 * Retrieves all transactions of a buyer based on the quantity of the
	 * transactions.
	 *
	 * @param username The username of the buyer.
	 * @return A ResultSet containing the transactions.
	 * @throws RecordNotFoundException If no transactions are found for the buyer.
	 */
	ResultSet getBuyerAllTransactionByQuantity(String username) throws RecordNotFoundException;

	/**
	 * Retrieves all transactions of a buyer based on the GST percentage of the
	 * transactions.
	 *
	 * @param username The username of the buyer.
	 * @return A ResultSet containing the transactions.
	 * @throws RecordNotFoundException If no transactions are found for the buyer.
	 */
	ResultSet getBuyerAllTransactionByGSTPercentage(String username) throws RecordNotFoundException;

	/**
	 * Retrieves all transactions of a buyer based on the total price of the
	 * transactions.
	 *
	 * @param username The username of the buyer.
	 * @return A ResultSet containing the transactions.
	 * @throws RecordNotFoundException If no transactions are found for the buyer.
	 */
	ResultSet getBuyerAllTransactionByTotalPrice(String username) throws RecordNotFoundException;

	/**
	 * Retrieves all return products for a buyer.
	 *
	 * @param username The username of the buyer.
	 * @return A ResultSet containing the return products.
	 */
	ResultSet getAllReturnProduct(String username);

	/**
	 * Retrieves all return products of a buyer by the specified type.
	 *
	 * @param username The username of the buyer.
	 * @param type     The type of return products to retrieve.
	 * @return A ResultSet containing the return products.
	 */
	ResultSet getAllReturnProductOfBuyerByType(String username, String type);

	

}

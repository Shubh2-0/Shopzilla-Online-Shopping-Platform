package com.masai.Dao;

import java.sql.ResultSet;
import java.util.List;
import com.masai.Dto.*;

public interface SellerDao {

	/**
	 * Validates the seller's login credentials.
	 *
	 * @param username The username of the seller.
	 * @param password The password of the seller.
	 * @return The authenticated seller object.
	 */
	Seller loginSeller(String username, String password);

	/**
	 * Retrieves the income earned by the seller username.
	 *
	 * @param username The username of the seller.
	 * @return The total income of the seller.
	 */
	double getSellerIncome(String username);

	/**
	 * Initiates a refund to the buyer for a specific product and quantity.
	 *
	 * @param productId The ID of the product to be refunded.
	 * @param quantity  The quantity of the product to be refunded.
	 * @return The refund amount.
	 */
	double refundToBuyer(int productId, int quantity);

	/**
	 * Retrieves the seller details based on the username.
	 *
	 * @param username The username of the seller.
	 * @return The seller object.
	 */
	Seller getSellerByUsername(String username);

	/**
	 * Updates the details of a seller.
	 *
	 * @param seller The updated seller object.
	 * @return The updated seller details as a string.
	 */
	String updateSellerDetails(Seller u);

	/**
	 * Registers a new seller.
	 *
	 * @param seller The seller object to register.
	 * @return A success message upon successful registration.
	 */
	String registerNewSeller(Seller s);

	/**
	 * Retrieves all products of a seller.
	 *
	 * @param username The username of the seller.
	 * @return A ResultSet containing all the products of the seller.
	 */
	ResultSet getAllSellerProducts(String username);

	/**
	 * Retrieves all seller products ordered by quantity.
	 *
	 * @param username The username of the seller.
	 * @return A ResultSet containing the products.
	 */
	ResultSet getAllSellerProductsOrderByQuantity(String username);

	/**
	 * Unhides the products of a seller.
	 *
	 * @param username The username of the seller.
	 * @return {@code true} if the products were successfully unhidden,
	 *         {@code false} otherwise.
	 */
	boolean unhideSellerProducts(String username);

	/**
	 * Hides the products of a seller.
	 *
	 * @param username The username of the seller.
	 * @return {@code true} if the products were successfully hidden, {@code false}
	 *         otherwise.
	 */
	boolean hideSellerProducts(String username);

	/**
	 * Retrieves all products of a seller belonging to a specific category.
	 *
	 * @param item     The category of the products.
	 * @param username The username of the seller.
	 * @return A ResultSet containing the products.
	 */
	ResultSet getSellerAllProductsByCategory(String item, String username);

	/**
	 * Withdraws a specified amount from the seller's account balance.
	 *
	 * @param amount   The amount to withdraw.
	 * @param username The username of the seller.
	 * @return {@code true} if the withdrawal was successful, {@code false}
	 *         otherwise.
	 */
	boolean amountWithrowBySeller(double amount, String unsername);

	/**
	 * Deletes a seller based on their username and password.
	 *
	 * @param username The username of the seller.
	 * @param password The password of the seller.
	 * @return {@code true} if the seller was successfully deleted, {@code false}
	 *         otherwise.
	 */
	boolean deleteSeller(String username, String password);

	/**
	 * 
	 * Reopens the seller's account after it was closed.
	 * 
	 * @param username The username of the seller.
	 * @param password The password of the seller.
	 * @return {@code true} if the seller's account was successfully reopened,
	 *         {@code false} otherwise.
	 */
	boolean reopenSeller(String username, String password);

	/**
	 * 
	 * Adds a new pending amount to be paid to the seller.
	 * 
	 * @param username      The username of the seller.
	 * @param newPaidAmount The new pending amount to be paid.
	 * @return {@code true} if the pending amount was successfully added,
	 *         {@code false} otherwise.
	 */
	double getSellerPendingAmount(String username);

	/**
	 * Adds a new pending amount to be paid to the seller.
	 *
	 * @param username      The username of the seller.
	 * @param newPaidAmount The new pending amount to be paid.
	 * @return {@code true} if the pending amount was successfully added,
	 *         {@code false} otherwise.
	 */
	boolean addSellerPendingAmount(String username, double newPaidAmount);

	/**
	 * Retrieves the IDs of all products belonging to a seller.
	 *
	 * @param username The username of the seller.
	 * @return A list of product IDs.
	 */
	List<Integer> getSellerProductsID(String username);

	/**
	 * Retrieves all seller products ordered by price.
	 *
	 * @param username The username of the seller.
	 * @return A ResultSet containing the products.
	 */
	ResultSet getAllSellerProductsOrderByPrice(String username);

	/**
	 * Marks a pending amount as paid to the seller.
	 *
	 * @param pendingAmount The pending amount to be paid.
	 * @param username      The username of the seller.
	 * @param income        The income earned by the
	 * @return {@code true} if the pending amount was successfully marked as paid,
	 *         {@code false} otherwise.
	 */
	boolean sellerPaidPendingAmount(double pendingAamount, String username, double income);


}

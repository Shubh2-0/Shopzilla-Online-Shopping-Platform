package com.masai.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import com.masai.Exceptions.InvalidCredentialsException;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.Dto.*;

public class AdminDaoImpl implements AdminDao {

	static Connection con = null;

	/**
	 * Login as an admin.
	 *
	 * @param adminId  The admin ID.
	 * @param password The admin password.
	 * @return True if the login is successful, False otherwise.
	 * @throws InvalidCredentialsException If the admin ID or password is invalid.
	 */
	@Override
	public Boolean loginAdmin(String adminId, String password) {

		try {

			if (adminId.equals("admin") && password.equals("admin"))
				return true;

		} catch (Exception InvalidCredentialsException) {

			new InvalidCredentialsException("Invalid Id or Passowrd");
		}

		return false;

	}

	/**
	 * Retrieve all active buyers.
	 *
	 * @return A ResultSet containing information about all active buyers.
	 * @throws RecordNotFoundException If no active buyers are found.
	 */
	@Override
	public ResultSet getAllBuyer() throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT username UserName, first_name 'First Name', last_name 'Last Name', mobile_no 'Mobile Number', address Address FROM Buyer WHERE is_deleted != 1";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;
	}

	/**
	 * Retrieve all active sellers.
	 *
	 * @return A ResultSet containing information about all active sellers.
	 * @throws RecordNotFoundException If no active sellers are found.
	 */
	@Override
	public ResultSet getAllSeller() {

		ArrayList<Seller> list = new ArrayList<>();

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT username UserName, first_name 'First Name', last_name 'Last Name', mobile_no 'Mobile Number', address Address FROM SELLER where is_deleted != 1";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();
			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Retrieve all products.
	 *
	 * @return A ResultSet containing information about all products.
	 * @throws RecordNotFoundException If no products are found.
	 */
	@Override
	public ResultSet getAllProducts() throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE sold_status = 0 AND is_hide = 0";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			throw new RecordNotFoundException("Not record Found");

		}

	}

	/**
	 * Retrieve all sold products.
	 *
	 * @return A ResultSet containing information about all sold products.
	 * @throws RecordNotFoundException If no sold products are found.
	 */
	@Override
	public ResultSet getAllSoldProducts() throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE sold_status = 1 AND is_hide = 0";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;
	}

	/**
	 * Retrieve all products belonging to a specific category.
	 *
	 * @param categoryName The name of the category.
	 * @return A ResultSet containing information about all products in the
	 *         specified category.
	 * @throws RecordNotFoundException If no products are found in the specified
	 *                                 category.
	 */

	@Override
	public ResultSet getAllProductsByCategory(String CatName) throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE category_id = (SELECT cat_id FROM category WHERE cat_name = ?) AND sold_status = 0 AND  is_hide = 0";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			statement.setString(1, CatName);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;
	}

	/**
	 * Retrieve all products belonging to a specific seller's username.
	 *
	 * @param username The username of the seller.
	 * @return A ResultSet containing information about all products belonging to
	 *         the specified seller.
	 * @throws RecordNotFoundException If no products are found for the specified
	 *                                 seller.
	 */

	@Override
	public ResultSet getAllProductsBySellerUsername(String username) throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE seller_username = ? AND sold_status = 0 AND is_hide = 0";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			statement.setString(1, username);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;
	}

	/**
	 * Retrieve all products sorted in ascending order of price.
	 *
	 * @return A ResultSet containing information about all products sorted by price
	 *         in ascending order.
	 * @throws RecordNotFoundException If no products are found.
	 */
	@Override
	public ResultSet getAllProductsByInAccendingOrderByPrice() throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE sold_status = 0 AND is_hide = 0 ORDER BY price_per_piece ";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;
	}

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
	@Override
	public ResultSet getAllProductsByQuantity(int from, int to) throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_id AS ID, product_name AS Name, price_per_piece AS 'Price Per Unit', seller_username AS 'Seller Username', seller_name AS 'Seller Name', quantity AS Quantity, description AS Description, category_id AS 'Category ID' FROM product WHERE quantity BETWEEN ? AND ? AND is_hide = 0 ORDER BY quantity";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			statement.setInt(1, from);
			statement.setInt(2, to);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;
	}

	/**
	 * Retrieve all transactions.
	 *
	 * @return A ResultSet containing information about all transactions.
	 * @throws RecordNotFoundException If no transactions are found.
	 */

	@Override
	public ResultSet getAllTransaction() throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

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
	@Override
	public ResultSet getAllTransactionbyDateRange(LocalDate startDate, LocalDate endDate)
			throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE PURCHASE_DATE BETWEEN ? AND ? AND is_hide = 0 ORDER BY PURCHASE_DATE";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			Date s = Date.valueOf(startDate);
			Date e = Date.valueOf(endDate);

			statement.setDate(1, s);
			statement.setDate(2, e);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Retrieve a transaction by its ID.
	 *
	 * @param id The ID of the transaction.
	 * @return A ResultSet containing information about the transaction with the
	 *         specified ID.
	 * @throws RecordNotFoundException If no transaction is found with the specified
	 *                                 ID.
	 */
	@Override
	public ResultSet getTransactionById(int id) throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT transaction_id AS `Transa/ction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE transaction_id = ? AND is_hide = 0";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			statement.setInt(1, id);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;
	}

	/**
	 * Retrieve all transactions sorted by purchase date.
	 *
	 * @return A ResultSet containing information about all transactions sorted by
	 *         purchase date.
	 * @throws RecordNotFoundException If no transactions are found.
	 */
	@Override
	public ResultSet getAllTransactionByPurchaseDate() throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0 ORDER BY purchase_date";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Retrieve all transactions sorted by quantity.
	 *
	 * @return A ResultSet containing information about all transactions sorted by
	 *         quantity.
	 * @throws RecordNotFoundException If no transactions are found.
	 */
	@Override
	public ResultSet getAllTransactionByQuantity() throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0 ORDER BY quantity";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Retrieve all transactions sorted by GST percentage.
	 *
	 * @return A ResultSet containing information about all transactions sorted by
	 *         GST percentage.
	 * @throws RecordNotFoundException If no transactions are found.
	 */
	@Override
	public ResultSet getAllTransactionByGSTPercentage() throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0 ORDER BY gst_percentage";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Retrieve all transactions sorted by total price.
	 *
	 * @return A ResultSet containing information about all transactions sorted by
	 *         total price.
	 * @throws RecordNotFoundException If no transactions are found.
	 */
	@Override
	public ResultSet getAllTransactionByTotalPrice() throws RecordNotFoundException {

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT transaction_id AS `Transaction ID`, product_name AS `Product Name`, buyer_name AS `Buyer Name`, quantity Quantity, purchase_date AS `Purchase Date`, amount_per_piece AS `Amount Per Unit`, price 'Price Before Tax', gst_percentage AS `GST Percentage`, tax_amount AS `Tax Amount`, total_price AS `Total Price`, return_policy AS `Return Policy` FROM transactions WHERE is_hide = 0 ORDER BY total_price";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			ResultSet set = statement.executeQuery();

			return set;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

}

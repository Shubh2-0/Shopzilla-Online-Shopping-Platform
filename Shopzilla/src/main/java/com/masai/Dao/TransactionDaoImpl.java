package com.masai.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.Dto.ReturnProduct;

public class TransactionDaoImpl implements TransactionDao {

	static Connection con = null;

	/**
	 * Retrieves all transaction IDs associated with a particular buyer.
	 *
	 * @param buyerUsername The username of the buyer.
	 * @return A list of transaction IDs.
	 */
	@Override
	public List<Integer> getAllTransactionIdByParticularBuyer(String buyerUsername) {

		List<Integer> list = new ArrayList<>();

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT transaction_id FROM transactions WHERE buyer_id = ?";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			statement.setString(1, buyerUsername);

			ResultSet set = statement.executeQuery();

			if (set.isAfterLast() && set.getRow() == 0)
				return null;

			while (set.next()) {

				list.add(set.getInt(1));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;

	}

	/**
	 * Retrieves the product name, product ID, quantity, and date of a transaction
	 * by its ID and return status.
	 *
	 * @param id The ID of the transaction.
	 * @return A list containing the product name, product ID, quantity, and date.
	 */
	@Override
	public List<String> getProductNameAndProductIdAndQuantityAndDateByIdAndReturn(int id) {

		List<String> list = new ArrayList<>();

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT product_name, product_id, quantity, purchase_date, return_policy FROM transactions WHERE transaction_id = ?";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);

			statement.setInt(1, id);

			ResultSet set = statement.executeQuery();

			if (set.isAfterLast() && set.getRow() == 0)
				return null;

			while (set.next()) {

				list.add(set.getString(1));
				list.add(set.getInt(2) + "");
				list.add(set.getInt(3) + "");
				list.add(set.getDate(4) + "");
				list.add(set.getInt(5) + "");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;

	}

	/**
	 * Processes the return of a product as a transaction.
	 *
	 * @param returnProduct The return product object.
	 * @return {@code true} if the return transaction was successfully processed,
	 *         {@code false} otherwise.
	 */
	@Override
	public boolean returnProductTransaction(ReturnProduct returnProduct) {

		try {

			con = DBUtils.getConnection();
			String INSERT_QUERY = "INSERT INTO returnproduct(product_id, product_name, reason_for_return, return_date, buyer_id, buyer_name, quantity, return_type, transaction_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);

			statement.setInt(1, returnProduct.getProdunctId());
			statement.setString(2, returnProduct.getProductName());
			statement.setString(3, returnProduct.getReasonForRefund());
			statement.setDate(4, Date.valueOf(returnProduct.getRefundDate()));
			statement.setString(5, returnProduct.getBuyerId());
			statement.setString(6, returnProduct.getBuyerName());
			statement.setInt(7, returnProduct.getQuantity());
			statement.setString(8, returnProduct.getType());
			statement.setInt(9, returnProduct.getTransactionId());
			
			String UPDATE_QUERY  = "UPDATE transactions SET return_policy = 0 WHERE transaction_id = ?";
			
			PreparedStatement statement2 = con.prepareStatement(UPDATE_QUERY);
			
			statement2.setInt(1, returnProduct.getTransactionId());
			
			
		
			if (statement.executeUpdate() > 0 && statement2.executeUpdate() > 0)
				return true;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return false;

	}

	/**
	 * Retrieves the return type for a given transaction ID.
	 *
	 * @param transactionId The transaction ID to check for return status.
	 * @return The return type ("YES" or "NO") for the specified transaction ID.
	 */
	@Override
	public String alreadyReturnOrNot(int transactionId) {

		String ans = "NO";

		try {

			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT return_type FROM returnproduct WHERE transaction_id = ?";

			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			statement.setInt(1, transactionId);

			ResultSet set = statement.executeQuery();

		
			
			if (set.isAfterLast() && set.getRow() == 0)
				return "NO";

			while (set.next()) {

				return set.getString(1);
			}
			
			System.out.println(ans);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return ans;

	}

}

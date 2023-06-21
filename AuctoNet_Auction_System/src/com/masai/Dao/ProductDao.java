package com.masai.Dao;

import com.masai.Dto.Product;
import com.masai.Dto.ReturnProduct;

public interface ProductDao {

	/**
	 * Updates the quantity of a product based on its product ID.
	 *
	 * @param productId The ID of the product.
	 * @param quantity  The new quantity of the product.
	 * @return {@code true} if the quantity was successfully updated, {@code false}
	 *         otherwise.
	 */
	boolean updateQuantity(int productId, int quantity);

	/**
	 * Retrieves the GST percentage of a product based on its product ID.
	 *
	 * @param productId The ID of the product.
	 * @return The GST percentage of the product.
	 */
	int getGStPercentage(int productId);

	/**
	 * Retrieves a product based on its product ID.
	 *
	 * @param productId The ID of the product.
	 * @return The product object.
	 */
	Product getProductById(int productId);

	/**
	 * Updates a product by a seller.
	 *
	 * @param product The updated product object.
	 * @param id      The ID of the product to update.
	 * @return {@code true} if the product was successfully updated, {@code false}
	 *         otherwise.
	 */
	boolean updateProductBySeller(Product product, int id);

	/**
	 * Adds a new product by a seller.
	 *
	 * @param product The product object to add.
	 * @return {@code true} if the product was successfully added, {@code false}
	 *         otherwise.
	 */
	boolean addProductBySeller(Product product);

	/**
	 * Retrieves the product ID based on the category name.
	 *
	 * @param categoryName The name of the category.
	 * @return The product ID associated with the category.
	 */
	int getProductIdByCategoryName(String catgoryName);

	/**
	 * Processes the return of a product.
	 *
	 * @param returnProduct The return product object.
	 * @return {@code true} if the return was successfully processed, {@code false}
	 *         otherwise.
	 */
	boolean returnProduct(ReturnProduct returnProduct);

	

}

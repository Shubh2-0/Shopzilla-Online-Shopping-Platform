package com.masai.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {

	private int productId;
	private String productName;
	private double productPrice;
	private String sellerId;
	private String sellerName;
	private int productQuantity;
	private String productDescription;
	private int productSoldStatus = 0;
	private int productCategoryId;
	private int returnPolicy;

	public Product(int productId, String productName, double productPrice, String sellerId, String sellerName,
			int productQuantity, String productDescription, int productSoldStatus, int productCategoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.productQuantity = productQuantity;
		this.productDescription = productDescription;
		this.productSoldStatus = productSoldStatus;
		this.productCategoryId = productCategoryId;
	}

}

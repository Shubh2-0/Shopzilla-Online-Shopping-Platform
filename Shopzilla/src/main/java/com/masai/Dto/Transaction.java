package com.masai.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaction {

	private int tansactionId;
	private int productId;
	private String productName;
	private String buyerId;
	private String buyerName;
	private int quantity;
	private LocalDate purchaseDate;
	private BigDecimal amountPerPiece;
	private BigDecimal price;
	private int gstPercentage;
	private BigDecimal taxAmount;
	private BigDecimal totalPrice;
	private int returnPolicy = 1;

	public Transaction(int tansactionId, int productId, String productName, String buyerId, String buyerName,
			int quantity, LocalDate purchaseDate, BigDecimal amountPerPiece, BigDecimal price, int gstPercentage,
			BigDecimal taxAmount, BigDecimal totalPrice, int returnPolicy) {
		super();
		this.tansactionId = tansactionId;
		this.productId = productId;
		this.productName = productName;
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.amountPerPiece = amountPerPiece;
		this.price = price;
		this.gstPercentage = gstPercentage;
		this.taxAmount = taxAmount;
		this.totalPrice = totalPrice;
		this.returnPolicy = returnPolicy;
	}

}

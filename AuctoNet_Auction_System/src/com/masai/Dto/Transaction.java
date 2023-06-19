package com.masai.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction{
	
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
	
	
	
	public Transaction() {
		
	}
	
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

	public int getTansactionId() {
		return tansactionId;
	}

	public void setTansactionId(int tansactionId) {
		this.tansactionId = tansactionId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigDecimal getAmountPerPiece() {
		return amountPerPiece;
	}

	public void setAmountPerPiece(BigDecimal amountPerPiece) {
		this.amountPerPiece = amountPerPiece;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(int gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getReturnPolicy() {
		return returnPolicy;
	}

	public void setReturnPolicy(int returnPolicy) {
		this.returnPolicy = returnPolicy;
	}


	 
	
	
	
	
	
	

}

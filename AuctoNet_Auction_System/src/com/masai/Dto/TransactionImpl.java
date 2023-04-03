package com.masai.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionImpl implements Transaction{
	
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
	
	
	
	public TransactionImpl() {
		
	}
	
	public TransactionImpl(int tansactionId, int productId, String productName, String buyerId, String buyerName,
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


	
	@Override
	public int getTansactionId() {
		return tansactionId;
	}

	
	@Override
	public void setTansactionId(int tansactionId) {
		this.tansactionId = tansactionId;
	}

	
	@Override
	public int getProductId() {
		return productId;
	}

	
	@Override
	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	@Override
	public String getProductName() {
		return productName;
	}

	
	@Override
	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	@Override
	public String getBuyerId() {
		return buyerId;
	}

	
	@Override
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	
	@Override
	public String getBuyerName() {
		return buyerName;
	}

	
	@Override
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	
	@Override
	public int getQuantity() {
		return quantity;
	}

	
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	@Override
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	
	@Override
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	
	@Override
	public BigDecimal getAmountPerPiece() {
		return amountPerPiece;
	}

	
	@Override
	public void setAmountPerPiece(BigDecimal amountPerPiece) {
		this.amountPerPiece = amountPerPiece;
	}

	
	@Override
	public BigDecimal getPrice() {
		return price;
	}

	
	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
	@Override
	public int getGstPercentage() {
		return gstPercentage;
	}

	
	@Override
	public void setGstPercentage(int gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	
	@Override
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	
	@Override
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	
	
	@Override
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	
	
	@Override
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
	@Override
	public int getReturnPolicy() {
		return returnPolicy;
	}

	
	
	@Override
	public void setReturnPolicy(int returnPolicy) {
		this.returnPolicy = returnPolicy;
	}

	@Override
	public String toString() {
		return "TransactionImpl [tansactionId=" + tansactionId + ", productId=" + productId + ", productName="
				+ productName + ", buyerId=" + buyerId + ", buyerName=" + buyerName + ", quantity=" + quantity
				+ ", purchaseDate=" + purchaseDate + ", amountPerPiece=" + amountPerPiece + ", price=" + price
				+ ", gstPercentage=" + gstPercentage + ", taxAmount=" + taxAmount + ", totalPrice=" + totalPrice
				+ ", returnPolicy=" + returnPolicy + "]";
	}

	
	
	
	
	

}

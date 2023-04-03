package com.masai.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Transaction {
	
	public int getTansactionId();	
	public void setTansactionId(int tansactionId);

	public int getProductId();
	public void setProductId(int productId);

	public String getProductName();
	public void setProductName(String productName);
	
	public String getBuyerId();	
	public void setBuyerId(String buyerId);
	
	public String getBuyerName();	
	public void setBuyerName(String buyerName);

	public int getQuantity();
	public void setQuantity(int quantity);

	public LocalDate getPurchaseDate();
	public void setPurchaseDate(LocalDate purchaseDate);
	
	public BigDecimal getAmountPerPiece();
	public void setAmountPerPiece(BigDecimal amountPerPiece);

	public BigDecimal getPrice();
	public void setPrice(BigDecimal price);

	public int getGstPercentage();
	public void setGstPercentage(int gstPercentage);

	public BigDecimal getTaxAmount();
	public void setTaxAmount(BigDecimal taxAmount);

	public BigDecimal getTotalPrice();
	public void setTotalPrice(BigDecimal totalPrice);

	public int getReturnPolicy();
	public void setReturnPolicy(int returnPolicy);


}

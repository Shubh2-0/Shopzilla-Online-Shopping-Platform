package com.masai.Dto;

import java.math.BigDecimal;

public interface Product {
	
	public int getProductId();
	public void setProductId(int productId);

	public String getProductName();
	public void setProductName(String productName);

	public BigDecimal getProductPrice();
	public void setProductPrice(BigDecimal productPrice);
	
	public String getSellerId();	
	public void setSellerId(String sellerId);

	public String getSellerName();
	public void setSellerName(String sellerName);

	public int getProductQuantity();
	public void setProductQuantity(int productQuantity);

	public String getProductDescription();
	public void setProductDescription(String productDescription);

	public int getProductSoldStatus();
	public void setProductSoldStatus(int productSoldStatus);

	public int getProductCategoryId();
	public void setProductCategoryId(int productCategoryId);
	
}

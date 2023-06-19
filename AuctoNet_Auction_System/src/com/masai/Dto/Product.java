package com.masai.Dto;



public class Product{
	
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
	
	public Product() {
		
	}
	
	

   
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




	public double getProductPrice() {
		return productPrice;
	}




	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}




	public String getSellerId() {
		return sellerId;
	}




	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}




	public String getSellerName() {
		return sellerName;
	}




	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}




	public int getProductQuantity() {
		return productQuantity;
	}




	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}




	public String getProductDescription() {
		return productDescription;
	}




	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}




	public int getProductSoldStatus() {
		return productSoldStatus;
	}




	public void setProductSoldStatus(int productSoldStatus) {
		this.productSoldStatus = productSoldStatus;
	}




	public int getProductCategoryId() {
		return productCategoryId;
	}




	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}




	public int getReturnPolicy() {
		return returnPolicy;
	}




	public void setReturnPolicy(int returnPolicy) {
		this.returnPolicy = returnPolicy;
	}

   
	
	
	
	
	
	

}

package com.masai.Dto;



public class ProductImpl implements Product{
	
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
	
	public ProductImpl() {
		
	}
	
	

   
	public ProductImpl(int productId, String productName, double productPrice, String sellerId, String sellerName,
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


    @Override
	public int getReturnPolicy() {
		return returnPolicy;
	}



    @Override
	public void setReturnPolicy(int returnPolicy) {
		this.returnPolicy = returnPolicy;
	}




	@Override
	public String getSellerId() {
		return sellerId;
	}


	@Override
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}


	@Override
	public String getSellerName() {
		return sellerName;
	}


	@Override
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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
	public double getProductPrice() {
		return productPrice;
	}

	@Override
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public int getProductQuantity() {
		return productQuantity;
	}

	@Override
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String getProductDescription() {
		return productDescription;
	}

	@Override
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public int getProductSoldStatus() {
		return productSoldStatus;
	}

	@Override
	public void setProductSoldStatus(int productSoldStatus) {
		this.productSoldStatus = productSoldStatus;
	}

	@Override
	public int getProductCategoryId() {
		return productCategoryId;
	}

	@Override
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	@Override
	public String toString() {
		return "ProductId : " + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", productDescription=" + productDescription
				+ ", productSoldStatus=" + productSoldStatus + ", productCategoryId=" + productCategoryId + "]";
	}
	
	
	
	
	

}

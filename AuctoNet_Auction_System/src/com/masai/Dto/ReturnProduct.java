package com.masai.Dto;

import java.time.LocalDate;

public class ReturnProduct{
	
	private int refundId;
	private int produnctId;
	private String productName;
	private String reasonForRefund;
	private LocalDate refundDate;
	private String buyerId;
	private String buyerName;
	private String type;
	private int quantity;
	
	
	
	public ReturnProduct() {
	}




	public ReturnProduct(int refundId, int produnctId, String productName, String reasonForRefund,
			LocalDate refundDate, String buyerId, String buyerName) {
		super();
		this.refundId = refundId;
		this.produnctId = produnctId;
		this.productName = productName;
		this.reasonForRefund = reasonForRefund;
		this.refundDate = refundDate;
		this.buyerId = buyerId;
		this.buyerName = buyerName;
	}



	

	public int getRefundId() {
		return refundId;
	}




	public void setRefundId(int refundId) {
		this.refundId = refundId;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public int getProdunctId() {
		return produnctId;
	}




	public void setProdunctId(int produnctId) {
		this.produnctId = produnctId;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public String getReasonForRefund() {
		return reasonForRefund;
	}




	public void setReasonForRefund(String reasonForRefund) {
		this.reasonForRefund = reasonForRefund;
	}




	public LocalDate getRefundDate() {
		return refundDate;
	}




	public void setRefundDate(LocalDate refundDate) {
		this.refundDate = refundDate;
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




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}








	
	
	
	
	
	

}

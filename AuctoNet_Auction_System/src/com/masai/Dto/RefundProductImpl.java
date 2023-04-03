package com.masai.Dto;

import java.time.LocalDate;

public class RefundProductImpl implements RefundProduct {
	
	private int refundId;
	private int produnctId;
	private String productName;
	private String reasonForRefund;
	private LocalDate refundDate;
	private String buyerId;
	private String buyerName;
	
	
	
	public RefundProductImpl() {
	}




	public RefundProductImpl(int refundId, int produnctId, String productName, String reasonForRefund,
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







	@Override
	public int getRefundId() {
		return refundId;
	}


	@Override
	public void setRefundId(int refundId) {
		this.refundId = refundId;
	}


	@Override
	public int getProdunctId() {
		return produnctId;
	}


	@Override
	public void setProdunctId(int produnctId) {
		this.produnctId = produnctId;
	}


	@Override
	public String getReasonForRefund() {
		return reasonForRefund;
	}


	@Override
	public void setReasonForRefund(String reasonForRefund) {
		this.reasonForRefund = reasonForRefund;
	}


	@Override
	public LocalDate getRefundDate() {
		return refundDate;
	}


	@Override
	public void setRefundDate(LocalDate refundDate) {
		this.refundDate = refundDate;
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
	public String getProductName() {
		return productName;
	}



	@Override
	public void setProductName(String productName) {
		this.productName = productName;
	}



	@Override
	public String toString() {
		return "RefundProductImpl [refundId=" + refundId + ", produnctId=" + produnctId + ", reasonForRefund="
				+ reasonForRefund + ", refundDate=" + refundDate + ", buyerId=" + buyerId + ", buyerName=" + buyerName
				+ ", productName=" + productName + "]";
	}
	
	
	
	
	
	
	
	

}

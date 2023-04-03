package com.masai.Dto;

import java.time.LocalDate;

public interface RefundProduct {
	
	int getRefundId();	
	void setRefundId(int refundId);


	int getProdunctId();
	void setProdunctId(int produnctId);


	String getReasonForRefund();
	void setReasonForRefund(String reasonForRefund);


	LocalDate getRefundDate();
	void setRefundDate(LocalDate refundDate);


	String getBuyerId();
	void setBuyerId(String buyerId);


	String getBuyerName();
	void setBuyerName(String buyerName);



	String getProductName();
	void setProductName(String productName);


}

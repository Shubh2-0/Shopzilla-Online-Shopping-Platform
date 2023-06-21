package com.masai.Dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnProduct {

	private int retundId;
	private int produnctId;
	private String productName;
	private String reasonForRefund;
	private LocalDate refundDate;
	private String buyerId;
	private String buyerName;
	private String type;
	private int quantity;
	private int transactionId;
	
	public ReturnProduct(int retundId, int produnctId, String productName, String reasonForRefund, LocalDate refundDate,
			String buyerId, String buyerName, String type, int quantity, int transactionId) {
		super();
		this.retundId = retundId;
		this.produnctId = produnctId;
		this.productName = productName;
		this.reasonForRefund = reasonForRefund;
		this.refundDate = refundDate;
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.type = type;
		this.quantity = quantity;
		this.transactionId = transactionId;
	}

	
}

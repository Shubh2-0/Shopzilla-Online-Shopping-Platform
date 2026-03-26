package com.masai.Dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnProduct {

	private int returnId;
	private int productId;
	private String productName;
	private String reasonForRefund;
	private LocalDate refundDate;
	private String buyerId;
	private String buyerName;
	private String type;
	private int quantity;
	private int transactionId;
	
	public ReturnProduct(int returnId, int productId, String productName, String reasonForRefund, LocalDate refundDate,
			String buyerId, String buyerName, String type, int quantity, int transactionId) {
		super();
		this.returnId = returnId;
		this.productId = productId;
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

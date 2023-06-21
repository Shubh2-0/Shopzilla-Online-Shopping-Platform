package com.masai.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Seller {

	private String SellerUserName = "";
	private String password = "";
	private String firstName = "";
	private String lastName = "";
	private String mobileNo = "";
	private String address = "";
	private double income = 0.0;
	private double pendingAmount;

	public Seller(String BuyerUserName, String password) {
		this.SellerUserName = BuyerUserName;
		this.firstName = "";
		this.lastName = "";
		this.mobileNo = "";
		this.password = password;
		this.address = "";
	}

	public Seller(String buyerUserName, String password, String firstName, String lastName, String mobileNo,
			String address, double balance) {

		SellerUserName = buyerUserName;
		this.password = password;

		if (firstName == null)
			this.firstName = "";
		else
			this.firstName = firstName;

		if (lastName == null)
			this.lastName = "";
		else
			this.lastName = lastName;

		if (mobileNo == null)
			this.mobileNo = "";
		else
			this.mobileNo = mobileNo;

		if (address == null)
			this.address = "";
		else
			this.address = address;

		if (balance < 0.0)
			this.income = 0.0;
		else
			this.income = balance;

	}

}

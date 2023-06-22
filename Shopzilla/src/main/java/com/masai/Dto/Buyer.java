package com.masai.Dto;

import com.masai.CommanCode.Common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Buyer {

	private String BuyerUserName = "";
	private String password = "";
	private String firstName = "";
	private String lastName = "";
	private String mobileNo = "";
	private String address = "";
	private double balance = 0.0;

	public Buyer(String BuyerUserName, String password) {
		this.BuyerUserName = BuyerUserName;
		this.firstName = "";
		this.lastName = "";
		this.mobileNo = "";
		this.password = password;
		this.address = "";
	}

	public Buyer(String buyerUserName, String password, String firstName, String lastName, String mobileNo,
			String address, double balance) {

		BuyerUserName = buyerUserName;
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
			this.balance = 0.0;
		else {
			this.balance = 	Common.getUptoTwoDecimal(balance);
		}
			

	}

}

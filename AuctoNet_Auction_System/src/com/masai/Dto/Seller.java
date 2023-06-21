package com.masai.Dto;

public class Seller {

	private String SellerUserName = "";
	private String password = "";
	private String firstName = "";
	private String lastName = "";
	private String mobileNo = "";
	private String address = "";
	private double income = 0.0;
	private double pendingAmount;

	public Seller() {
		super();
	}

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

	public String getSellerUserName() {
		return SellerUserName;
	}

	public void setSellerUserName(String sellerUserName) {
		SellerUserName = sellerUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

}

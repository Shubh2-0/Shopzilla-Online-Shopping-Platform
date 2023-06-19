package com.masai.Dto;

public class Buyer{
	
	private String BuyerUserName = "";
	private String password = "";
	private String firstName = "";
	private String lastName = "";
	private String mobileNo = "";
	private String address = "";
	private double balance = 0.0;
	
	public Buyer() {
		super();
	}

	public Buyer(String BuyerUserName,String password) {
		this.BuyerUserName = BuyerUserName;
		this.firstName = "";
		this.lastName = "";
		this.mobileNo = "";
		this.password = password;
		this.address = "";
	}
	
	
   
	
	public Buyer(String buyerUserName, String password, String firstName, String lastName, String mobileNo,
			String address,double balance ) {
		
		BuyerUserName = buyerUserName;
		this.password = password;
		
		if(firstName==null)
			this.firstName="";
		else
			this.firstName=firstName;
		
		if(lastName==null)
			this.lastName="";
		else
			this.lastName=lastName;
		
		if(mobileNo==null)
			this.mobileNo="";
		else
			this.mobileNo=mobileNo;
		
		if(address==null)
			this.address="";
		else
			this.address=address;
		
		if(balance<0.0)
			this.balance=0.0;
		else
			this.balance=balance;
		
		
		
	}

	public String getBuyerUserName() {
		return BuyerUserName;
	}

	public void setBuyerUserName(String buyerUserName) {
		BuyerUserName = buyerUserName;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	
	
	

}

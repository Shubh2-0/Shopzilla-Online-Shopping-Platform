package com.masai.Dto;

public class BuyerImpl implements Buyer {
	
	private String BuyerUserName = "";
	private String password = "";
	private String firstName = "";
	private String lastName = "";
	private String mobileNo = "";
	private String address = "";
	private double balance = 0.0;
	
	public BuyerImpl() {
		super();
	}

	public BuyerImpl(String BuyerUserName,String password) {
		this.BuyerUserName = BuyerUserName;
		this.firstName = "";
		this.lastName = "";
		this.mobileNo = "";
		this.password = password;
		this.address = "";
	}
	
	
   
	
	public BuyerImpl(String buyerUserName, String password, String firstName, String lastName, String mobileNo,
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

	@Override
	public String getBuyerUserName() {
		return BuyerUserName;
	}

	@Override
	public void setBuyerUserName(String buyerUserName) {
		BuyerUserName = buyerUserName;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	@Override
	public String getLastName() {
		return lastName;
	}

	
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@Override
	public String getMobileNo() {
		return mobileNo;
	}

	
	@Override
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	@Override
	public String getPassword() {
		return password;
	}

	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	@Override
	public String getAddress() {
		return address;
	}

	
	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	
	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

	
	
	
	

}

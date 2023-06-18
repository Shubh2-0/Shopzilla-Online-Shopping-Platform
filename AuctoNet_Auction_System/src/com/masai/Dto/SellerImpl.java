package com.masai.Dto;

public class SellerImpl implements Seller{
	

	private String SellerUserName = "";
	private String password = "";
	private String firstName = "";
	private String lastName = "";
	private String mobileNo = "";
	private String address = "";
	private double income = 0.0;
	private double pendingAmount;
	
	public SellerImpl() {
		super();
	}

	public SellerImpl(String BuyerUserName,String password) {
		this.SellerUserName = BuyerUserName;
		this.firstName = "";
		this.lastName = "";
		this.mobileNo = "";
		this.password = password;
		this.address = "";
	}
	
	
   
	
	public SellerImpl(String buyerUserName, String password, String firstName, String lastName, String mobileNo,
			String address,double balance ) {
		
		SellerUserName = buyerUserName;
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
			this.income=0.0;
		else
			this.income=balance;
		
		
		
	}

    @Override
	public double getPendingAmount() {
		return pendingAmount;
	}

    
    @Override
	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
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
	public String getSellerUserName() {
		return SellerUserName;
	}

	@Override
	public void setSellerUserName(String sellerUserName) {
		SellerUserName = sellerUserName;
	}

	@Override
	public double getIncome() {
		return income;
	}

	@Override
	public void setIncome(double income) {
		this.income = income;
	}

	

	


}

package com.masai.Dto;

public interface Seller {


	public String getFirstName();
	public void setFirstName(String firstName);

	public String getLastName();
	public void setLastName(String lastName);

	public String getMobileNo();
	public void setMobileNo(String mobileNo);

	public String getPassword();
	public void setPassword(String password);
	
	public String getAddress();
	public void setAddress(String address);
	
	String getSellerUserName();
	void setSellerUserName(String sellerUserName);
	

	double getIncome();
	void setIncome(double income);
}

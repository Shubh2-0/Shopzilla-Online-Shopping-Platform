package com.masai.Dto;

public class SellerImpl implements Seller{
	

	private String sellerUsername;
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String address;
	
	public SellerImpl() {
	}

	public SellerImpl(String sellerId,String password) {
		this.sellerUsername = sellerId;
		this.firstName = null;
		this.lastName = null;
		this.mobileNo = null;
		this.password = password;
		this.address = null;
	}
	

	public SellerImpl(String sellerUsername, String password, String firstName, String lastName, String mobileNo,
			String address) {
		this.sellerUsername = sellerUsername;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	@Override
	public String getSellerUsername() {
		return sellerUsername;
	}

	@Override
	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
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
	public String toString() {
		return "SellerImpl [sellerId=" + sellerUsername + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNo=" + mobileNo + ", password=" + password + ", address=" + address + "]";
	}
	



}

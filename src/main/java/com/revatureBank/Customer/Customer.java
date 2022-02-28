package com.revatureBank.Customer;

public class Customer {
	private int customerId;
	private String customerName;
	private String customerEmail;
	private long customerPhone;
	private String password;
	private String customerAddress;
	private int customerBalance;
	private String customerAadharNo;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(long phone) {
		this.customerPhone = phone;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getCustomerBalance() {
		return customerBalance;
	}
	public void setCustomerBalance(int customerBalance) {
		this.customerBalance = customerBalance;
	}
	
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCustomerAadharNo() {
		return customerAadharNo;
	}
	public void setCustomerAadharNo(String customerAadharNo) {
		this.customerAadharNo = customerAadharNo;
	}
	
@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ",  customerEmail=" + customerEmail + ",customerPhone="
				+ customerPhone + ", password=" + password + ", customerAddress=" + customerAddress + ", customerBalance=" + customerBalance + " customerAadhar=" + customerAadharNo + ",]";
	}
}

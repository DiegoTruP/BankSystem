package com.java.training.bank;

import java.util.HashMap;

public class Customer {
	int customerNum;
	String customerName;
	HashMap<Integer,Account> custAccount = new HashMap<Integer,Account>();
	
	
	public Customer() {
		super();
	}


	public Customer(int customerNum, String customerName) {
		super();
		this.customerNum = customerNum;
		this.customerName = customerName;
	}
	
	
	public int getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public HashMap<Integer, Account> getCustAccount() {
		return custAccount;
	}
	public void setCustAccount(HashMap<Integer, Account> custAccount) {
		this.custAccount = custAccount;
	}
	
	
}

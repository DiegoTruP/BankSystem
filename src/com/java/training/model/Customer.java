package com.java.training.model;

import java.util.HashMap;

public class Customer {
	private int customerId;
	private String customerName;
	private String mobileNum;
	private String email;
	private HashMap<Integer,Account> custAccounts = new HashMap<Integer,Account>();
	private HashMap<Integer, Transaction> transactions = new HashMap<Integer,Transaction>();
	
	
	public Customer() {
		super();
	}


	public Customer(int customerNum, String customerName) {
		super();
		this.customerId = customerNum;
		this.customerName = customerName;
	}
	
	
	
	public Customer(int customerId, String customerName, String mobileNum, String email) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNum = mobileNum;
		this.email = email;
	}

	
	
	
	

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerNum) {
		this.customerId = customerNum;
	}
	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public HashMap<Integer, Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(HashMap<Integer, Transaction> transactions) {
		this.transactions = transactions;
	}


	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public HashMap<Integer, Account> getCustAccounts() {
		return custAccounts;
	}
	public void setCustAccounts(HashMap<Integer, Account> custAccount) {
		this.custAccounts = custAccount;
	}
	
	
}

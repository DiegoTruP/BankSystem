package com.java.training.model;

import java.util.HashMap;

public class Account {
	private int customerId;
	private int accountNum;
	private double balance;
	private String type;
	
	
	


	public Account(){
	}
	
	
	public Account(int customerId, int accountNum, double balance, String type) {
		super();
		this.customerId = customerId;
		this.accountNum = accountNum;
		this.balance = balance;
		this.type=type;
	}


	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
}

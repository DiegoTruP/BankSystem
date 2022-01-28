package com.java.training.model;

import java.util.Date;

public class Transaction {
	private int customerId;
	private int accountNum;
	private Date date;
	private double amount;
	private String type;
	private int transactionNum;
	
	
	public Transaction(int customerId, int accountNum, double amount, String type,int transactionNum) {
		super();
		this.customerId = customerId;
		this.accountNum = accountNum;
		this.amount = amount;
		this.type = type;
		this.transactionNum = transactionNum;
	}
	
	
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}

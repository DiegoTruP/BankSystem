package com.java.training.bank;

import java.util.Date;

public class Transaction {
	int accountNum;
	Date date;
	double amount;
	String type;
	int transactionNum;
	
	
	public Transaction(int accountNum, double amount, String type,int transactionNum) {
		super();
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

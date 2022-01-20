package com.java.training.bank;

import java.util.HashMap;

public class Account {
	private int ownerNum;
	private int accountNum;
	private double balance;
	private String type;
	HashMap<Integer, Transaction> transactions = new HashMap<Integer,Transaction>();
	
	


	public Account(){
	}
	
	
	public Account(int ownerNum, int accountNum, int balance, String type) {
		super();
		this.ownerNum = ownerNum;
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
	
	
}

package com.java.training.model;

public class SavingAccount extends Account {
	private int NoTransaction;
	private int interest;
	
	
	
	public SavingAccount(int ownerNum, int accountNum, int balance, String type, int noTransaction, int interest) {
		super(ownerNum, accountNum, balance, type);
		NoTransaction = noTransaction;
		this.interest = interest;
	}
	public int getNoTransaction() {
		return NoTransaction;
	}
	public void setNoTransaction(int noTransaction) {
		NoTransaction = noTransaction;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
}

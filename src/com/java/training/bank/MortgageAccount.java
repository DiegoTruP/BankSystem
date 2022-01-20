package com.java.training.bank;

public class MortgageAccount extends Account {
	int interest;
	
	
	public MortgageAccount(int ownerNum, int accountNum, int balance, String type,int interest) {
		super(ownerNum, accountNum, balance, type);
		this.interest = interest;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}
	
}

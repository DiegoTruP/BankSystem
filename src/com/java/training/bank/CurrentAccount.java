package com.java.training.bank;

public class CurrentAccount extends Account {
	int noTransaction;
	
	
	public CurrentAccount(int ownerNum, int accountNum, int balance, String type, int noTransaction) {
		super(ownerNum, accountNum, balance,type);
		this.noTransaction = noTransaction;
	}

	
	public int getNoTransaction() {
		return noTransaction;
	}

	public void setNoTransaction(int noTransaction) {
		this.noTransaction = noTransaction;
	}
	
}

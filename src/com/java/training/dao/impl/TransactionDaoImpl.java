package com.java.training.dao.impl;

import java.util.List;

import com.java.training.dao.TransactionDao;
import com.java.training.model.Transaction;

public class TransactionDaoImpl implements TransactionDao{
	
	public List<Transaction> listTransactions;

	public TransactionDaoImpl(List<Transaction> listTransactions) {
		super();
		this.listTransactions = listTransactions;
	}
	
	

	public TransactionDaoImpl() {
		super();
	}



	@Override
	public void debitTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creditTransaction() {
		// TODO Auto-generated method stub
		
	}

	
	
}

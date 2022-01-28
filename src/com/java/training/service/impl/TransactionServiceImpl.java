package com.java.training.service.impl;

import java.util.Scanner;

import com.java.training.dao.impl.AccountDaoImpl;
import com.java.training.dao.impl.CustomerDaoImpl;
import com.java.training.dao.impl.TransactionDaoImpl;
import com.java.training.model.Transaction;
import com.java.training.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
	
	private CustomerDaoImpl customer;
	private AccountDaoImpl account;
	private TransactionDaoImpl transaction;
	Scanner scan = new Scanner(System.in);

	public TransactionServiceImpl(CustomerDaoImpl customer, AccountDaoImpl account,TransactionDaoImpl transaction) {
		super();
		this.customer = customer;
		this.account = account;
		this.transaction=transaction;
	}

	@Override
	public void makeTransaction() {
		System.out.println("Sender: ");
		int senderAcc = customer.getAccount();
		System.out.println("Receiver: ");
		int receiverAcc = customer.getAccount();
		System.out.println("Amount: ");
		double amount = scan.nextDouble();
		account.deposit(receiverAcc,amount);
		account.withdraw(senderAcc,amount);
		int customerId = account.getAccount(receiverAcc).getCustomerId();
		int transactionNum = transaction.listTransactions.size()+1;
		transaction.listTransactions.add(new Transaction(customerId, receiverAcc, amount, "Deposit", transactionNum));
	}

}

package com.java.training.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.training.model.Account;
import com.java.training.dao.AccountDao;

public class AccountDaoImpl implements AccountDao{

	Map<Integer, Account> listAccounts;
	Scanner scan = new Scanner(System.in);
	
	public AccountDaoImpl(Map<Integer, Account> listAccounts) {
		this.listAccounts=listAccounts;
	}
	
	@Override
	public Account addAccount(int customerId) {
		int accountNumber= listAccounts.size()+1;
		System.out.println("Enter the account type: ");
		String type = scan.next();
		Account account = new Account(customerId,accountNumber,0,type);
		listAccounts.put(accountNumber, account);//Create the account
		return account;
	}

	@Override
	public void deleteAccount(int accountNumber) {
		listAccounts.remove(accountNumber);
	}

	@Override
	public void updateAccount(int accountNumber) {
		System.out.println("Enter the customer name: ");
		String name = scan.next();
		System.out.println("Enter the account type: ");
		String email = scan.next();
		Account account = new Account();
		listAccounts.put(accountNumber, account);//Create the account
	}

	@Override
	public Account getAccount(int accountNumber) {
		
		return listAccounts.get(accountNumber);
	}

	@Override
	public void addAccount(String name) {
		int accountNumber= listAccounts.size()+1;
		System.out.println("Enter the account type: ");
		String email = scan.next();
		Account account = new Account();
		listAccounts.put(accountNumber, account);//Create the account
	}

	@Override
	public void showAccounts(int customerId) {
		for(Account account : listAccounts.values()) {
			if(account.getCustomerId()==customerId)
			System.out.println("  "+ account.getType() + " balance: " + account.getBalance());
		}
		
	}
	
	@Override
	public void deposit(int accountNumber,double amount) {
		Account account = listAccounts.get(accountNumber);
		amount = account.getBalance() + amount;
		account.setBalance(amount);
	}

	@Override
	public void withdraw(int accountNumber, double amount) {
		Account account = listAccounts.get(accountNumber);
		amount = account.getBalance() - amount;
		account.setBalance(amount);
	}

	@Override
	public void deposit(int accountNumber) {
		System.out.println("Enter the amount");
		double amount = scan.nextDouble();
		Account account = listAccounts.get(accountNumber);
		amount = account.getBalance() + amount;
		account.setBalance(amount);
	}

	@Override
	public void withdraw(int accountNumber) {
		System.out.println("Enter the amount");
		double amount = scan.nextDouble();
		Account account = listAccounts.get(accountNumber);
		amount = account.getBalance() - amount;
		account.setBalance(amount);
	}

}

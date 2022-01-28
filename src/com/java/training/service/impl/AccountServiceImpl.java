package com.java.training.service.impl;

import com.java.training.dao.impl.AccountDaoImpl;
import com.java.training.dao.impl.CustomerDaoImpl;
import com.java.training.model.Account;
import com.java.training.model.Customer;
import com.java.training.service.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private CustomerDaoImpl customer;
	private AccountDaoImpl account;
	
	public AccountServiceImpl(CustomerDaoImpl customer,AccountDaoImpl account) {
		this.customer = customer;
		this.account = account;
		
	}

	@Override
	public void checkBalance() {
		Customer myCustomer = customer.getCustomer();
		Account myAccount = account.getAccount(customer.getAccount());
		System.out.println("Name: " + myCustomer.getCustomerName());
		System.out.println("Balance: " + myAccount.getBalance());
	}

	@Override
	public void updateBalance() {
		// TODO Auto-generated method stub
		
	}


}

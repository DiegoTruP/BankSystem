package com.java.training.service.impl;


import com.java.training.dao.impl.AccountDaoImpl;
import com.java.training.dao.impl.CustomerDaoImpl;
import com.java.training.service.CustomerService;
import com.java.training.model.Account;
import com.java.training.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDaoImpl customer;
	private AccountDaoImpl account;
	//private Scanner scan = new Scanner(System.in);
	
	public CustomerServiceImpl(CustomerDaoImpl customerDao,AccountDaoImpl accountDao) {
		this.customer = customerDao;
		this.account = accountDao;
		
	}
	
	public CustomerServiceImpl() {
		
	}
	
	@Override
	public boolean login() {
		//Optional<Customer> customerResult = customer.listCustomers.entrySet().stream().findAny();
		return customer.findCustomer();
		}

	@Override
	public void createCustomerAccount() {
		int myCustomer = customer.addCustomer();
		Account myAccount = account.addAccount(myCustomer);
		customer.getCustomerById(myCustomer).getCustAccounts().put(myAccount.getAccountNum(),myAccount);
		
	}
	
	public void showCustomers() {
		for(Customer customer : customer.getListCustomers().values()) {
			System.out.println("\n"+customer.getCustomerName());
			System.out.println("Accounts: ");
			account.showAccounts(customer.getCustomerId());
		}
	}
	
	@Override
	public void makeDeposit() {
		account.deposit(customer.getAccount()); 
	}

	@Override
	public void makeWithdraw() {
		account.withdraw(customer.getAccount());
		
	}

	@Override
	public void checkBalance() {
		customer.showCustomer(customer.getCustomer());
		
	}
}

package com.java.training.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.training.dao.CustomerDao;
import com.java.training.model.Account;
import com.java.training.model.Customer;

public class CustomerDaoImpl implements CustomerDao{
	private Map<String, Customer> listCustomers;
	public Map<String, Customer> getListCustomers() {
		return listCustomers;
	}


	public void setListCustomers(Map<String, Customer> listCustomers) {
		this.listCustomers = listCustomers;
	}

	Scanner scan = new Scanner(System.in);
	
	public CustomerDaoImpl(Map<String, Customer> listCustomers) {
		this.listCustomers=listCustomers;
	}
	

	@Override
	public int addCustomer() {
		System.out.println("Enter the user name: ");
		String name = scan.next();
		Customer cust = listCustomers.get(name);
		if(cust==null) {//Check if the user doesn't exist
			System.out.println("Enter the telephone number: ");
			String mobileNum = scan.next();
			System.out.println("Enter the email: ");
			String email = scan.next();
			int customerId = (listCustomers.size()+1);
			Customer customer = new Customer(customerId,name,mobileNum,email);
			listCustomers.put(customer.getCustomerName(),customer);//Create the user 
			
			return customerId;
		}
		else {
			return cust.getCustomerId();
		}
	}

	@Override
	public String deleteCustomer() {
		System.out.println("Enter the user name: ");
		String customerName = scan.next();
		if(listCustomers.get(customerName)!=null) {//Check if the user exist
		listCustomers.remove(customerName);//Remove the user 
		return "User has been removed";
	}
	else {
		return "User has not been registered";
	}
	}

	@Override
	public String modifyCustomer() {
		System.out.println("Enter the new user name: ");
		String name = scan.next();
		if(listCustomers.get(name)!=null) {//Check if the user exist
			Customer customer = listCustomers.get(name);//Get the user 
			System.out.println(customer.toString());
			int customerId = customer.getCustomerId();
			System.out.println("Enter the telephone number: ");
			String mobileNum = scan.next();
			System.out.println("Enter the email: ");
			String email = scan.next();
			Customer updateCustomer = new Customer(customerId,name,mobileNum,email);
			listCustomers.put(name, updateCustomer);
			return "User has been updated";
		}
		else {
			return "User has not been registered";
		}
	}


	@Override
	public boolean findCustomer() {
		System.out.println("Enter the user name: ");
		String customerName = scan.next();
		Customer customer = listCustomers.get(customerName);
		return (customer == null ? false : true);
	}


	@Override
	public Customer getCustomer() {
		System.out.println("Enter the user name: ");
		String customerName = scan.next();
		return listCustomers.get(customerName);
	}
	
	public int getAccount() {
		int result = 0;
		Customer myCustomer = getCustomer();
		System.out.println("Your accounts: ");
		for(Account  acco : myCustomer.getCustAccounts().values()) {
			System.out.println(acco.getType());
		}
		System.out.println("Type account selected: ");
		String accountType = scan.next();
		for(Account  acco : myCustomer.getCustAccounts().values()) {
			if(acco.getType().equals(accountType)) {
				result = acco.getAccountNum();
			}
		}
		return result;
	}


	@Override
	public void showCustomers() {
		System.out.println("Accounts:");
		for(Customer customer : listCustomers.values()) {
			System.out.println("  "+ customer.getCustomerName());
		}
		
	}
	
	@Override
	public void showCustomer(Customer customer) {
		System.out.println("\n " + customer.getCustomerName());
		for(Account account : customer.getCustAccounts().values()) {
			System.out.print("  " + account.getType());
			System.out.println("  " + account.getBalance());
		}
	}


	@Override
	public void addAccount(int accNumber) {
		
	}


	@Override
	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		for(Customer cust : listCustomers.values()) {
			if(cust.getCustomerId() == id) {
				customer=cust;
			}
		}
		return customer;
	}
	
}

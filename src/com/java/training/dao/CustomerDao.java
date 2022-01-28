package com.java.training.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.java.training.model.Customer;

public interface CustomerDao {


	
	public int addCustomer(); 
	
	public void addAccount(int accNumber);
	
	public String deleteCustomer(); 
	
	public String modifyCustomer();
	
	public boolean findCustomer();
	
	public Customer getCustomer();
	
	public Customer getCustomerById(int id);
	
	public void showCustomers();
	
	public void showCustomer(Customer customer);
}

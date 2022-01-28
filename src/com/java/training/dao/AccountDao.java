package com.java.training.dao;



import com.java.training.model.Account;

public interface AccountDao{
	
	public Account getAccount(int accountNumber);
	
	public Account addAccount(int customerId);// {
	
	public void addAccount(String name);
	
	public void deleteAccount(int accountNumber);// {
	
	public void updateAccount(int accountNumber);// {

	public void showAccounts(int customerId);
	
	public void deposit(int accountNumber,double amount);
	
	public void deposit(int accountNumber);
	
	public void withdraw(int accountNumber, double amount);
	
	public void withdraw(int accountNumber);
	
}

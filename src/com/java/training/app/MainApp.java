package com.java.training.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.training.dao.AccountDao;
import com.java.training.dao.CustomerDao;
import com.java.training.dao.impl.AccountDaoImpl;
import com.java.training.dao.impl.CustomerDaoImpl;
import com.java.training.dao.impl.TransactionDaoImpl;
import com.java.training.model.Account;
import com.java.training.model.Customer;
import com.java.training.model.Transaction;
import com.java.training.service.AccountService;
import com.java.training.service.CustomerService;
import com.java.training.service.TransactionService;
import com.java.training.service.impl.AccountServiceImpl;
import com.java.training.service.impl.CustomerServiceImpl;
import com.java.training.service.impl.TransactionServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		Map<String, Customer> listCustomers = new HashMap<String,Customer>();
		Map<Integer, Account> listAccounts = new HashMap<Integer,Account>();
		List<Transaction> listTransactions = new ArrayList<Transaction>();
		CustomerDaoImpl customerDao = new CustomerDaoImpl(listCustomers);
		AccountDaoImpl accountDao = new AccountDaoImpl(listAccounts);
		TransactionDaoImpl transactionDao = new TransactionDaoImpl(listTransactions);
		
		CustomerService customerService = new CustomerServiceImpl(customerDao,accountDao);
		AccountService accountService = new AccountServiceImpl(customerDao,accountDao);
		TransactionService transactionService = new TransactionServiceImpl(customerDao, accountDao,transactionDao);
		
		Scanner scan = new Scanner(System.in);
		int menu;
		boolean session = false;
		
		
		boolean exit = false;
		
		while(exit==false) {
			
			if(session == false) {
				System.out.println("\nWrite the number of proccess and press enter.");
				System.out.println("1) login.");
				System.out.println("2) Register new customer.");
				System.out.println("3) Exit.");
				//System.out.println(") show customers.");
			}else if(session == true) {
				System.out.println("\nWrite the number of proccess and press enter.");
				System.out.println("1) Register new account.");
				System.out.println("2) Make a deposit.");
				System.out.println("3) Make a withdraw.");
				System.out.println("4) Make a transaction.");
				System.out.println("5) Check balance.");
				System.out.println("6) Exit");
			}
			
			
			menu=scan.nextInt();
			
			switch(menu) {
			
			case 1:
				if(session)
					customerService.createCustomerAccount();
				else
					session=customerService.login();
				break;
			
			case 2:		
				if(session)
					customerService.makeDeposit();
				else 
					customerService.createCustomerAccount();
				break;
				
			case 3:
				if(session)
					customerService.makeWithdraw();
				else
					exit=true;
				break;
				
			case 4:
				if(session)
					transactionService.makeTransaction();
				else 
					customerService.showCustomers();
				break;
				//showCustomerDetails(listCustomers,name);
				
				
			case 5:
				if(session)
					customerService.checkBalance();
				break;
				
				
			case 6:
				session=false;
				break; 
			
			default:
				break;
			}
		
		

		}

	}

}
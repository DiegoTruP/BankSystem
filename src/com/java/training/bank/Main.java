package com.java.training.bank;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean exit=false;
		int menu=0;
		String result;
		String name;
		String type;
		
		HashMap<String, Customer> listCustomers = new HashMap<String,Customer>();
		HashMap<Integer, Account> listAccounts= new HashMap<Integer,Account>();

		while(exit==false) {
			System.out.println("Write the number of proccess and press enter.");
			System.out.println("1) Register new customer.");
			System.out.println("2) Register new account.");
			System.out.println("3) Create new transaction.");
			System.out.println("4) Show customer details.");
			System.out.println("5) show customers.");
			
			menu=scan.nextInt();
			
			switch(menu) {
			
			case 1:
				System.out.println("Please enter the name of the customer.");
				name=scan.next();
				result = registerNewCustomer(listCustomers,name);
				System.out.println(result);
				System.out.println();
				break;
			
			case 2:
				System.out.println("Please enter the name of the customer.");
				name=scan.next();
				System.out.println("Please enter the type of account.");
				type=scan.next();
				result=registerNewAccount(listCustomers,listAccounts,name,type);
				System.out.println(result);
				System.out.println();
				break;
				
			case 3:
				System.out.println("Please enter the name of the customer.");
				name=scan.next();
				result=createTransaction(listCustomers,name);
				System.out.println(result);
				System.out.println();
				break;
				
			case 4:
				System.out.println("Please enter the name of the customer.");
				name=scan.next();
				showCustomerDetails(listCustomers,name);
				
				
			case 5:
				showCustomers(listCustomers);
				System.out.println();
				break;
			
			default:
				break;
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	public static String registerNewCustomer(HashMap<String,Customer> listCustomers, String customerName) {
		if(listCustomers.get(customerName)==null) {//Check if the user doesn't exist
			listCustomers.put(customerName, new Customer((listCustomers.size()+1),customerName));//Create the user 
			return "User has been registered";
		}
		else {
			return "User already registered";
		}
	}
	
	public static void showCustomers(HashMap<String,Customer> listCustomers) {
		for(Customer name : listCustomers.values()) {
			System.out.println(name.customerName);
		}
	}
	
	public static String registerNewAccount(HashMap<String, Customer> listCustomers,HashMap<Integer,Account> listAccounts,String customerName, String type) {
		boolean isRegistered=false;
		String result="";
		if(listCustomers.get(customerName)!=null) {//Check if the user already exist.
			for(Account accountType : listCustomers.get(customerName).custAccount.values()) {
				String t = accountType.getType();
				if(type.equals(t)){//Check if the user has an account of this type
					isRegistered=true;
					result = "User already has a " + type + " account";
				}
			}
			if(isRegistered==false) {//If the user doesn't have an account proceed to get the data to create the account
				int accountNumber = listCustomers.get(customerName).custAccount.size()+1;
				int customerNumber = listCustomers.get(customerName).getCustomerNum();
				
				switch(type) {//Depending of the type of account this is created
				case "Saving":
					listCustomers.get(customerName).custAccount.put(accountNumber, new SavingAccount(customerNumber, accountNumber,0,type,0,5));
					listAccounts.put(accountNumber, new SavingAccount(customerNumber, accountNumber,0,type,0,5));
					result="The account has been created.";
					break;
				case "Current":
					listCustomers.get(customerName).custAccount.put(accountNumber, new CurrentAccount(customerNumber, accountNumber,0,type,0));
					listAccounts.put(accountNumber, new CurrentAccount(customerNumber, accountNumber,0,type,0));
					result="The account has been created.";
					break;
				case "Mortgage":
					listCustomers.get(customerName).custAccount.put(accountNumber, new CurrentAccount(customerNumber, accountNumber,0,type,3));
					listAccounts.put(accountNumber, new CurrentAccount(customerNumber, accountNumber,0,type,3));
					result="The account has been created.";
					break;
				default:
					break;
				}
				
			}
			return result;
		}
		else {
			return "User not registered";
		}
	}
	
	public static String createTransaction(HashMap<String,Customer> listCustomers, String customerName) {
		String result="";
		if(listCustomers.get(customerName)!=null) {
			Customer customer=listCustomers.get(customerName);
			if(customer.custAccount.size()>0) {
				System.out.println("Accounts availables:");
				for(Account account : customer.custAccount.values()) {
					System.out.println(account.getType());
				}
				System.out.println("Type the account to use please...");
				Scanner scan = new Scanner(System.in);
				String opt = scan.next();
				int accountNumber=0;
				for(Account account : customer.custAccount.values()) {
					if(account.getType().equals(opt)) {
						accountNumber=account.getAccountNum();
					}
				}
				System.out.println("Type the mount of the transaction please...");
				int amount=scan.nextInt();
				System.out.println("Type the type of the transaction (deposit or withdraw) please...");
				String type=scan.next();
				int transactionNum=0;
				switch(opt) {
				case "Saving":
					transactionNum=customer.custAccount.get(accountNumber).transactions.size()+1;
					customer.custAccount.get(accountNumber).transactions.put(transactionNum, new Transaction(accountNumber,amount,type,transactionNum));
					result="transaction completed.";
					break;
				case "Current":
					transactionNum=customer.custAccount.get(accountNumber).transactions.size()+1;
					customer.custAccount.get(accountNumber).transactions.put(transactionNum, new Transaction(accountNumber,amount,type,transactionNum));
					result="transaction completed.";
					break;
				case "Mortgage":
					transactionNum=customer.custAccount.get(accountNumber).transactions.size()+1;
					customer.custAccount.get(accountNumber).transactions.put(transactionNum, new Transaction(accountNumber,amount,type,transactionNum));
					result="transaction completed.";
					break;
				default:
					result= "Incorrect account.";
				}
				return result;
			}
			else {
				return "The user doesn't have an account.";
			}
		}else {
			return "User doesn't exist";
		}
		
		
		
	}
	
	public static void showCustomerDetails(HashMap<String,Customer> listCustomers, String customerName) {
		if(listCustomers.get(customerName)!=null) {
			Customer customer=listCustomers.get(customerName);
			if(customer.custAccount.size()>0) {
				System.out.println("Accounts availables:");
				for(Account account : customer.custAccount.values()) {
					System.out.println(account.getType());
					System.out.println("  Transactions:");
					for(Transaction transaction : account.transactions.values()) {
						System.out.println("	#"+transaction.accountNum+ " " +transaction.amount);
					}
				}	
			}
			else {
				System.out.println( "The user doesn't have an account.");
			}
		}else {
			System.out.println( "User doesn't exist");
		}
	}


	
	
}

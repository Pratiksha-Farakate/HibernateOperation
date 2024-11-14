package com.tka.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.tka.config.HibernateConfiguration;
import com.tka.dao.AccDaoImpl;
import com.tka.entity.Account;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//SessionFactory sf=HibernateConfiguration.getSessionFactory();
	//HibernateConfiguration.getSessionFactory();
		//AccDaoImpl dao=new AccDaoImpl();
//	    Account account=new Account(1234582697,"Raj","saving","5632",1564538567,80000.0);
//	    
//	    String msg=dao.createaccount(account);
//	    System.out.println(msg);
//	   
		
//		long accNumber=1234556789;
//		String msg=dao.deleteAccountByaccNumber(accNumber);
//		System.out.println(msg);
		
//		Account account=new Account(1234556234,"Radha","saving","5632",1564538567,80000.0);
//		String msg=dao.updateAccount(account);
//		System.out.println(msg);
//		
//		
//		
//		Object obj=dao.getAccount(1234556234);
//		System.out.println(obj);
		
		
		//get account by name
//		String accHolderName="Raj";
//		Object obj=dao.getAccByName(accHolderName);
//		System.out.println(obj);
		
	
//		long accNumber = 0;
//		List<Account>list=dao.getAccByNumber(accNumber);
//		for(Account account:list)
//			System.out.println(list);
//		
//		long accNumber = 0;
//		List<Account>list=dao.getGreaterAccountRecords(accNumber);
//	    for(Account account:list)
//	    	System.out.println(account);
//		
//	
		AccDaoImpl dao = new AccDaoImpl();
		Scanner scanner = new Scanner(System.in);
		int choice;
		char ch;
		do {

			System.out.println("Press 1 for Create Account");
			System.out.println("Press 2 for Delete Account");
			System.out.println("Press 3 for Get Account");
			System.out.println("Press 4 for Update Account");
			System.out.println("Press 5 for get account by name");
			System.out.println("Press 6 for get account by number");
			System.out.println("Press 7 for get between two account");
			System.out.println("Press 8 for get max accountbalance");
             System.out.println("press 9 fpr get max balance account number");
             System.out.println("press 10 for get count of record");

			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				Account account = new Account(107, "xyz", "saving", "123456789", 9876543210l, 78654d);
				Object obj = dao.createaccount(account);
				System.out.println(obj);
				break;

			}

			case 2: {
				long accNumber=107;
				String msg = dao.deleteAccountByaccNumber(accNumber);
				System.out.println(msg);
				break;

			}
			case 3: {
				long accNumber=103;
				Object account = dao.getAccount(accNumber);
				if(account!=null) {
					System.out.println(account);
				}else {
					System.out.println(accNumber + " is Not Exist");
				}
				break;

			}
			case 4: {
				Account account = new Account(103, "abc", "saving", "1234", 9876543210l, 78654d);
				dao.updateAccount(account);
				break;

			}
			case 5:{
				String holderName="sushant";
				Object obj = dao.getAccByName(holderName);
				System.out.println(obj);
				break;
				
			}
			
			case 6:{
				List<Account>list=dao.getAccByNumber(105);
				for( Account account:list) {
					System.out.println(account);
					break;
				}
			}
			
			case 7:{
				List <Account>list=dao.betweenAccount(104,106);
				for(Account account:list) {
					System.out.println(account);
					break;
					
				}
			}
			case 8:{
			double maxbalance=dao.getMaxBalance();
			System.out.println(maxbalance);
			break;
			}
			case 9:{
				List<Account>list=dao.getMaxBalanceAccount();
				for(Account account:list) {
					System.out.println(list);
					break;
				}
				}
			case 10:{
				long count=dao.countAccount();
				System.out.println(count);
				break;
			}
	
				

			default:
				System.out.println("Invalid Choice");
				break;
			}

			System.out.println("Do you want to continue y/n");
			ch = scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}


		
	}

	


package com.tka.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tka.config.HibernateConfiguration;
import com.tka.entity.Account;

public class AccDaoImpl {
	SessionFactory sf=HibernateConfiguration.getSessionFactory();

	String msg="";
		public String createaccount(Account account) {
			try {
				
				
				Session session=sf.openSession();
				session.save(account);
				
				session.beginTransaction().commit();
				msg="added";
			}catch(Exception e) {
				e.printStackTrace();
				msg="something wrong";
			}
			return msg;
		}
		
		public String deleteAccountByaccNumber(long accNumber) {
			String msg="";
			 
			try {
				SessionFactory sf=HibernateConfiguration.getSessionFactory();
				Session session=sf.openSession();
				
				Account account=session.get(Account.class,accNumber);
				
				if(account!=null) {
				session.delete(account);
				session.beginTransaction().commit();
			    msg="deleted";
				}else {
					msg="account not exist with accNumber ?";
				}
			}catch(Exception e){
				e.printStackTrace();
				msg="something went wrong";
			}
			
			return msg;
			
		}
		public String updateAccount(Account account)
		{
			String msg;
			try {
				SessionFactory sf=HibernateConfiguration.getSessionFactory();
				Session session=sf.openSession();
				
				Account dbaccount=session.get(Account.class, account.getAccNumber());
				if (dbaccount!=null) {
					session.evict(dbaccount);
					session.update(account);
					session.beginTransaction().commit();
					
					msg="Updated successfully";
					
				} else {
					msg="Account not exist to update";

				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
				msg="something went wrong";
			}
			return msg;
			
		}
		public Object getAccount(long accNumber)
		{
			
			try {
				SessionFactory sf=HibernateConfiguration.getSessionFactory();
				Session session=sf.openSession();
				
				Account account=session.get(Account.class,accNumber);
				if (account!=null) {
					session.beginTransaction().commit();
					return account;	
				}else {
					return "account not exist with id"+accNumber;
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				return"something went wrong";
			}
			
			
		}
		
		 public Object getAccByName(String holderName) {
			 String msg=null;
			 Account account=null;
			 try {
				 Session session=sf.openSession();
				 
				 Criteria criteria=session.createCriteria(Account.class);
				 criteria.add(Restrictions.eq("accHolderName", holderName));
				 
				 List<Account>list=criteria.list();
				 account=list.get(0);
			} catch (Exception e) {
			      e.printStackTrace();
			      msg="something wrong";
			}
			return account;
			 
		 }
		
		 public List<Account> getAccByNumber(long accNumber) {//103
			 List<Account> list=null;
			 try {
				 Session session=sf.openSession();
				 Criteria criteria=session.createCriteria(Account.class);
				 criteria.add(Restrictions.gt("accNumber", accNumber));
				 list=criteria.list();
				 //account=list.get(0);
				 
			list.get(0);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			      
			}
			return list;
			 
		 }
		 
		 public List<Account> getGreaterAccountRecords(long accNumber)
		 {
			 List<Account> list=null;
			 try {
				 Session session=sf.openSession();
				 Criteria criteria=session.createCriteria(Account.class);
				 criteria.add(Restrictions.gt("accNumber", accNumber));
				List<Account>list1=criteria.list();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
			 
		 }
		 
		 public List<Account> betweenAccount(long from,long to){
			 List<Account> list=new ArrayList<>();

			 try {
				 Session session=sf.openSession();
				 Criteria criteria=session.createCriteria(Account.class);
				 criteria.add(Restrictions.between("accountNumber", from, to));
				 list=criteria.list();
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return list;
			 
		 }
		 
		 public Double getMaxBalance() {
			double maxBalance=0;
			 try {
				Session session=sf.openSession();
				Criteria criteria=session.createCriteria(Account.class);
				
				criteria.setProjection(Projections.max("Balance"));
	
						List<Double>list=criteria.list();
						maxBalance=list.get(0);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
			return maxBalance;
			 
		 }
		 
		 public List<Account>getMaxBalanceAccount(){
			 List<Account> list=new ArrayList<>();
			 
			 try {
				Session session= sf.openSession();
				Criteria criteria=session.createCriteria(Account.class);
				//double maxBalance=getMaxBalance();
				Double maxBalance = (Double) criteria.setProjection(Projections.max("balance")).uniqueResult();
				criteria.add(Restrictions.eq("Balance",maxBalance));
				list=criteria.list();
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return list;
			 
		 }
		 
		 public long countAccount() {
			 long count=0;
			 try {
			Session session= sf.openSession();
			Criteria criteria=session.createCriteria(Account.class);

			criteria.setProjection(Projections.count("accNumber"));
				count=(long) criteria.uniqueResult()	;
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			 
			 
			return count;
			 
		 }
		 
}



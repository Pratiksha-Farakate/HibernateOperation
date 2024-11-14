package com.tka.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.tka.entity.Account;

public class HibernateConfiguration {
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg=new Configuration();
		cfg.configure().addAnnotatedClass(Account.class);
		 SessionFactory sf=cfg.buildSessionFactory();
		return sf;
	}
	


}

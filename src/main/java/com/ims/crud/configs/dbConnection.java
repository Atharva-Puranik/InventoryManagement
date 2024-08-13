package com.ims.crud.configs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class dbConnection {
	

	public static final String HQL_SELECT_ALL_PRODUCTS = "FROM Product";
	
	public static Session initDatabase() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
	
}

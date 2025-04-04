package com.studentGrade.resources;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionProvider {
	
static SessionFactory factory;
	
	public static SessionFactory getFactory() {
		
		if(factory == null) {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
	
	public static void closeFactory() {
		if(factory != null) {
			factory.close();
		}
	}

}

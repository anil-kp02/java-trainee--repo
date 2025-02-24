package com.quiz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.quiz.entity.Options;
import com.quiz.util.HibernateUtil;

public class OptionDao {
	SessionFactory sessionFactory;
	
	//get Option By id 
	public Options getOptionById(Integer id ) {
		sessionFactory = HibernateUtil.getseSessionFactory();
		Session session = sessionFactory.openSession();
		
		Options options = (Options) session.get(Options.class, id);
		
		session.close();
		return options;
	}
	
}

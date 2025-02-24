package com.quiz.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.quiz.entity.User;
import com.quiz.util.HibernateUtil;

public class UserDao {
	SessionFactory sessionFactory;
	
	// to add a new user 
	public void addUser(User user) {
		sessionFactory = HibernateUtil.getseSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	// get user by id 
	public User getUser(Long id ) {
		
		sessionFactory = HibernateUtil.getseSessionFactory();
		Session session = sessionFactory.openSession();
		
		User user= (User) session.get(User.class,id);
		
		session.close();
		
		return user;
		
	}
	
	//To view Score Of a Particular Student by id 
	public Float getScore(Long id) {
		sessionFactory = HibernateUtil.getseSessionFactory();
		Session session = sessionFactory.openSession();
		
		User user= (User) session.get(User.class, id);
		Float score= user.getScore();
		
		session.close();
		
		return score;
	}
	
	
}

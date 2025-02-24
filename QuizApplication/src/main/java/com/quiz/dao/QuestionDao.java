package com.quiz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.quiz.entity.Questions;
import com.quiz.util.HibernateUtil;

public class QuestionDao {
	SessionFactory sessionFactory;
	
	//to get all the questions 
	public List<Questions> getAllQuestion() {
		
		sessionFactory = HibernateUtil.getseSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Questions> questions = session.createQuery("From Questions",Questions.class).getResultList();
		session.close();
		return questions;
	}
	
	//get Question by id 
	public Questions getQuestionById(Integer id) {
		sessionFactory = HibernateUtil.getseSessionFactory();
		Session session = sessionFactory.openSession();
		
		Questions questions = (Questions) session.get(Questions.class, id);
		
		session.close();
		return questions;
	}
}

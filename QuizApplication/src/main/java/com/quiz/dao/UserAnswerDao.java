package com.quiz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mysql.cj.Query;
import com.quiz.entity.Answer;
import com.quiz.entity.User;
import com.quiz.entity.UserAnswerMapping;
import com.quiz.util.HibernateUtil;

public class UserAnswerDao {
	SessionFactory sessionFactory;
	
	public void addUserResponse(UserAnswerMapping answerMapping) {
		sessionFactory = HibernateUtil.getseSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(answerMapping);
		
		session.getTransaction().commit();
		session.close();
		
	}
	public Float calculateScore(Long id) {
		sessionFactory = HibernateUtil.getseSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user = (User)session.get(User.class, id);
		
		List<UserAnswerMapping> list = session.createQuery("From UserAnswerMapping where userId.id=:value",UserAnswerMapping.class).setParameter("value",id).getResultList();
		List<Answer> listAnswer = session.createQuery("From Answer",Answer.class).getResultList();
		Float score =0.0f;
		for(UserAnswerMapping response:list) {
			
			for(Answer answer : listAnswer) {
				if(response.getQuestionId()==answer.getQuestionId()) {
					if(response.getOption()==answer.getAnswer()) {
						score++;
					}
				}
			}
		}
		user.setScore(score);
		session.getTransaction().commit();
		session.close();
		
		return score;
		
		
	}
}

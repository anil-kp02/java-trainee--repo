package com.criteriaAndHql.dao.DaoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.criteriaAndHql.dao.CompanyDao;
import com.criteriaAndHql.entity.Company;
import com.criteriaAndHql.entity.Employee;
import com.criteriaAndHql.util.HibernateUtil;

public class CompanyDaoImple implements CompanyDao{

	SessionFactory factory;
	
	public void addCompany(Company company) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(company);
		
		session.getTransaction().commit();
		session.close();
		
	}

	/*
	 * public Company getCompanyById(Long id) { factory =
	 * HibernateUtil.getseSessionFactory(); Session session = factory.openSession();
	 * 
	 * Company company = session.get(Company.class, id); session.close();
	 * 
	 * return company; }
	 */

	public List<String>  getCompanyNamesById(Long id) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(Employee.class,"e");
		
		criteria.createAlias("e.companyId", "c");
		criteria.setProjection(Projections.projectionList().add(Projections.property("c.name")));
		criteria.add(Restrictions.eq("c.id", id));
		
		List<String> companies= criteria.list();
		
		session.close();
		
		return companies;
	}

	public String getCompanyByName(String name) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();
		Company company = session.createQuery("From Company where name =:id",Company.class).setParameter("id",name).getSingleResult();
		session.close();
		String companyName= company.getName();
		
		return companyName;
	}

	public List<String> getCompanyUsingJoin(String name) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();
		Query query =   session.createQuery("Select c.name From Employee e JOIN e.companyId c where e.companyId.name = :value",String.class)
				.setParameter("value", name);
		List<String> companies= query.getResultList();
		session.close();
		return companies;
	}

	public List<String> getEmployeByCompanyName(String name) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();
		Query query =   session.createQuery("Select e.name From Employee e where e.companyId.name = :value",String.class)
				.setParameter("value", name);
		List<String> employees= query.getResultList();
		session.close();
		return employees;
	}

	public List<Object[]> getCompanyNamesWithEmployeeCount() {
		
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();
		
		Query query = session.createQuery(" Select e.companyId.name , count(e.name) from Employee e GROUP BY e.companyId.id",Object[].class);
		List<Object[]> list = query.getResultList();
		
		session.close();
		
		return list;
	}

}

package com.employeeValidation.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.employeeValidation.dao.CompanyDao;
import com.employeeValidation.entity.Company;
import com.employeeValidation.util.HibernateUtil;

	

public class CompanyDaoImpl implements CompanyDao{
	
	SessionFactory factory = HibernateUtil.getseSessionFactory();
	
	public Company getCompany(Long id) {
		
		Session session = factory.openSession();
		
		Company company = session.get(Company.class, id);
		
		session.close();
		
		return company;
	}

	
	
}

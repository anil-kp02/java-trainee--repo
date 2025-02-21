package com.hibenateDemo3.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import org.hibernate.Session;

import com.hibenateDemo3.dto.EmployeeDto;
import com.hibenateDemo3.entity.Company;
import com.hibenateDemo3.entity.Employee;
import com.hibenateDemo3.resources.ConnectionProvider;

public class CompanyDao {
	
	public Company saveOrUpdate(String name) {
		Session session = ConnectionProvider.getFactory().openSession();
		List<Company> companyList= session.createQuery("From Company",Company.class).list();
		for(Company company:companyList) {
			if(company.getName()==name) {
				//Company company=(Company) session.get(Company.class,com.getId());
				return company;
			}
		}
		Company company = new Company();
		company.setName(name);
		session.close();
		return company;
		
	}
	
	public void addNewCompany(String name) {
		Session session = ConnectionProvider.getFactory().openSession();
		Company company = new Company();
		session.beginTransaction();
		company.setName(name);
		session.merge(company);
		session.getTransaction().commit();
		session.close();
		session.beginTransaction();
		
	}
	
	
	public List<EmployeeDto> getCompanyEmployee(String companyName) {
	    Session session = ConnectionProvider.getFactory().openSession();
	    List<EmployeeDto> resultList = new ArrayList<>();
	    try {
	       
	        Query query = session.createQuery("from Employee e where e.company.name = :value");
	        query.setParameter("value", companyName);
	        
	        	        List<Employee> list = query.getResultList();
	        
	        
	        resultList = list.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        session.close(); // Ensuring the session is closed
	    }
	    return resultList;
	}

	 public Integer deleteCompany(String company) {
		 Session session = ConnectionProvider.getFactory().openSession();
		 session.beginTransaction();
		 Query query= session.createQuery("delete from Company where name=:value");
		 query.setParameter("value", company);
		 Integer affecttedRow= query.executeUpdate();
		 session.getTransaction().commit();
		 session.close();
		 return affecttedRow;
	 }
	
}

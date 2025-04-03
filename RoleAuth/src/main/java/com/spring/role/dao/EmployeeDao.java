package com.spring.role.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.role.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	 
	
	public Employee findByEmail(String email) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		
		Predicate predicate = builder.equal(root.get("email"),email);
		criteriaQuery.select(root).where(predicate);
		TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
		
		return query.getSingleResult();
		
	}
	
	@Transactional
	public void save(Employee employee) {
		entityManager.persist(employee);
	}

	public List<Employee> getAll() {
		
		TypedQuery<Employee> emQuery= entityManager.createQuery("select e from Employee e",Employee.class);
		
		
		return emQuery.getResultList();
	}

}

package com.spring.role.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.role.entity.Address;
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
public class AddressDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Address> findByEmployeeID(Long id){
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Address> criteriaQuery = builder.createQuery(Address.class);
		Root<Address> root = criteriaQuery.from(Address.class);
		
		Predicate predicate = builder.equal(root.get("employee"),id);
		criteriaQuery.select(root).where(predicate);
		TypedQuery<Address> query = entityManager.createQuery(criteriaQuery);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public void saveAddress(Address address) {
		entityManager.persist(address);
	}
	
	

}

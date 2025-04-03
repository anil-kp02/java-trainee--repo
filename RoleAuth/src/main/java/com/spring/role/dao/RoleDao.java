package com.spring.role.dao;

import org.springframework.stereotype.Repository;

import com.spring.role.entity.Role;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class RoleDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Role findByName(String name) {
		TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
	@Transactional
	public void save(Role role) {
		entityManager.merge(role);
	}

}

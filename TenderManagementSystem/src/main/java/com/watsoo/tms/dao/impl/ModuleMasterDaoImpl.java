package com.watsoo.tms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.watsoo.tms.dao.ModuleMasterDao;
import com.watsoo.tms.entity.ModuleMaster;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
public class ModuleMasterDaoImpl implements ModuleMasterDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Long addModule(ModuleMaster module) {
		Session session = entityManager.unwrap(Session.class);
		
		//entityManager.persist(module); 
		Long id =(Long)session.save(module);
		session.flush();
		session.clear();
		return id;
	}

	@Override
	@Transactional
	public ModuleMaster updateModule(ModuleMaster module) {
		
//		 ModuleMaster master = entityManager.merge(module);
		Session session = entityManager.unwrap(Session.class);
		session.update(module);
		 
//		 return master;
		return null;
		
	}

	@Override
	@Transactional
	public ModuleMaster deleteModule(Long id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<ModuleMaster> criteriaQuery = criteriaBuilder.createQuery(ModuleMaster.class);
		Root<ModuleMaster> root = criteriaQuery.from(ModuleMaster.class);
		
		Predicate predicate = criteriaBuilder.equal(root.get("id"), id);
		criteriaQuery.where(predicate);
		
		ModuleMaster moduleMaster = entityManager.createQuery(criteriaQuery).getSingleResult();
		if(moduleMaster != null) {
			moduleMaster.setIsActive(false);
			ModuleMaster module = session.merge(moduleMaster);
			
			session.flush();
			session.clear();
			
			return module;
		}
		
		session.clear();
		
		return null;
	}

	@Override
	public ModuleMaster findModuleById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		ModuleMaster module = session.get(ModuleMaster.class, id);
		session.clear();
		return module;
	}

	@Override
	public List<ModuleMaster> findAllModules() {
		Session session = entityManager.unwrap(Session.class);
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<ModuleMaster> criteriaQuery = criteriaBuilder.createQuery(ModuleMaster.class);
		Root<ModuleMaster> root = criteriaQuery.from(ModuleMaster.class);
		criteriaQuery.select(root);
		
		List<ModuleMaster> modules = session.createQuery(criteriaQuery).getResultList();
		
		session.clear();
		
		return modules;
	}

}

package com.watsoo.tms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.watsoo.tms.dao.ModuleMappingDao;
import com.watsoo.tms.entity.ModuleMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
public class ModuleMappingDaoImpl implements ModuleMappingDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Long addMapping(ModuleMapping mapping) {
		
//		entityManager.persist(mapping);
		Session session = entityManager.unwrap(Session.class);
//		Long id= (Long)session.save(mapping);
		session.persist(mapping);
		
		session.flush();
		session.clear();
		
		return mapping.getId();
		
		
	}

	@Override
	@Transactional
	public ModuleMapping updateMapping(ModuleMapping mapping) {
		
		Session session = entityManager.unwrap(Session.class);
		ModuleMapping moduleMapping = session.merge(mapping); ;
//		 session.update(mapping);
		session.flush();
		session.clear();
		
		return moduleMapping;
	}

	@Override
	public ModuleMapping findMappingById(Long id) {
		
		Session session = entityManager.unwrap(Session.class);
		ModuleMapping mapping =session.get(ModuleMapping.class, id);
		session.clear();
		
		return mapping;
	}

	@Override
	public List<ModuleMapping> findAllMappings() {
		
		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<ModuleMapping> criteriaQuery = criteriaBuilder.createQuery(ModuleMapping.class);
		Root<ModuleMapping> root = criteriaQuery.from(ModuleMapping.class);
		criteriaQuery.select(root);
		
		List<ModuleMapping> mappings = entityManager.createQuery(criteriaQuery).getResultList();
		
		session.clear();
		
		return mappings;
	}

	@Override
	@Transactional
	public ModuleMapping deleteMapping(Long id) {
		Session session = entityManager.unwrap(Session.class);
		ModuleMapping mapping = session.find(ModuleMapping.class, id);
		
		if(mapping != null) {
			session.remove(mapping);
		}
		
		session.flush();
		session.clear();
		return mapping;
	}

	
	
}

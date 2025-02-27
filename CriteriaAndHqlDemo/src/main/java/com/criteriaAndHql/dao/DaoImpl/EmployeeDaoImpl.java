package com.criteriaAndHql.dao.DaoImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.criteriaAndHql.dao.EmployeeDao;
import com.criteriaAndHql.entity.Employee;
import com.criteriaAndHql.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	SessionFactory factory;

	public void addEmployee(Employee employee) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		session.persist(employee);

		session.getTransaction().commit();
		session.close();

	}

	public List<Employee> getEmployessByCriteria() {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employeeList = criteria.list();

		session.close();

		return employeeList;
	}

	public List<Employee> getEmployeeWithSalaryGreater80K() {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", 80000D));
		List<Employee> employees = criteria.list();

		session.close();

		return employees;
	}

	public List<Employee> getEmployeeBasedOnSalaryAndCompanyId(Double salary, Long id) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Employee.class,"e");
		criteria.createAlias("e.companyId","c");
		criteria.add(Restrictions.or(Restrictions.gt("e.salary", salary), Restrictions.eq("c.id", id)));
		List<Employee> employees = criteria.list();

		session.close();

		return employees;
	}

	public List<Employee> getEmployeeOrderBySalaryDesc() {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.desc("salary"));
		List<Employee> employees = criteria.list();

		session.close();

		return employees;

	}

	public List<Object[]> getEmployeeNameAndSalary() {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(
				Projections.projectionList().add(Projections.property("name")).add(Projections.property("salary")));

		List<Object[]> list = criteria.list();

		return list;
	}

	public List<String> getEmployeeNamesByCompanyIds(List<Long> employeIds) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Employee.class,"e");
		criteria.setProjection(Projections.projectionList().add(Projections.property("e.name")));
		criteria.createAlias("e.companyId","c");
		criteria.add(Restrictions.in("c.id",employeIds));

		List<String> list =criteria.list();

		session.close();

		return list;
	}

	public List<Employee> getEmployessByHql() {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		List<Employee> employees = session.createQuery("From Employee", Employee.class).getResultList();

		session.close();

		return employees;

	}

	public List<String> getAllDegignations() {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("Select DISTINCT degignation From Employee", String.class);
		List<String> names = query.getResultList();
		session.close();

		return names;

	}

	public List<Object[]> getEmployeDeatilsWithName() {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("Select e.name,e.degignation,e.salary,e.companyId.name From Employee e",
				Object[].class);
		List<Object[]> list = query.getResultList();

		session.close();

		return list;
	}

	public List<Employee> getEmployeByCompanyId(Long id) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		List<Employee> employees = session.createQuery("From Employee e Where e.companyId.id = :value", Employee.class)
				.setParameter("value", id).getResultList();

		session.close();
		return employees;
	}

	public List<Employee> getEmployeByASalaryAndCompanyId(Double salary, Long id) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		List<Employee> employees = session
				.createQuery("From Employee e where e.salary >=:salary And e.companyId.id=:id", Employee.class)
				.setParameter("salary", salary).setParameter("id", id).getResultList();

		session.close();

		return employees;
	}

	public List<Employee> getEmployeByASalaryAndCompanyIdUsingPositionalParameter(Double salary, Long id) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		List<Employee> employees = session
				.createQuery("From Employee where salary >=?1 And companyId.id = ?2", Employee.class)
				.setParameter(1, salary).setParameter(2, id).getResultList();

		session.close();

		return employees;
	}

	public List<Object[]> getEmployeeNamesCompanynameSalaryOrderByDesc() {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("select e.name,e.salary,e.companyId.name from Employee e Order By e.salary Desc",
				Object[].class);
		List<Object[]> list = query.getResultList();
		session.close();

		return list;
	}

	public List<String> getEmployeeNameForMultipleIds(List<Long> companyIds) {

		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("select e.name from Employee e where e.companyId.id in :companyIds",
				String.class).setParameter("companyIds", companyIds);
		List<String> list = query.getResultList();
		session.close();
		return list;
	}

	public List<String> getEmployeeNameForMultipleIdsUsingJoin(List<Long> companyIds) {
		factory = HibernateUtil.getseSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("select e.name from Employee e JOIN e.companyId c where c.id in :companyIds",
				String.class).setParameter("companyIds", companyIds);
		List<String> list = query.getResultList();
		session.close();
		return list;
	}

}

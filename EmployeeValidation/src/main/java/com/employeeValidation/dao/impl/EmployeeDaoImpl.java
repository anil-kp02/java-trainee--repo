package com.employeeValidation.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.employeeValidation.dao.EmployeeDao;
import com.employeeValidation.entity.Employee;
import com.employeeValidation.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	SessionFactory factory = HibernateUtil.getseSessionFactory();

	public void addEmployee(Employee employee) {
		Session session = factory.openSession();
		session.beginTransaction();

		session.save(employee);

		session.getTransaction().commit();
		session.close();

	}

	public Employee getEmployee(Long id) {
		Session session = factory.openSession();

		Employee employee = (Employee) session.get(Employee.class, id);

		session.close();

		return employee;
	}

	public List<Employee> getAllEmployee() {
		Session session = factory.openSession();

		Query query = session.createQuery("From Employee", Employee.class);
		List<Employee> employees = query.getResultList();

		session.close();

		return employees;
	}

	public void updateEmployeeSalary(Long id, Double updatedSalary) {
		Session session = factory.openSession();
		session.beginTransaction();

		Employee employee = (Employee) session.get(Employee.class, id);
		employee.setSalary(updatedSalary);
		
		session.update(employee);
		session.getTransaction().commit();
		session.close();

	}

}

package com.spring.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.role.dao.EmployeeDao;
import com.spring.role.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeDao dao;

	public void saveEmployee(Employee employee) {
		dao.save(employee);
		
	}
	public Employee getEmployeeByEmail(String mail) {
		Employee findByEmail = dao.findByEmail(mail);
		
		return findByEmail;
	}
	public List<Employee> findAll() {
		
		List<Employee> employees = dao.getAll();
		
		return employees;
	}

	

}

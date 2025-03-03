package com.employeeValidation.dao;

import java.util.List;

import com.employeeValidation.entity.Employee;

public interface EmployeeDao {
	
	//to Add a employee
	void addEmployee(Employee employee);
	
	//to view a Employe
	Employee getEmployee(Long id);
	
	// to view all employee
	List<Employee> getAllEmployee();
	
	//To Update Employee
	void updateEmployeeSalary(Long id,Double updatedSalary);
	
}

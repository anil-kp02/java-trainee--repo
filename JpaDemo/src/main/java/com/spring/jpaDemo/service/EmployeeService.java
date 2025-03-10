package com.spring.jpaDemo.service;

import java.util.List;

import com.spring.jpaDemo.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto addEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployee(EmployeeDto employeeDto);

	List<EmployeeDto> getAllEmployee();

	boolean existsByName(String name);
	
	

}

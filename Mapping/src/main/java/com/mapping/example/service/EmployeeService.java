package com.mapping.example.service;

import java.util.List;

import com.mapping.example.entity.Employee;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public interface EmployeeService {

	List<Employee> getAllEmployeeList();

	Employee getEmployeeById(Long id);

	Employee getEmployeeByName(String name);

	List<Employee> getAllEmployeeByNameNotLike(String name);

	List<Employee> findDistinctByName(String name);

	List<Employee> findByNameAndSalary(String name, Double salary);

	List<Employee> findByNameOrSalary(String name, Double salary);

	List<Employee> findBySalaryLessThan(Double salary);

	List<String> findByNameOrderBySalaryDesc();

	List<Employee> findBySalaryBetween(Double lowerLimit, Double upperLimit);

	List<Employee> findBySalaryLessThanEqual(Double salary);

	List<Employee> findBySalaryNull();

	List<Employee> findByNameLike(String name);

	List<Employee> findByNameNot(String name);

	List<Employee> findByAgeIn(List<Integer> list);

	List<Employee> getEmployeeByNameIgnoreCase(String name);

}

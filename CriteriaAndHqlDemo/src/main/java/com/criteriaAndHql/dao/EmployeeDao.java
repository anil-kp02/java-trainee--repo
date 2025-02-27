package com.criteriaAndHql.dao;

import java.util.List;

import com.criteriaAndHql.entity.Employee;

public interface EmployeeDao {
	
	void addEmployee(Employee employee);
	
	//Retrieve all employees by criteria
	List<Employee> getEmployessByCriteria(); 
	
	//Filter employees with salary greater than 80,000 and order by salary descending
	List<Employee> getEmployeeWithSalaryGreater80K();
	
	//Filter employees based on salary and company ID using Restrictions.or()
	List<Employee> getEmployeeBasedOnSalaryAndCompanyId(Double salary,Long id);
	
	//Retrieve employees ordered by salary descending
	List<Employee> getEmployeeOrderBySalaryDesc();
	
	//Retrieve specific columns (employee name and salary) using projections
	List<Object[]> getEmployeeNameAndSalary();
	
	//Fetch employee names from multiple companies based on a list of company IDs (Active query)
	List<String> getEmployeeNamesByCompanyIds(List<Long> employeIds);
	
	
	//Retrieve all employees by hql
	List<Employee> getEmployessByHql(); 
	
	//Retrieve only designations from the Employee table
	List<String> getAllDegignations();
	
	//Retrieve employee details including company name
	List<Object[]> getEmployeDeatilsWithName();
	
	//Retrieve employee details for a specific company ID
	List<Employee> getEmployeByCompanyId(Long id);
	
	//Retrieve employee details where salary is greater than or equal to a value and filtered by company ID
	List<Employee> getEmployeByASalaryAndCompanyId(Double salary,Long id);
	
	//Same as above but using positional parameters (?1, ?2) instead of named parameters
	List<Employee> getEmployeByASalaryAndCompanyIdUsingPositionalParameter(Double salary,Long id);
	
	//Retrieve employee names, company names, and salaries ordered by salary descending
	List<Object[]> getEmployeeNamesCompanynameSalaryOrderByDesc();
	
	//Retrieve employee names where company ID is in a given list (alternative commented-out query included)
	List<String> getEmployeeNameForMultipleIds(List<Long> companyIds);
	
	//Retrieve employee names using JOIN and filtering by multiple company IDs
	List<String> getEmployeeNameForMultipleIdsUsingJoin(List<Long> companyIds);
	
}

package com.criteriaAndHql.service;

public interface EmployeeService {
	
	void getEmployessByCriteria();
	
	void getEmployeeWithSalaryGreater80K();
	
	void getEmployeeBasedOnSalaryAndCompanyId();
	
	void getEmployeeOrderBySalaryDesc();
	
	void getEmployeeNameAndSalary();
	
	void getEmployeeNamesByCompanyIds();
	
	void getEmployessByHql();
	
	void getAllDegignations();
	
	void getEmployeDeatilsWithName();
	
	void getEmployeByCompanyId();
	
	void getEmployeByASalaryAndCompanyId();
	
	void getEmployeByASalaryAndCompanyIdUsingPositionalParameter();
	
	void getEmployeeNamesCompanynameSalaryOrderByDesc();
	
	void getEmployeeNameForMultipleIds();
	
	void getEmployeeNameForMultipleIdsUsingJoin();
}

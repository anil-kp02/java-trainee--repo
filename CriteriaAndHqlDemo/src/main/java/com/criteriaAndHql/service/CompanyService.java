package com.criteriaAndHql.service;




public interface CompanyService {
	void getCompanyNamesById();
	
	void getCompanyByName();
	
	void getCompanyUsingJoin();
	
	void getEmployeByCompanyName();
	
	void getCompanyNamesWithEmployeeCount();
}

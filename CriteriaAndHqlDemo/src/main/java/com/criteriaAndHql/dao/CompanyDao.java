package com.criteriaAndHql.dao;

import java.util.List;

import com.criteriaAndHql.entity.Company;
import com.criteriaAndHql.entity.Employee;

public interface CompanyDao {
	void addCompany(Company company);
	
	
	
	//Retrieve only company names based on company ID using projections
	 List<String> getCompanyNamesById(Long id);
	
	//Retrieve company names where the company name matches a given value
	String getCompanyByName(String name);
	
	//Retrieve company names using a join condition with JOIN e.company
	List<String> getCompanyUsingJoin(String name);
	
	//Retrieve employee names from a specific company
	List<String> getEmployeByCompanyName(String name );
	
	//Retrieve company names with employee count using LEFT JOIN and GROUP BY
	List<Object[]> getCompanyNamesWithEmployeeCount();
	
	
}

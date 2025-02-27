package com.criteriaAndHql.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import com.criteriaAndHql.dao.CompanyDao;
import com.criteriaAndHql.dao.DaoImpl.CompanyDaoImple;
import com.criteriaAndHql.dto.EmployeeDto;
import com.criteriaAndHql.entity.Employee;
import com.criteriaAndHql.service.CompanyService;

public class CompanyServiceImpl implements CompanyService{
	
	BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	CompanyDao companyDao = new CompanyDaoImple();

	@Override
	public void getCompanyNamesById() {
		try {
			
			
			System.out.println(" Enter the Id of the Company :");
			Long id = Long.parseLong(reader.readLine());
			List<String> names = companyDao.getCompanyNamesById(id);
			if(names.isEmpty() ) {
				System.out.println(" No name in this id ");
			}
			else {
				for(String name :names) {
					System.out.println(" Name of the company is :"+name);
				}
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getCompanyByName() {
		try{
			System.out.println(" Enter the name of the company :");
			String name = companyDao.getCompanyByName(reader.readLine());
			if(name == null) {
				System.out.println(" No company in this Name ");
			}
			else {
				System.out.println(" There is a company in this name :"+name);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public void getCompanyUsingJoin() {
		try {
			System.out.println("ENter the name of the company ");
			List<String> list = companyDao.getCompanyUsingJoin(reader.readLine());
			if(list.isEmpty()) {
				System.out.println(" No employee working in this ");
			}
			else {
				for(String name : list) {
					System.out.println(name);
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();		}
		
	}

	@Override
	public void getEmployeByCompanyName() {
		try {
			System.out.println("ENter the name of the company ");
			List<String> employees =companyDao.getEmployeByCompanyName(reader.readLine());
			//List<EmployeeDto> list = employees.stream().map(EmployeeDto::entityToDto).collect(Collectors.toList());
			if(employees.isEmpty()) {
				System.out.println(" No employee working in this ");
			}
			else {
				for(String employee : employees) {
					System.out.println(employee);
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();		}
		
	}

	@Override
	public void getCompanyNamesWithEmployeeCount() {
		List<Object[]> list = companyDao.getCompanyNamesWithEmployeeCount();
		if(list.isEmpty()) {
			System.out.println(" No data found");
		}
		else {
			for(Object[] obj : list) {
				System.out.println(" name of the company : "+(String) obj[0] +" Number of employee :"+(Long) obj[1]);
			}
		}
		
	}

}

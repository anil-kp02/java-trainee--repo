package com.employeeValidation.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.employeeValidation.dao.CompanyDao;
import com.employeeValidation.dao.impl.CompanyDaoImpl;
import com.employeeValidation.dto.CompanyDto;
import com.employeeValidation.entity.Company;
import com.employeeValidation.service.CompanyService;

public class CompanyServiceImpl implements CompanyService{
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	CompanyDao companyDao = new CompanyDaoImpl();
	public CompanyDto getCompany() {
		CompanyDto companyDto = new CompanyDto();
		try {
			System.out.println("Enter Company Id : ");
			Long id = Long.parseLong(reader.readLine());
		Company company = companyDao.getCompany(id);
		companyDto = CompanyDto.entityToDto(company);
			
		}catch (Exception e) {
			e.getMessage()	;
			}
		return companyDto;
	}

}

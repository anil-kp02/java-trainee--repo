package com.employeeValidation.dto;

import com.employeeValidation.entity.Company;
import com.employeeValidation.entity.Employee;

public class CompanyDto {
	
	private Long Id;
	
	private String name;

	public CompanyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyDto(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CompanyDto [name=" + name + "]";
	}
	
	// Entity To Dto 
	public static CompanyDto entityToDto(Company company) {
		return new CompanyDto(company.getName());
	}
	
	//Dto To entity 
	public static Company dtoToEntity(CompanyDto companyDto) {
		return new Company(companyDto.getName());
	}
	
}

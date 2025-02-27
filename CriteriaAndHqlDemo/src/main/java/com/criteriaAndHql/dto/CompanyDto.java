package com.criteriaAndHql.dto;

import java.util.List;

import com.criteriaAndHql.entity.Company;

public class CompanyDto {
	
	private Long id;
	
	private String name;
	

	public CompanyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyDto(String name) {
		super();
		this.name = name;
	}
	

	public CompanyDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	
	//entity To dto 
	
	public  static CompanyDto entityToDto(Company company) {
		return new CompanyDto(company.getId(),company.getName());
	}
	
	//dto to entity
	
	public static Company dtoToEntity(CompanyDto companyDto) {
		return new Company(companyDto.getName());
	}
	
}

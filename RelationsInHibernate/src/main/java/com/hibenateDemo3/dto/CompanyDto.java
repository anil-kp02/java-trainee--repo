package com.hibenateDemo3.dto;

import java.util.List;

import com.hibenateDemo3.entity.Employee;

public class CompanyDto {
	
	private String name;
	List<Employee> employees;
	public CompanyDto() {
		super();
			}
	public CompanyDto(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}

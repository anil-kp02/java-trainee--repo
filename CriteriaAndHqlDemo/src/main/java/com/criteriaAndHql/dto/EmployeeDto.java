package com.criteriaAndHql.dto;

import com.criteriaAndHql.entity.Employee;

public class EmployeeDto {

	private Long id;
	
	private String name;
	
	private String degignation;
	
	private Double salary;
	
	private CompanyDto comapnyId;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(String name, String degignation, Double salary, CompanyDto comapnyId) {
		super();
		this.name = name;
		this.degignation = degignation;
		this.salary = salary;
		this.comapnyId = comapnyId;
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

	public String getDegignation() {
		return degignation;
	}

	public void setDegignation(String degignation) {
		this.degignation = degignation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public CompanyDto getComapnyId() {
		return comapnyId;
	}

	public void setComapnyId(CompanyDto comapnyId) {
		this.comapnyId = comapnyId;
	}

	@Override
	public String toString() {
		return "EmployeeDto [ "+ " name=" + name + ", degignation=" + degignation + ", salary=" + salary
				+ ", comapnyId=" + comapnyId + "]";
	}
	
	// Entity to dto 
	
	public static EmployeeDto entityToDto(Employee employee) {
		return new EmployeeDto(employee.getName(),employee.getDegignation(),employee.getSalary(),CompanyDto.entityToDto(employee.getCompanyId()));
	}
	
	// Dto to entity 
	
	public static Employee dtoToEntity(EmployeeDto employeeDto) {
		return new Employee(employeeDto.getName(), employeeDto.getDegignation(),employeeDto.getSalary(),CompanyDto.dtoToEntity(employeeDto.getComapnyId()));
	}
	
}

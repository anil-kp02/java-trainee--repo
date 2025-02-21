package com.hibenateDemo3.dto;


import com.hibenateDemo3.entity.Employee;

public class EmployeeDto {
	
	private String name;
	private String email;
	private String company;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public EmployeeDto(String name, String email, String company) {
		super();
		this.name = name;
		this.email = email;
		this.company = company;
	}
	public EmployeeDto() {
		super();

	}
	
	/*
	 * public static Employee dtoToEntity(EmployeeDto employeeDto) { ; }
	 */
	public static EmployeeDto entityToDto(Employee employee) {
		return new EmployeeDto(employee.getName(),employee.getEmail() ,employee.getCompany().getName());
	}
	@Override
	public String toString() {
		return "EmployeeDto [name=" + name + ", email=" + email + ", company=" + company + "]";
	}
	
	
}

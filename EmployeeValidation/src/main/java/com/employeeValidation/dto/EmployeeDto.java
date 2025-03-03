package com.employeeValidation.dto;

import com.employeeValidation.entity.Employee;

public class EmployeeDto {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String phoneNo;
	
	private Double salary;
	
	private CompanyDto company;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(String name, String email, String phoneNo, Double salary, CompanyDto company) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.salary = salary;
		this.company = company;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "EmployeeDto ["+ ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", salary="
				+ salary + ", company=" + company + "]";
	}
	
	// Entity to Dto conversion 
	public static EmployeeDto entityToDto(Employee employee) {
		
		return new EmployeeDto(employee.getName(),employee.geteMail(),employee.getPhoneNo(),employee.getSalary(),
				CompanyDto.entityToDto(employee.getCompany()));
	}
	
	//Dto To entity 
		public static Employee dtoToEntity(EmployeeDto employeeDto) {
			return new Employee(employeeDto.getName(),employeeDto.getEmail(),employeeDto.getPhoneNo(),employeeDto.getSalary(),
					null);
		}
	
}

package com.employeeValidation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="employee")
public class Employee {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name="e_mail")
	private String eMail;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name ="salary")
	private Double salary;
	
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinColumn(name="company_id")
	private Company company;

	public Employee() {
		super();
		
	}

	public Employee(String name, String eMail, String phoneNo, Double salary, Company company) {
		super();
		this.name = name;
		this.eMail = eMail;
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
	
}


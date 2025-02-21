package com.hibenateDemo3.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="project_name",unique = true)
	private String projectName;
	
	@OneToMany( cascade = {CascadeType.ALL},fetch = FetchType.EAGER,mappedBy = "projects" ,orphanRemoval = true)
	private List<Employee> employees = new ArrayList<>();

	public Project() {
		super();
		
	}

	public Project(String projectName, List<Employee> employees) {
		super();
		this.projectName = projectName;
		this.employees = employees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	
	
}

package com.hibenateDemo3.dto;



import java.util.List;

import com.hibenateDemo3.entity.Employee;
import com.hibenateDemo3.entity.Project;



public class ProjectDto {
	private String projectName;
	private List<Employee> employee;
	public ProjectDto() {
		super();
	}
	public ProjectDto(String projectName, List<Employee> employee) {
		super();
		this.projectName = projectName;
		this.employee = employee;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	// Dto to entity of project
	public static  Project dtoToEntity(ProjectDto projectDto) {
		return new Project(projectDto.getProjectName(), projectDto.getEmployee());
	}
	//Entity to Dto Of Project 
	public static  ProjectDto entityToDto(Project project) {
		return new ProjectDto(project.getProjectName(), project.getEmployees());
		
	}
	@Override
	public String toString() {
		return "ProjectDto [projectName=" + projectName + ", employee=" + employee + "]";
	}
	
		
	}
	
	


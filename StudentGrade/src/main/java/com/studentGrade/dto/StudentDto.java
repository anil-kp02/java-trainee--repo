package com.studentGrade.dto;

import com.studentGrade.entity.Student;

public class StudentDto {
	
	private String name;
	private String branch;
	private Boolean isActive;
	private Float marks;
	public StudentDto(String name, String branch, Boolean isActive, Float marks) {
		super();
		this.name = name;
		this.branch = branch;
		this.isActive = isActive;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Float getMarks() {
		return marks;
	}
	public void setMarks(Float marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "StudentDetails \n [name=" + name + "\n, branch=" + branch + "\n, isActive=" + isActive + "\n, marks=" + marks + "]";
	}
	
	//entity to dto 
	public static StudentDto toDto(Student student) {
		return new StudentDto(student.getName(),student.getBranch(),student.getIsActive(),
																		student.getMark().getMarks());
	}
	
	
	
	

}

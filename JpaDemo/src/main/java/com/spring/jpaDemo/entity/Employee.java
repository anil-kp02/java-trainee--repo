package com.spring.jpaDemo.entity;

import com.spring.jpaDemo.dto.EmployeeDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name="id")
	private Long id;
	
	@Column(name = "name")
	private String name ;
	
	@Column(name ="age")
	private Integer age;
	
	@Column(name="unique_uid")
	private String uniqueUserId;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(Long id, String name, Integer age, String uniqueUserId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.uniqueUserId = uniqueUserId;
	}


	public String getUniqueUserId() {
		return uniqueUserId;
	}


	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	//entity to dto 
	public EmployeeDto entityToDto() {
		
		return new EmployeeDto(this.id != null ? this.id : null , this.name != null ? this.name : null , this.age !=null ?this.age:null,
				this.uniqueUserId != null ? this.uniqueUserId:null, null);
    }
} 

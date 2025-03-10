package com.spring.jpaDemo.dto;

import java.util.List;

import com.spring.jpaDemo.entity.Employee;

public class EmployeeDto {
	
	private Long id;
	
	private String name;
	
	private Integer age;
	
	private String uniqueUserId;
	
	private List<AddressDto> addressDtos;

	public EmployeeDto() {
		super();
		
	}


	public EmployeeDto(Long id, String name, Integer age, String uniqueUserId, List<AddressDto> addressDtos) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.uniqueUserId = uniqueUserId;
		this.addressDtos = addressDtos;
	}



	public String getUniqueUserId() {
		return uniqueUserId;
	}



	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
	}



	public List<AddressDto> getAddressDtos() {
		return addressDtos;
	}



	public void setAddressDtos(List<AddressDto> addressDtos) {
		this.addressDtos = addressDtos;
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
	
	//dto to entity
	public Employee dtoToEntity() {
		return new Employee(this.id != null ? this.id : null , this.name != null ? this.name : null , this.age !=null ?this.age:null,
				this.uniqueUserId != null ? this.uniqueUserId:null);
	}
	
	
	

}

package com.spring.jpaDemo.dto;

import com.spring.jpaDemo.entity.Address;

public class AddressDto {
	
	private Long id;
	
	private String name;
	
	private Long employeeId;

	public AddressDto() {
		super();
	}

	public AddressDto(Long id, String name, Long employeeId) {
		super();
		this.id = id;
		this.name = name;
		this.employeeId = employeeId;
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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	//dto to entity
	public Address dtoToEntity() {
		
		return new Address(this.id != null?this.id:null, this.name != null?this.name:null, null);
	}
	
	

}

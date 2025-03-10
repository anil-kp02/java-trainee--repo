package com.spring.jpaDemo.entity;

import com.spring.jpaDemo.dto.AddressDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "emp_id")
	private Long employeeId;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long id, String name, Long employeeId) {
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
	
	
	//entity  to dto
	public AddressDto entityToDto() {
		return new AddressDto(this.id != null ?this.id:null, this.name != null ?this.name:null, 
				this.employeeId != null ? this.employeeId :null);
	}
	

}

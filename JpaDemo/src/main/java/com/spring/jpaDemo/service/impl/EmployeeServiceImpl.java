package com.spring.jpaDemo.service.impl;



import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpaDemo.dto.AddressDto;
import com.spring.jpaDemo.dto.EmployeeDto;
import com.spring.jpaDemo.entity.Address;
import com.spring.jpaDemo.entity.Employee;
import com.spring.jpaDemo.repository.AddressRepository;
import com.spring.jpaDemo.repository.EmployeeRepository;
import com.spring.jpaDemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		
		try {
			Employee employee = employeeDto.dtoToEntity();
			Employee employeeSave= employeeRepository.save(employee);
			employeeSave.setUniqueUserId(generateUniqueId(employeeSave.getId()));
			employeeRepository.save(employeeSave);
			
			if(employeeDto.getAddressDtos()==null || employeeDto.getAddressDtos().isEmpty()  ) {
				
			}else {
				employeeDto.getAddressDtos().stream().map(a->{
					Address address = a.dtoToEntity();
					address.setEmployeeId(employeeSave.getId());
					return address;
					})
				.forEach(a->addressRepository.save(a));
				}
			
			
			return employeeSave.entityToDto();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		try {
			Employee employee =employeeRepository.save(employeeDto.dtoToEntity());
			
			
			if(employeeDto.getAddressDtos() != null && !employeeDto.getAddressDtos().isEmpty()) {
				employeeDto.getAddressDtos().stream().map(a->{
					Address address = a.dtoToEntity();
					address.setEmployeeId(employeeDto.getId());
					return address;
					})
				.forEach(a->addressRepository.save(a));
			}
			List<AddressDto> addresses = addressRepository.findAllByEmployeeId(employee.getId()).stream().
					map(a->a.entityToDto()).collect(Collectors.toList());
			
			EmployeeDto  dto = employee.entityToDto();
			dto.setAddressDtos(addresses);
			
			
			
			return dto;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	
	private static String generateUniqueId(Long id) {
		
		String uidPrefix="WTB";
		String employeeId = String.format("%03d", id);
		
		return uidPrefix+employeeId;
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		
		try { 
			List<Employee>  employees = employeeRepository.findAll();
			
			List<Long> ids = employees.stream().filter(e->e != null && e.getId()!=null).
					map(e->e.getId()).collect(Collectors.toList());
			
			List<Address> addresses = addressRepository.findAllByEmployeeIdIn(ids);
			
			Map<Long, List<Address>> mapAddresses = addresses.stream().filter(a-> a !=null && a.getId()!= null)
					.collect(Collectors.groupingBy(e->e.getEmployeeId()));
			
			List<EmployeeDto> employeeDtos = employees.stream().filter(e-> e!=null).
					map(e-> {
						EmployeeDto dto= e.entityToDto();
					if(mapAddresses != null && !mapAddresses.isEmpty() && mapAddresses.containsKey(dto.getId())) {
							/*
							 * List<AddressDto> addressDtos =
							 * mapAddresses.get(dto.getId()).stream().map(a->a.entityToDto()).collect(
							 * Collectors.toList());
							 */
						
						dto.setAddressDtos(mapAddresses.get(dto.getId()).stream().map(a->a.entityToDto()).toList());
						
					}else {
						dto.setAddressDtos(Collections.emptyList());
					}
					return dto;
						
					}).collect(Collectors.toList());
			
			
			return employeeDtos;
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public boolean existsByName(String name) {
		
		Boolean flag = employeeRepository.existsByName(name); 
		
		return flag;
	}
	
	

}

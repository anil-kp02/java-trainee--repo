package com.spring.jpaDemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.jpaDemo.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {

	List<Address> findAllByEmployeeIdIn(List<Long> ids);

	List<Address> findAllByEmployeeId(Long id);

	

}

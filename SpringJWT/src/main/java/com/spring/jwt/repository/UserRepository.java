package com.spring.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jwt.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByName(String username);

}

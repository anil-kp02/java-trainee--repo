package com.spring.hateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.hateoas.entity.Product;

public interface ProductRepoSitory extends JpaRepository<Product, Long> {

}

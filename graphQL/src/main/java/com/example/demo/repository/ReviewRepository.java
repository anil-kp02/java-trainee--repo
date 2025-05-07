package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	@NativeQuery("select * from review  where book_id = :id")
	List<Review> findByBook(@Param("id") Long id);

}

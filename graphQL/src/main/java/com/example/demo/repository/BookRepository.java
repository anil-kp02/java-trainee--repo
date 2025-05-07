package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book save(Author author);

}

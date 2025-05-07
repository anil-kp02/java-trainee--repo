package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	public Author saveAuthor(String name) {
		Author author = new Author();
		author.setName(name);
		return authorRepository.save(author);
	}
	
	

}

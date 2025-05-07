package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Optional<Book> getBookById(Long id) {
		return bookRepository.findById(id);
	}

	public Book saveBook(String title, Long authorId) {
		Book book = new Book();
		book.setTitle(title);
		Author author = authorRepository.findById(authorId).orElse(null);
		book.setAuthor(author);
		return bookRepository.save(book);
	}

	public Author getBookByAuthorId(Long id) {
		
		
		return authorRepository.findById(id).orElse(null);
	}
}

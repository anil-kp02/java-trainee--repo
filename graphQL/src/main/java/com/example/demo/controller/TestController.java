//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.graphql.data.method.annotation.SchemaMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.test.Author;
//import com.example.demo.test.Book;
//
//@RestController
//public class TestController {
//	
//	
//	@QueryMapping
//	public List<Book> books(){
//		return Book.getAllbooks;
//	}
//	
//	@QueryMapping
//	public Book bookById(@Argument Integer id) {
//		return Book.getBookById(id);
//	}
//	
//	@SchemaMapping
//	public Author author(Book book) {
//		return Author.getAuthorById(book.authorId());
//	}
//	
//	@QueryMapping
//	public List<Author> authors(){
//		return Author.authors;
//	}
//
//}

package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Review;
import com.example.demo.service.BookService;
import com.example.demo.service.ReviewService;



@RestController
public class BookResolver {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private ReviewService reviewService;
	
	@QueryMapping
	public List<Book> books(){
		return bookService.getAllBooks();
	}
	
	@QueryMapping
	public Optional<Book> book(Long id) {
		return bookService.getBookById(id);
	}
	
	@SchemaMapping
	public Author author(Book book) {
		return bookService.getBookByAuthorId(book.getAuthor().getId());
		
	}
	@SchemaMapping
	public List<Review> reviews(Book book){
		return reviewService.getReviewsByBookId(book.getId());
		
	}
}

//{
//	  books{
//	    title
//	    author{
//	      name
//	    }
//	    reviews{
//	      comment
//	      
//	    }
//	    
//	  }    // sample of how to ad and  get result hrough graphql

//	}
//	mutation{
//	  addBook(title:"hloo",authorId:1)
//	  {
//	    id
//	  }
//	}

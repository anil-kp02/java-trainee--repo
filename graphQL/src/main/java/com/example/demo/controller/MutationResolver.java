package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Review;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.ReviewService;


@RestController
public class MutationResolver{
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	
	
	@MutationMapping
	public Review addReview(@Argument Long bookId,@Argument String comment ,@Argument int rating) {
		return reviewService.addReview(bookId, comment, rating);
	}
	
	  @MutationMapping
	    public Author addAuthor(@Argument String name) {
	        return authorService.saveAuthor(name);
	    }

	    @MutationMapping
	    public Book addBook(@Argument String title, @Argument Long authorId) {
	        return bookService.saveBook(title, authorId);
	    }

}

package com.example.demo.test;

import java.util.Arrays;
import java.util.List;

public record Book(Integer id,String name,Integer authorId) {
	
	public static List<Book> getAllbooks = Arrays.asList(new Book(1,"java",2),
			new Book(2, "Python",1),
			new Book(3, "Harry Potter",2));
	
	public static Book getBookById(Integer id) {
		return getAllbooks.stream().
				filter(b-> b.id == id).findFirst()
				.orElse(null);
	}


}

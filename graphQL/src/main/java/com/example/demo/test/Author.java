package com.example.demo.test;

import java.util.Arrays;
import java.util.List;

public record Author(Integer id, String name) {
	
	public static List<Author> authors = Arrays.asList(new Author(1, "John Snow"),
			new Author(2,"Bob Marly"),
			new Author(3, "Rabindra tagor"));
	
	public static Author getAuthorById(Integer id) {
		return authors.stream().
				filter(a->a.id ==id).findFirst()
				.orElse(null);
	}
}

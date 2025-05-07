package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;

	    @OneToMany(mappedBy = "author")
	    private List<Book> books = new ArrayList<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		public Author() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

}

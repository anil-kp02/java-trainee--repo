package com.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="e_mail")
	private String email;
	
	@Column(name ="score")
	private Float score;
	
	
	
	
	

	public User() {
		super();
		
	}

	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		this.score=null;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	

	
	
	

}

// the datas are random and the type is 
/*
 * create database quiz; use quiz; select * from user_answer; select * from
 * user_details; insert into questions(question)
 * values(" Who is the Father Of the nation ?"),("what is 2+2= ?"),
 * ("Ram is a --- boy?"); INSERT INTO questions (question) VALUES ('Who
 * developed the theory of relativity?'), ('What is the capital of France?'),
 * ('What is the boiling point of water in Celsius?'), ('Who was the first
 * President of the United States?'), ('What is the chemical symbol for gold?'),
 * ('Which element has the atomic number 1?');
 * 
 * select * from question_options; insert into
 * question_options(option_id,question_id) values
 * ("M.D gandhi",1),("Baxi ",1),("chakhi Khuntia",1),("Subhash ch. Bosh",1)
 * ,("4",2),("6",2),("9",2),("10",2),("bad",3),("Mad",3),("physco",3),("Good",3)
 * ; INSERT INTO question_options (option_id, question_id) VALUES ('George
 * Washington', 4), ('Thomas Jefferson', 4), ('Abraham Lincoln', 4), ('John
 * Adams', 4), ('Au', 5), ('Ag', 5), ('Cu', 5), ('Fe', 5), ('Hydrogen', 6),
 * ('Oxygen', 6), ('Helium', 3), ('Carbon', 6), ('Japan', 7), ('China', 7),
 * ('South Korea', 7), ('India', 7), ('Pacific Ocean', 8), ('Atlantic Ocean',
 * 8), ('Indian Ocean', 8), ('Arctic Ocean', 8), ('William Shakespeare', 9),
 * ('Charles Dickens', 9), ('J.K. Rowling', 9), ('Mark Twain', 9);
 * 
 * select * from question_answer; insert into question_answer
 * (correct_option,question_id) values (1,1),(5,2),(12,3); INSERT INTO
 * question_answer (correct_option, question_id) VALUES (28, 4), -- 'H2O' is the
 * correct answer for Question 4 (35, 5), -- 'Charles Babbage' is the correct
 * answer for Question 5 (37, 6), -- 'Mars' is the correct answer for Question 6
 * (42, 7), -- 'Japan' is the correct answer for Question 7 (44, 8), -- 'Pacific
 * Ocean' is the correct answer for Question 8 (48, 9); -- 'William Shakespeare'
 * is the correct answer for Question 9
 * 
 * rollback; desc question_answer; select * from question_options rollback;
 * delete from question_options where id>12;
 * 
 * 
 */
package com.quiz.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="questions")
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="question")
	private String question;
	
	
	@OneToMany(mappedBy = "questionId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Options> options;
	
	
	
	
	
	
	public Questions() {
		super();
	}

	public Questions(String question) {
		super();
		this.question = question;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Options>getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	
	
	
	
	
	
}

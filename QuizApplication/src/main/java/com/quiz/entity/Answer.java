package com.quiz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="question_answer")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne()
	@JoinColumn(name="question_id")
    private	Questions questionId;
    
	@OneToOne
	@JoinColumn(name="correct_option")
    private Options answer;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(Questions questionId, Options answer) {
		super();
		this.questionId = questionId;
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Questions getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Questions questionId) {
		this.questionId = questionId;
	}

	public Options getAnswer() {
		return answer;
	}

	public void setAnswer(Options answer) {
		this.answer = answer;
	}
	
	
}

package com.quiz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_answer")
public class UserAnswerMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name ="question_id")
	private Questions questionId;
	
	@OneToOne
	@JoinColumn(name ="option_id")
	private Options option;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User userId;

	public UserAnswerMapping() {
		super();
	}

	public UserAnswerMapping(Questions questionId, Options option) {
		super();
		this.questionId = questionId;
		this.option = option;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
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

	public Options getOption() {
		return option;
	}

	public void setOption(Options option) {
		this.option = option;
	}
	
	
	
	

}

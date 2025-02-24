package com.quiz.dto;

import com.quiz.dao.OptionDao;
import com.quiz.dao.QuestionDao;
import com.quiz.dao.UserDao;
import com.quiz.entity.Options;
import com.quiz.entity.Questions;
import com.quiz.entity.User;
import com.quiz.entity.UserAnswerMapping;

public class UserAnswerDto {
	
	private Integer questionId;
	
	private Integer optionId;
	
	private Long userId;

	public UserAnswerDto() {
		super();
	}

	
	
	public UserAnswerDto(Integer questionId, Integer optionId, Long userId) {
		super();
		this.questionId = questionId;
		this.optionId = optionId;
		this.userId = userId;
	}
	



	
	public Integer getQuestionId() {
		return questionId;
	}



	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}



	public Integer getOptionId() {
		return optionId;
	}



	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	//Dto to entity
	public static UserAnswerMapping dtoToEntity (UserAnswerDto userAnswerDto) {
		UserAnswerMapping userAnswerMapping = new UserAnswerMapping();
		Questions questions = new QuestionDao().getQuestionById(userAnswerDto.getQuestionId());
		Options options = new OptionDao().getOptionById(userAnswerDto.getOptionId());
		User user = new UserDao().getUser(userAnswerDto.getUserId());
		
		userAnswerMapping.setUserId(user);
		userAnswerMapping.setQuestionId(questions);
		userAnswerMapping.setOption(options);
		
		return userAnswerMapping;
		
	}
	
	
}

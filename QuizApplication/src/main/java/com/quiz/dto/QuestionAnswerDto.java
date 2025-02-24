package com.quiz.dto;

import java.util.List;

import com.quiz.entity.Options;
import com.quiz.entity.Questions;

public class QuestionAnswerDto {
	private Integer QuestionId;
	
	private String question;
	
	private List<Options> options;

	public QuestionAnswerDto() {
		super();
	}



	public QuestionAnswerDto(Integer questionId, String question, List<Options> options) {
		super();
		QuestionId = questionId;
		this.question = question;
		this.options = options;
	}



	public Integer getQuestionId() {
		return QuestionId;
	}

	public void setQuestionId(Integer questionId) {
		QuestionId = questionId;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}
	
	

/*	@Override
	public String toString() {
		return "QuestionAnswerDto [QuestionId=" + QuestionId + ",\n options=" + options + "]";
	*/
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public static QuestionAnswerDto entityToDto(Questions questions) {
		QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto();
		questionAnswerDto.setQuestionId(questions.getId());
		questionAnswerDto.setQuestion(questions.getQuestion());
		questionAnswerDto.setOptions(questions.getOptions());
		
		return questionAnswerDto;
	}
	
	
}

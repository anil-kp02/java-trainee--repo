package com.quiz.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import com.quiz.dao.QuestionDao;
import com.quiz.dao.UserAnswerDao;
import com.quiz.dto.QuestionAnswerDto;
import com.quiz.dto.UserAnswerDto;
import com.quiz.entity.Options;
import com.quiz.entity.Questions;
import com.quiz.entity.UserAnswerMapping;

public class QuestionAnswerAndResponseService {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	QuestionDao questionDao = new QuestionDao();
	UserAnswerMapping answerMapping = new UserAnswerMapping();

	public void displayQuestionsAndGetResponse(Long userId) {

		System.out.println(" Test starts ");
		List<Questions> questions = questionDao.getAllQuestion();
		List<QuestionAnswerDto> list = questions.stream().map(QuestionAnswerDto::entityToDto)
				.collect(Collectors.toList());

		for (QuestionAnswerDto questionAnswerDto : list) {
			System.out.println(
					" Question No : " + questionAnswerDto.getQuestionId() + "  " + questionAnswerDto.getQuestion());
			for (int i = 0; i < 4; i++) {
				System.out.println(i + 1 + " : " + questionAnswerDto.getOptions().get(i));
			}
			System.out.println("Enter the Correct option id of the Choosen Answer :");
			try {
				Integer id = Integer.parseInt(reader.readLine());
				if (id > 4) {
					System.out.println(" Option out of the range :");
				} else {
					Options option = questionAnswerDto.getOptions().get(id);
					Integer dbId = option.getId();
					UserAnswerDto answerDto = new UserAnswerDto(questionAnswerDto.getQuestionId(),dbId,userId);
					answerMapping = UserAnswerDto.dtoToEntity(answerDto);
					new UserAnswerDao().addUserResponse(answerMapping);

					System.out.println(" Answer submited");
				}
				

			} catch (Exception e) {
				System.out.println(" Error is : " + e.getMessage());
			}

		}

	}

}

package com.quiz.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.quiz.dao.UserAnswerDao;
import com.quiz.dao.UserDao;
import com.quiz.dto.UserDto;
import com.quiz.entity.User;

public class UserService {
	UserDao userDao = new UserDao();
	UserAnswerDao userAnswerDao = new UserAnswerDao();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	//Register a new User 
	public void addUser() {
		try {
			System.out.println(" Enter the User name : ");
			String name= reader.readLine();
			System.out.println(" Enter the E - mail : ");
			String email = reader.readLine();
			
			UserDto userDto = new UserDto(name, email);
			User user = UserDto.dtoToEntity(userDto);
			
			userDao.addUser(user);
			System.out.println(" User Added SucessFully ...");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//To see the user 
	public void getUser() {
		try {
			System.out.println(" Enter the User Id : ");
			Long id = Long.parseLong(reader.readLine());
			
			User user = userDao.getUser(id);
			if(user == null) {
				System.out.println(" No user In this Id ");
			}
			else {
				UserDto userDto = UserDto.entityToDto(user);
				System.out.println(" Name : "+userDto.getName() +"\n E-mail : "+userDto.getEmail());
				if(userDto.getScore() != null) {
					System.out.println(" Test Completed ");
				}
				else {
					System.out.println(" Test pending  ");
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Get Marks 
	public void getScore() {
		try {
			System.out.println(" Enter the User Id : ");
			Long id = Long.parseLong(reader.readLine());
			
			User user = userDao.getUser(id);
			if(user == null) {
				System.out.println(" No user In this Id ");
			}
			else {
				UserDto userDto = UserDto.entityToDto(user);
				System.out.println(" Name : "+userDto.getName() +"\n E-mail : "+userDto.getEmail());
				if(user.getScore() == null) {
					Float mark= userAnswerDao.calculateScore(id);
					System.out.println(" Scored : -> " +mark);
				}
				else {
					System.out.println(" Test pending  ");
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//start test 
	public void startTest() {
		try {
			System.out.println(" Enter the User Id for test : ");
			Long id = Long.parseLong(reader.readLine());
			User user = userDao.getUser(id);
			if(user == null) {
				System.out.println(" No user In this Id ");
			}
			else {
				new QuestionAnswerAndResponseService().displayQuestionsAndGetResponse(id);
				System.out.println(" Test is Over ");
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
	}
	public void calculatetest() {
		
	}
	
}


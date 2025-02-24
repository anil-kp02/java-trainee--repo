package com.quiz.dto;

import com.quiz.entity.User;

public class UserDto {
	
	private String name;
	
	private String email;
	
	private Float score;

	public UserDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public UserDto() {
		super();
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

	//Dto to entity Conversion 
	public static User dtoToEntity(UserDto userDto) {
		return new User(userDto.getName(), userDto.getEmail());
	}
	
	//Entity To Dto Conversion 
	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setScore(user.getScore());
		 
		return userDto;
	}

	@Override
	public String toString() {
		return "UserDEtails [name=" + name + ", email=" + email + ", score=" + score + "]";
	}
	
	
}

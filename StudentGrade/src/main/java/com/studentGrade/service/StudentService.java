package com.studentGrade.service;

import java.util.List;
import java.util.stream.Collectors;


import com.studentGrade.dto.StudentDto;
import com.studentGrade.resources.StudentDao;

public class StudentService {
	
	
	//Student grade wise retrieval 
	public static List<StudentDto> getStudentByGrade(String grade){
		List<StudentDto> resultSet= null;
		List<StudentDto> listOfAll= StudentDao.viewAllStudent();
		if(grade.equalsIgnoreCase("very good")) {
			resultSet= listOfAll.stream().filter(student-> student.getMarks()>=80.0).collect(Collectors.toList());
		}
		else if(grade.equalsIgnoreCase("good")) {
			resultSet= listOfAll.stream().filter(student-> student.getMarks()<80.0 && student.getMarks()>=60).collect(Collectors.toList());
		}
		else if(grade.equalsIgnoreCase("Average")) {
			resultSet= listOfAll.stream().filter(student-> student.getMarks()<60.0 && student.getMarks()>=33).collect(Collectors.toList());
		}
		else if(grade.equalsIgnoreCase("fail")) {
			resultSet=  listOfAll.stream().filter(student-> student.getMarks()<33).collect(Collectors.toList());
		}
		
		
		return resultSet;
	}

}

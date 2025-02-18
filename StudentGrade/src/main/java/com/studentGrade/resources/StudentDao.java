package com.studentGrade.resources;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.studentGrade.dto.StudentDto;
import com.studentGrade.entity.Marks;
import com.studentGrade.entity.Student;

public class StudentDao {

	// to add a student
	public static void addStudent(StudentDto studentDto) {
		Session session = ConnectionProvider.getFactory().openSession();
		
		Marks markOfStudent= new Marks(studentDto.getMarks());
		Student student= new Student(studentDto.getName(),studentDto.getBranch(), studentDto.getIsActive(),markOfStudent);
		Transaction transaction=session.beginTransaction();
		session.save(student);
		session.save(markOfStudent);
		transaction.commit();
		session.close();
		
	}
	
	// view all students 
	public static List<StudentDto> viewAllStudent() {
		Session session = ConnectionProvider.getFactory().openSession();
		
		List<Student> list= session.createQuery("From Student where isActive=true",Student.class).list();
		
		List<StudentDto> allStudents= new ArrayList<>();
		
		list.stream().forEach(student-> allStudents.add(StudentDto.toDto(student)));
		session.close();
		
		return allStudents;
	}
	
	// view student by id 
	public static StudentDto getStudentById(Integer id ) {
		Session session = ConnectionProvider.getFactory().openSession();
		Student student= (Student)session.get(Student.class, id);
		if(student.getIsActive()==true) {
			return new StudentDto(student.getName(),student.getBranch(),student.getIsActive(),student.getMark().getMarks());
		}
		
		return null;
	}
	// update Student
	 public static String update(Integer id, Float mark) {
		 Session session = ConnectionProvider.getFactory().openSession();
		 Transaction transaction = session.beginTransaction();
		 Marks studentMark= (Marks)session.get(Marks.class, id);
		 if(studentMark==null) {
			 transaction.commit();
			 session.close();
			 return "Student Doesn't exist ";
			 
		 }
		 else {
			 studentMark.setMarks(mark);
			 transaction.commit();
			 session.close();
			 return "updated";
		 }
		 
	 }
	 // to dlete student 
	 public static String deleteStudent(Integer id) {
		 Session session = ConnectionProvider.getFactory().openSession();
		 Student student= (Student)session.get(Student.class,id);
		 if(student==null) {
			 session.close();
			 return "  no Student in this id ";
		 }
		 else {
			 Transaction transaction = session.beginTransaction();
			 student.setIsActive(false);
			 transaction.commit();
			 session.close();
			 return " deleted Succesfully ";
		 }
	 }
}

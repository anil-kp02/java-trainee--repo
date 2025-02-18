package com.assn_9.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.assn_9.entity.StudentHiber;
import com.assn_9.resources.ConnectionProvider;

public class StudentOperations {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static SessionFactory factory = ConnectionProvider.getFactory();

	public static void insert() throws IOException, SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException {

		StudentHiber student = new StudentHiber();

		System.out.println(" Enter the first name : ");
		student.setF_name(br.readLine());

		System.out.println(" Enter middle name : ");
		student.setM_name(br.readLine());

		System.out.println(" Enter Last Name : ");
		student.setL_name(br.readLine());

		System.out.println(" Enter branch : ");
		student.setBranch(br.readLine());

		System.out.println(" Enter sex of the Student : ");
		student.setSex(br.readLine());

		System.out.println(" Enter addres of the student : ");
		student.setAddrs(br.readLine());

		System.out.println(" Enter hobby : ");
		student.setHobby(br.readLine());

		Session session = factory.openSession();
		
		 Transaction beginTransaction = session.beginTransaction();
//		Transaction tx = session.beginTransaction();
		session.save(student);
		System.out.println(" Student added successFully");
		beginTransaction.commit();
		session.close();

	}

	// get all data of student
	public static void getAll() {
		Session session = factory.openSession();
		Query allStd = session.createQuery("from StudentHiber");
		List<StudentHiber> list = allStd.getResultList();

		// print all
		System.out.println(list);

		session.close();

	}

	// get by id of a student
	public static void getById() throws NumberFormatException, IOException {
		Session session = factory.openSession();

		System.out.println(" Enter the id of the student You want to retrive : ");
		StudentHiber std = (StudentHiber) session.get(StudentHiber.class, Integer.parseInt(br.readLine()));
		if (std == null) {
			System.out.println(" No student exist in this id !!!");
		} else {
			System.out.println(std);
		}

		session.close();
	}

	// update by id
	public static void updateById() throws NumberFormatException, IOException {
		Session session = factory.openSession();

		System.out.println(" Enter the id of the student : ");
		StudentHiber std = (StudentHiber) session.get(StudentHiber.class, Integer.parseInt(br.readLine()));

		if (std == null) {
			System.out.println(" no student in this id !!!");
		} else {

			org.hibernate.Transaction tx = session.beginTransaction();
			System.out.println(" What do you want to update : \n | 1: first name | \n"
					+ "| 2: middele name | \n | 3: last name | \n| 4: branch | \n"
					+ "| 5: sex | \n | 6: Addresss | \n | 7: Hobby | \n");
			int selection = Integer.parseInt(br.readLine());

			if (selection == 1) {
				System.out.println(" Enter the updated value :");
				std.setF_name(br.readLine());
			} else if (selection == 2) {
				System.out.println(" Enter the updated value :");
				std.setM_name(br.readLine());
			} else if (selection == 3) {
				System.out.println(" Enter the updated value :");
				std.setL_name(br.readLine());
			} else if (selection == 4) {
				System.out.println(" Enter the updated value :");
				std.setBranch(br.readLine());
			} else if (selection == 5) {
				System.out.println(" Enter the updated value :");
				std.setBranch(br.readLine());
			} else if (selection == 6) {
				System.out.println(" Enter the updated value :");
				std.setAddrs(br.readLine());
			} else if (selection == 7) {
				System.out.println(" Enter the updated value :");
				std.setHobby(br.readLine());
			} else {
				System.out.println(" invalid input ");
			}

			tx.commit();
		}
		session.close();
	}

	// delete by id
	public static void deleteById() throws NumberFormatException, IOException {
		Session session = factory.openSession();
		System.out.println(" Enter the id of the student : ");
		StudentHiber std = (StudentHiber) session.get(StudentHiber.class, Integer.parseInt(br.readLine()));
		if (std == null) {
			System.out.println(" No student in  this id !!!!");
		}
		org.hibernate.Transaction tx = session.beginTransaction();
		if (std != null) {
			session.delete(std);
			System.out.println(std.getF_name() + "  is deleted");
		}
		tx.commit();
		session.close();

	}

}

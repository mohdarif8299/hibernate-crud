package com.hibernate.jdbc.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// beginning the transaction
			System.out.println("Starting the transaction...");
			session.beginTransaction();

			// select all query

			List<Student> students = session.createQuery("from Student").getResultList();

			System.out.println("SELECT * FROM STUDENT");
			displayStudent(students);

			System.out.println("LIKE QUERY");

			List<Student> student1 = session.createQuery("from Student s  where s.email LIKE '%8299@gmail.com' ")
					.getResultList();

			displayStudent(student1);

			System.out.println("Retrieving all Students");

			// committing transationF
			session.getTransaction().commit();

			System.out.println("Done...");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	public static void displayStudent(List<Student> students) {

		for (Student student : students) {
			System.out.println("Student ID = " + student.getId());
			System.out.println("Student Frist Name = " + student.getFirstName());
			System.out.println("Student Last name = " + student.getLastName());
			System.out.println("Student Email = " + student.getEmail());
		}

	}

}

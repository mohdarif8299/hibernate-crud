package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// starting the transaction
			System.out.println("Starting the transaction");

			// session.beginTransaction();

			// creating Java Object
//			int studentId = 3;
//			System.out.println("Getting Java Object with Student ID = " + studentId);
//
//			// updating the student property
//
//			System.out.println("Deleting Student with ID  = " + studentId);
//
//			Student student = session.get(Student.class, studentId);
//			session.delete(student);
//			System.out.println("Displaying updated values");
//			System.out.println(student);
//
//			// committing to the database
//			System.out.println("Committing to the database");
//
//			session.getTransaction().commit();

			// new code
			System.out.println("deleting using HQL  email ID");
			// session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete Student  where email = 'support@sixspringbytes.com' ").executeUpdate();
			session.getTransaction().commit();

			System.out.println("Deletion using Email Completed");

			System.out.println("Deleting Done...");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}

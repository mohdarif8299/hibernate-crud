package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// creating Java Object
			System.out.println("Creating Java Object....");
			Student student = new Student("mohd", "arif", "mohdarif8299@gmail.com");

			// beginning the transaction
			System.out.println("Starting the transaction...");
			session.beginTransaction();

			// saving the object ,persisting to database
			System.out.println("Saving to the databse");
			session.save(student);

			// committing to the database
			System.out.println("Committing to the database");
			session.getTransaction().commit();
			
			System.out.println("Done...");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}

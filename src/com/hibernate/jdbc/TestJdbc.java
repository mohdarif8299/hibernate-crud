package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String username = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to Database : " + jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection Successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

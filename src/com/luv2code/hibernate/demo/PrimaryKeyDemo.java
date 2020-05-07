package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
//				.buildSessionFactory();

		// create session
//		Session session = factory.getCurrentSession();

		try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory()) {
    		Session session = factory.getCurrentSession();
			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("Ivan", "Ivanov", "ivan@luv2code.com",DateUtils.parseDate("01/12/1999"));
			Student tempStudent2 = new Student("Petr", "Petrov", "petr@luv2code.com",DateUtils.parseDate("01/02/1999"));
			Student tempStudent3 = new Student("Elena", "Pretty", "elena@luv2code.com",DateUtils.parseDate("01/01/2000"));

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
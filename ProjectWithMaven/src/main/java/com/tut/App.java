package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// connection one type it contains sesssion
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// creating student
		Student st = new Student();
		st.setId(102);
		st.setName("PARVEZ");
		st.setCity("NEW YORK");
		System.out.println(st);
		Session session = factory.openSession();
		//
		Transaction tx = session.beginTransaction();
		session.save(st);
		tx.commit();
		session.close();
	}
}

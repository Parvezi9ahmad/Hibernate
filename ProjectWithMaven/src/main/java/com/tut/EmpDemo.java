package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Student student1 = new Student();
		student1.setId(14134);
		student1.setName("Alex");
		student1.setCity("NewYork");

		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Android");
		certificate1.setDuration("2 months");

		student1.setCerti(certificate1);

		Student student2 = new Student();
		student2.setId(1212);
		student2.setName("smith");
		student2.setCity("Sydney");

		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Hibernate");
		certificate2.setDuration("1.5 months");

		student2.setCerti(certificate2);

		Transaction tx = session.beginTransaction();
		session.save(student1);
		session.save(student2);
		tx.commit();

		session.close();
		factory.close();
	}
}

package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		// Student student = session.get(Student.class, 101);
		Student student = session.load(Student.class, 102);
		System.out.println(student);

		Address ad = session.get(Address.class, 2);
		System.out.println(ad);
		System.out.println(ad.getStreet() + "    " + ad.getCity());

		session.close();
		factory.close();
	}

}

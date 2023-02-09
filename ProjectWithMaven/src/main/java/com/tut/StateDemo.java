package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {

		// Transient
		// persistent
		// detached
		// Remove

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Student s = new Student();
		s.setId(26);
		s.setName("name 26");
		s.setCity("city 26");
		s.setCerti(new Certificate("java hibernate course 26", "26 month"));
		// student:transient

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		// student:persistent-session,database
		//s.setName("john");
		tx.commit();

		System.out.println(s);

		session.close();
		factory.close();
	}

}

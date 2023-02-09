package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		// be default enabled
		Student student = session.get(Student.class, 1417);
		System.out.println(student);
		System.out.println("working something..");
		Student student2 = session.get(Student.class, 1417);
		System.out.println(student2);
		System.out.println(session.contains(student2));
		session.close();
		factory.close();

	}

}

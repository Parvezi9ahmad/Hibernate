package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLPagination {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("from Student");

		// implementing pagination
		query.setFirstResult(0);
		query.setMaxResults(5);

		List<Student> list = query.list();
		list.forEach(p -> {
			System.out.println(p.getId() + "  " + p.getName() + "   " + p.getCity());
		});

		session.close();
		factory.close();
	}
}

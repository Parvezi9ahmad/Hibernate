package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		// can add restriction
		Criteria c = session.createCriteria(Student.class);
		// use of equal to method
		// c.add(Restrictions.eq("certi.course", "android"));

		// use to fetch record greater than record
		// c.add(Restrictions.gt("id", 10));

		c.add(Restrictions.like("certi.course", "java%"));
		List<Student> list = c.list();
		list.forEach(s -> {
			System.out.println(s);
		});

		session.close();
		factory.close();
	}
}

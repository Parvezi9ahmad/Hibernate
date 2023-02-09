package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SqlExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();

		String q = "select * from student";
		NativeQuery nq = s.createSQLQuery(q);
		List<Object[]> list = nq.list();
		list.forEach(p -> {
			// System.out.println(Arrays.toString(p));
			System.out.println(p[4] + "    :    " + p[3]);
		});
		s.close();
		
		factory.close();
	}
}

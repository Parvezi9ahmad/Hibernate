package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import com.tut.Student;

public class HQLExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();

		// HQL
		// Syntax

		String query = "from Student as s where s.city=:x and s.name=:n";
		Query q = s.createQuery(query);
		q.setParameter("x", "ABC");
		q.setParameter("n", "john");

		// single-unique // multipl
		List<Student> list = q.list();
		list.forEach(student -> {
			System.out.println(student.getName() + "   " + student.getCerti().getCourse());
		});

		System.out.println(".............................");
		Transaction tx = s.beginTransaction();
		// delete query
		/*
		 * Query q2 = s.createQuery("delete from Student where city=:c");
		 * q2.setParameter("c", "Sydney"); int result = q2.executeUpdate();
		 * System.out.println("Data Deleted"); System.out.println(result);
		 */

		// update query
		Query q2 = s.createQuery("update from Student set city=:c where name=:n");
		q2.setParameter("c", "Delhi");
		q2.setParameter("n", "john");
		int result = q2.executeUpdate();
		System.out.println(result + "  updated result ");
		tx.commit();

		// how to execute join query
		Query q3 = s.createQuery("select q.questionId,q.question,a.answer from Question q INNER JOIN q.answers a");
		List<Object[]> resultList = q3.getResultList();
		/*
		 * for (Object[] arr : resultList) { System.out.println(Arrays.toString(arr)); }
		 */
		resultList.forEach(p -> {
			System.out.println(Arrays.toString(p));
		});
		s.close();
		factory.close();
	}

}

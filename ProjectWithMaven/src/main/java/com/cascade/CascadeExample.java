package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.Answer;
import com.mapping.Question;

public class CascadeExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Question q1 = new Question();
		q1.setQuestionId(569L);
		q1.setQuestion("what is Linux ...");

		Answer a1 = new Answer(23424L, "operating system");
		a1.setQ(q1);
		Answer a2 = new Answer(256L, "second answer");
		a2.setQ(q1);
		Answer a3 = new Answer(36L, "third answer");
		a3.setQ(q1);
		List<Answer> list = new ArrayList();
		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswers(list);
		

		Transaction tx = session.beginTransaction();
		session.save(q1);
		/*
		 * session.save(a1); session.save(a2); session.save(a3);
		 */
		tx.commit();

		session.close();
		factory.close();
	}
}

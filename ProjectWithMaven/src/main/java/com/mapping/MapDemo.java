package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Question question1 = new Question(); //
		question1.setQuestionId(1L);
		question1.setQuestion("What is java");

		Answer answer1 = new Answer();
		answer1.setAnswerid(3L);
		answer1.setAnswer("Java is a programming language");
		answer1.setQ(question1);

		question1.setAnswer(answer1);

		Question question2 = new Question();
		question2.setQuestionId(2L);
		question2.setQuestion("What is Collection");

		Answer answer2 = new Answer(); //
		answer2.setAnswerid(4L);
		answer2.setAnswer("API to work with java");
		question2.setAnswer(answer2);
		answer2.setQ(question2);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(question1);
		session.save(answer1);
		session.save(question2);
		session.save(answer2);
		tx.commit();

		Question q1 = session.get(Question.class, 1L);
		System.out.println(q1.getQuestion());
		System.out.println(q1.getAnswer().getAnswer());
		
		Answer a1 = session.get(Answer.class, 3L);
		System.out.println(a1.getAnswer());
		System.out.println(a1.getQ().getQuestion());
		session.close();
		factory.close();
	}

}

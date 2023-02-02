package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		/*
		 * Question question1 = new Question(); // question1.setQuestionId(1L);
		 * question1.setQuestion("What is java");
		 * 
		 * Answer answer1 = new Answer(); answer1.setAnswerid(3L);
		 * answer1.setAnswer("Java is a programming language"); answer1.setQ(question1);
		 * 
		 * Answer answer2 = new Answer(); // answer2.setAnswerid(4L);
		 * answer2.setAnswer("API to work with java"); answer2.setQ(question1);
		 * 
		 * Answer answer3 = new Answer(); answer3.setAnswerid(5L);
		 * answer3.setAnswer("Has many framework to develope the application");
		 * answer3.setQ(question1);
		 * 
		 * List<Answer> ans = new ArrayList(); ans.add(answer1); ans.add(answer2);
		 * ans.add(answer3);
		 * 
		 * question1.setAnswers(ans);
		 */
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * session.save(question1); session.save(answer1); session.save(answer2);
		 * session.save(answer3);
		 */
		tx.commit();

		/*
		 * Question questions =(Question) session.get(Question.class, 1L);
		 * System.out.println(questions.getQuestion());
		 * 
		 * for (Answer a : questions.getAnswers()) {
		 * System.out.println(a.getAnswer().toString()); System.out.println(a.getQ()); }
		 */

		Answer answer = session.get(Answer.class, 3L);
		System.out.println(answer.getAnswer());
		session.close();
		factory.close();
	}

}

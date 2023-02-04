package com.mapping1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo1 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Emp emp = new Emp();
		emp.setEid(1);
		emp.setName("James");

		Emp emp1 = new Emp();
		emp1.setEid(2);
		emp1.setName("scott");

		Project p1 = new Project();
		p1.setPid(1212);
		p1.setProjectname("Library management System");

		Project p2 = new Project();
		p2.setPid(3232);
		p2.setProjectname("chatbot");

		List<Project> list1 = new ArrayList<>();
		list1.add(p1);
		list1.add(p2);

		List<Emp> list2 = new ArrayList<>();
		list2.add(emp);
		list2.add(emp1);

		emp.setProjects(list1);
		emp1.setProjects(list1);
		p2.setEmp(list2);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		session.save(emp1);
		session.save(p1);
		session.save(p2);
		tx.commit();
		session.close();
		factory.close();

	}

}

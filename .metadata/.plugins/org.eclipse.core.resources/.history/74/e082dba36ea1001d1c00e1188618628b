package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		// connection one type it contains sesssion
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// creating student
		Student st = new Student();
		st.setId(102);
		st.setName("PARVEZ");
		st.setCity("NEW YORK");
		System.out.println(st);

		// creating the object of address class
		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("DELHI");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.234);

		// reading image
		FileInputStream fis = new FileInputStream("src/main/java/images.jpeg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done....");
	}
}

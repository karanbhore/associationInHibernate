package com.prowings.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.onetoone.entity.Address;
import com.prowings.onetoone.entity.Student;

public class TestOneToOneFetch {

	public static void main(String[] args) {

		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();

		Student fetchedStd = session.get(Student.class, 1);

		System.out.println(fetchedStd);

		txn.commit();
		session.close();

	}

}
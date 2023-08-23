package com.prowings.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.onetoone.entity.Address;
import com.prowings.onetoone.entity.Student;

public class TestOneToOneAssociationDelete {

	public static void main(String[] args) {

		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();

		Student s1 = new Student();
		s1.setId(1);

//		session.delete(s1);
		session.remove(s1);

		System.out.println("s1 deleted successfully");
		txn.commit();
		session.close();

	}

}
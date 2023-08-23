package com.prowings.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.onetoone.entity.Address;
import com.prowings.onetoone.entity.Student;

public class TestOneToOneAssociation {
	
	public static void main(String[] args) {
		
		Address add = new Address(123, "Pune", "India");
		
		Student s1 = new Student(10, "Ram", add);
		
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		
		session.save(s1);
		
		System.out.println("==========================");
		
		Student fetchedStd = session.get(Student.class, 1);
		
		System.out.println(fetchedStd);
		
		
		txn.commit();
		session.close();

		
	}

}
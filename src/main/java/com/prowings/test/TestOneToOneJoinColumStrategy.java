package com.prowings.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.onetoone.entity.Account;
import com.prowings.onetoone.entity.Employee;

public class TestOneToOneJoinColumStrategy {

	public static void main(String[] args) {

		Account account = new Account();
		account.setAccountNumber("123-345-65454");

		// Add new Employee object
		Employee emp = new Employee();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");

		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();

		// Save Account
		session.persist(account);

		// Save Employee
		emp.setAccount(account);
		session.persist(emp);

		txn.commit();
	}
}
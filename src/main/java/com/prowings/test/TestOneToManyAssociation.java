package com.prowings.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.onetomany.entity.AccountOM;
import com.prowings.onetomany.entity.EmployeeOM;
import com.prowings.onetoone.entity.Address;
import com.prowings.onetoone.entity.Student;

public class TestOneToManyAssociation {

	public static void main(String[] args) {

		AccountOM acc1 = new AccountOM();
		acc1.setAccountId(1);
		acc1.setAccountNumber("abc123pqr");

		AccountOM acc2 = new AccountOM();
		acc2.setAccountId(2);
		acc2.setAccountNumber("jkl345qwe");

		AccountOM acc3 = new AccountOM();
		acc3.setAccountId(3);
		acc3.setAccountNumber("xyz789abc");

		Set<AccountOM> accounts = new HashSet<AccountOM>();
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);

		EmployeeOM emp = new EmployeeOM();
		emp.setEmployeeId(1);
		emp.setFirstName("Ram");
		emp.setLastName("Prabhu");
		emp.setEmail("ram.p@prowings.com");
		emp.setAccounts(accounts);

		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg_onetomany.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();

		session.save(emp);
//		session.remove(emp);

//		EmployeeOM e = session.get(EmployeeOM.class, 1);
//		session.delete(e);

		AccountOM ac1 = session.get(AccountOM.class, 1);
		AccountOM ac2 = session.get(AccountOM.class, 2);
		AccountOM ac3 = session.get(AccountOM.class, 3);

		System.out.println(ac1);
		System.out.println(ac2);
		System.out.println(ac3);
		
//		session.delete(ac1);
//		session.delete(ac2);
//		session.delete(ac3);

		System.out.println("==========================");

		txn.commit();
		session.close();

	}
}
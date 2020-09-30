package com.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		// 1. create the configuration object
		Configuration cfg = new Configuration();
		
		// 2. load the configuration file
		cfg.configure();
		
		// 3. Build the session factory
		SessionFactory sf = cfg.buildSessionFactory();
		
		// 4. Open The session
		Session ses = sf.openSession();
		
		// 5. begin the transaction
		Transaction tx = ses.beginTransaction();
		
		// 6. perform the operation
		Student s = new Student();
		s.setNo(101);
		s.setName("atif");
		s.setAge(24);
		
		ses.save(s);
		// 7. commit the transaction
		tx.commit();
		
		// 8. close the transaction
		
		ses.close();
	}
}

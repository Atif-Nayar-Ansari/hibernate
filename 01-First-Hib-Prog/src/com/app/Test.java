package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		//create the configuration object
		Configuration cfg = new Configuration();

		//load the configuration file
		cfg.configure();
		
		//create sessionFactory object
		SessionFactory sf = cfg.buildSessionFactory();
		
		//open session
		Session ses = sf.openSession();
		
		//start transaction
		Transaction tx = ses.beginTransaction();
		
		//perform operation
		Student s = new Student();
		s.setId(2);
		s.setName("A");
		s.setFee(3000);
		s.setAge(24);
		
		//save object
		ses.save(s);
		
		//commit the transaction
		tx.commit();
		
		//close session
		ses.close();
	}
}

package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		
		Transaction tx = null;
		try(Session ses = HibernateUtil.getSf().openSession()){
			
			tx = ses.beginTransaction();
			Student s = new Student();
			s.setId(5);
			s.setName("Atif");
			s.setAge(25);
			
			ses.save(s);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

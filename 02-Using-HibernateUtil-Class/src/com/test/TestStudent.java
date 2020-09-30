package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.Student;
import com.util.HibernateUtil;

public class TestStudent {

	public static void main(String[] args) {
		
		Transaction tx = null;
		try(Session ses = HibernateUtil.getSf().openSession()){
			
			tx = ses.beginTransaction();
			
			Student s = new Student();
			s.setId(2);
			s.setName("Atif");
			s.setAge(24);
			
			ses.save(s);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}

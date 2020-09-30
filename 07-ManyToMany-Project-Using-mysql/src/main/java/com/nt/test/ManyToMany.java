package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Course;
import com.nt.entity.Student;
import com.nt.util.HibernateUtil;

public class ManyToMany {

	public static void main(String[] args) {
		
		Transaction tx = null;
		try(Session ses = HibernateUtil.getSf().openSession()) {
			
			tx = ses.beginTransaction();
			 
			Course c1 = new Course();
			c1.setCid(1);
			c1.setCname("java");
			c1.setFees(400.4);
			
			
			Course c2 = new Course();
			c2.setCid(2);
			c2.setCname("Boot");
			c2.setFees(500.5);
			
		
			Course c3 = new Course();
			c3.setCid(3);
			c3.setCname("rest");
			c3.setFees(700.7);
			
			
			Student s1 = new Student();
			s1.setSid(101);
			s1.setName("Atif");
			s1.getCourse().add(c1);   //s1 taken two courses
			s1.getCourse().add(c2);
			
			
			Student s2 = new Student();
			s2.setSid(102);
			s2.setName("Rajesh");
			s2.getCourse().add(c3);   //s2 taken one course
			
			Student s3 = new Student();
			s3.setSid(103);
			s3.setName("Salena");
			s3.getCourse().add(c1);   //s3 takes all 3  courses
			s3.getCourse().add(c2);
			s3.getCourse().add(c3);
			
			ses.save(c1);
			ses.save(c2);
			ses.save(c3);
			
			ses.save(s1);
			ses.save(s2);
			ses.save(s3);
			         
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

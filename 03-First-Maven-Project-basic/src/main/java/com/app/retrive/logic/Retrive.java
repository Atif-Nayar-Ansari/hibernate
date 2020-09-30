package com.app.retrive.logic;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Student;
import com.app.util.HibernateUtil;

public class Retrive {

	public static void main(String[] args) {
		Transaction tx = null;
		
		try(Session ses = HibernateUtil.getSf().openSession()) {
			
			String hql = "from Student";
			Query  q = ses.createQuery(hql);
			
			List<Student> stud = q.list();
			stud.forEach(System.out::println);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

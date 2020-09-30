package com.app.update.logic;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.util.HibernateUtil;

public class UpdateData {

	public static void main(String[] args) {
		Transaction tx = null;
		
		try(Session ses = HibernateUtil.getSf().openSession()) {
			
			tx = ses.beginTransaction();
			String hql = "update com.app.model.Student set name= :n where id= :c";
		    
			Query q = ses.createQuery(hql);
			
			q.setParameter("n","nayar");
			q.setParameter("c",4);
			
			//to execute the query
			int  count = q.executeUpdate();
			tx.commit();
			System.out.println(count);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

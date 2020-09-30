package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Loan;
import com.nt.util.HibernateUtil;

public class OneToMany {

	public static void main(String[] args) {

		Transaction tx = null;
		try(Session ses = HibernateUtil.getSf().openSession()) {
			
			tx = ses.beginTransaction();
			
			
			Loan loan1 = new Loan();
			loan1.setLoanId(101);
			loan1.setLoanType("Car loan");
			loan1.setAmount(5000.0);
			
			Loan loan2 = new Loan();
			loan2.setLoanId(102);
			loan2.setLoanType("Home loan");
			loan2.setAmount(7000.0);
			
			Loan loan3= new Loan();
			loan3.setLoanId(103);
			loan3.setLoanType("Marriage loan");
			loan3.setAmount(8000.0);
			
			//customer one
			Customer cust1 = new Customer();
			cust1.setCustomerId(1);
			cust1.setCustomerName("Tayllor");
			cust1.getLoan().add(loan1);
			cust1.getLoan().add(loan2);  //here one can have multiple loan
			cust1.getLoan().add(loan3);
			
			//first all loans need to be saved then the cust will be saved
			ses.save(loan1);
			ses.save(loan2);
			ses.save(loan3);
			
			
			ses.save(cust1);
			         
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

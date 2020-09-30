package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Loan;
import com.nt.util.HibernateUtil;

public class TestOneToOne {

	public static void main(String[] args) {

		Transaction tx = null;
		try(Session ses = HibernateUtil.getSf().openSession()) {
			
			 tx = ses.beginTransaction();
			
			//one loan can be have only one person
			Loan loan = new Loan();
			loan.setLoanId(101);
			loan.setLoanType("Car loan");
			loan.setAmount(5000.0);
			
			
			//customer one
			Customer cust1 = new Customer();
			cust1.setCustomerId(1);
			cust1.setCustomerName("Tayllor");
			cust1.setLoan(loan); 
			                                   //here only one customer can have the only one loan
			         
			//customer two
			Customer cust2 = new Customer();
			cust2.setCustomerId(2);
			cust2.setCustomerName("Laura");
			//cust2.setLoan(loan); if we write this line then it will provide the exception
			//here laura can not have the same loan here
			
			
			ses.save(loan); //first loan need to be saved then other 
			ses.save(cust1);
			ses.save(cust2);
			
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

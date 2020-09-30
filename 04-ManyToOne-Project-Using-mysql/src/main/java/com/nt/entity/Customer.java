package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "customer_tab")
public class Customer {
	
	
	@Id
	private Integer customerId;

	private String customerName;
	
	@ManyToOne //many customer can have one loan
	@JoinColumn(name = "loan_id")
	private Loan loan;
	
	
	
	
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", loan=" + loan + "]";
	}
	
	
	
	
}

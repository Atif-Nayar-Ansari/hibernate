package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Loan_tab")
public class Loan {

	@Id
	private Integer loanId;

	private String loanType;

	private Double amount;

	
	public Loan() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", amount=" + amount + "]";
	}

}

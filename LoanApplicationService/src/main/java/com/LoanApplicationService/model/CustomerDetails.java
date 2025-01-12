package com.LoanApplicationService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerDetails {
        @Id
	private int cid;
	private String customerName;
	private int cibilCode;
	private String cibilStatus;
	private String loanStatus;
	private String email;
	private double loanAmmount;
	private String loanName;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCibilCode() {
		return cibilCode;
	}
	public void setCibilCode(int cibilCode) {
		this.cibilCode = cibilCode;
	}
	public String getCibilStatus() {
		return cibilStatus;
	}
	public void setCibilStatus(String cibilStatus) {
		this.cibilStatus = cibilStatus;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getLoanAmmount() {
		return loanAmmount;
	}
	public void setLoanAmmount(double loanAmmount) {
		this.loanAmmount = loanAmmount;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	
}

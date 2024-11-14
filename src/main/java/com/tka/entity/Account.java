package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private long accNumber;
	private String accHolderName;
	private String accType;
	private String pancardNumber;
	private long mobileNumber;
	private double Balance;
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getPancardNumber() {
		return pancardNumber;
	}
	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public Account(long accNumber, String accHolderName, String accType, String pancardNumber, long mobileNumber,
			double balance) {
		super();
		this.accNumber = accNumber;
		this.accHolderName = accHolderName;
		this.accType = accType;
		this.pancardNumber = pancardNumber;
		this.mobileNumber = mobileNumber;
		Balance = balance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [accNumber=" + accNumber + ", accHolderName=" + accHolderName + ", accType=" + accType
				+ ", pancardNumber=" + pancardNumber + ", mobileNumber=" + mobileNumber + ", Balance=" + Balance + "]";
	}
	
	
}
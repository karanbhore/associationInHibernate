package com.prowings.onetomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AccountOM {

	@Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer accountId;

	@Column
	private String accountNumber;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "AccountOM [accountId=" + accountId + ", accountNumber=" + accountNumber + "]";
	}

}
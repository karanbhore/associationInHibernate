package com.prowings.onetomany.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class EmployeeOM {

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer employeeId;
	@Column
	private String email;
	@Column
	private String firstName;
	@Column
	private String lastName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "Emp_ID")

//    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//	@JoinTable(name = "EMPLOYEE_ACCOUNT", 
//			  joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")},
//			  inverseJoinColumns = {@JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")})
	private Set<AccountOM> accounts;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<AccountOM> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountOM> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "EmployeeOM [employeeId=" + employeeId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", accounts=" + accounts + "]";
	}

}
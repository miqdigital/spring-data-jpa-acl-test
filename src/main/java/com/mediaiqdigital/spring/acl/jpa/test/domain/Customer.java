package com.mediaiqdigital.spring.acl.jpa.test.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer", schema = "hotel")
public class Customer extends Base {

	private String firstName;
	private String lastName;

	public Customer() {
		super();
	}

	public Customer(long id) {
		super(id);
	}

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName
				+ ", getId()=" + getId() + "]";
	}

}

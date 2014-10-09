package com.mediaiqdigital.spring.acl.jpa.test.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Base {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Base(Long id) {
		super();
		this.id = id;
	}

	public Base() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

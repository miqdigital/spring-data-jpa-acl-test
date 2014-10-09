package com.mediaiqdigital.spring.acl.jpa.test.acl.advice;

import org.springframework.stereotype.Component;

import com.mediaiqdigital.spring.acl.jpa.test.domain.Base;

@Component
public class SecurityExpression {

	public boolean isNew(Object entity) {

		if (!(entity instanceof Base))
			throw new IllegalStateException(
					"Expecting entity to be instance of Base");

		// get the entity and check if the id is present, if yes, no op
		Base base = (Base) entity;

		if (base.getId() != null)
			return false;

		return true;
	}
}

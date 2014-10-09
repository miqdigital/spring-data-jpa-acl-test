package com.mediaiqdigital.spring.acl.jpa.test.predicate;

import com.mediaiqdigital.spring.acl.jpa.predicate.AclPredicate;
import com.mediaiqdigital.spring.acl.jpa.test.domain.Customer;
import com.mediaiqdigital.spring.acl.jpa.test.domain.QCustomer;
import com.mysema.query.types.path.NumberPath;

public class CustomerAclPredicate extends AclPredicate<Customer, QCustomer> {

	@Override
	protected NumberPath<Long> getObjectId() {
		return QCustomer.customer.id;
	}

	@Override
	protected NumberPath<Long> getInnerObjectId() {
		return getInnerObject().id;
	}

	@Override
	protected QCustomer getInnerObject() {
		return new QCustomer("innerObject");
	}

	@Override
	protected Class<Customer> getType() {
		return Customer.class;
	}

}

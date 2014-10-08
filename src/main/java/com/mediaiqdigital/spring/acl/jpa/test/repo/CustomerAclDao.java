package com.mediaiqdigital.spring.acl.jpa.test.repo;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.Repository;

import com.mediaiqdigital.spring.acl.jpa.test.domain.Customer;

public interface CustomerAclDao extends Repository<Customer, Long>,
		QueryDslPredicateExecutor<Customer> {

}

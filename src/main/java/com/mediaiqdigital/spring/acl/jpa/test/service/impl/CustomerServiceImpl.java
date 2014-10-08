package com.mediaiqdigital.spring.acl.jpa.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.mediaiqdigital.spring.acl.jpa.test.domain.Customer;
import com.mediaiqdigital.spring.acl.jpa.test.repo.CustomerDao;
import com.mediaiqdigital.spring.acl.jpa.test.service.CustomerService;

@Service
public class CustomerServiceImpl extends
		AbstractCrudServiceImpl<Customer, Long, CustomerDao> implements
		CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public CustomerDao getRepository() {
		return customerDao;
	}

	@Override
	public Page<Customer> get(Integer page, Integer size) {
		return super.get(page, size);
	}

	@Override
	@PreAuthorize("hasPermission(#id,'com.mediaiqdigital.spring.acl.jpa.test.domain.Customer','READ')")
	public Customer getById(Long id) {
		return super.getById(id);
	}

	@Override
	@PreAuthorize("hasPermission(#customer,'WRITE')")
	public Customer save(Customer customer) {
		return super.save(customer);
	}

	@Override
	@PreAuthorize("hasPermission(#id,'com.mediaiqdigital.spring.acl.jpa.test.domain.Customer','DELETE')")
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}

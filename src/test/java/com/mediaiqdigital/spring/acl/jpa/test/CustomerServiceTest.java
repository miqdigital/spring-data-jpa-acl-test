package com.mediaiqdigital.spring.acl.jpa.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mediaiqdigital.spring.acl.jpa.test.domain.Customer;
import com.mediaiqdigital.spring.acl.jpa.test.service.CustomerService;

public class CustomerServiceTest extends BaseTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void testName() throws Exception {
		Customer customer = customerService.getById(4L);
		System.out.println(customer);
	}

}

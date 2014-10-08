package com.mediaiqdigital.spring.acl.jpa.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mediaiqdigital.spring.acl.jpa.test.domain.Customer;
import com.mediaiqdigital.spring.acl.jpa.test.repo.CustomerDao;

public class CustomerDaoTest extends BaseTest {

	@Autowired
	CustomerDao customerDao;

	@Test
	public void addCustomers() throws Exception {

		// add nisha
		customerDao.save(new Customer("Sowdri", "NM"));
		customerDao.save(new Customer("Nisha", "NM"));
		// add prabhu
		customerDao.save(new Customer("Prabhu", ""));
		customerDao.save(new Customer("Prakash", ""));
		customerDao.save(new Customer("Ganesh", ""));
	}

}

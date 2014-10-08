package com.mediaiqdigital.spring.acl.jpa.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediaiqdigital.spring.acl.jpa.test.domain.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}

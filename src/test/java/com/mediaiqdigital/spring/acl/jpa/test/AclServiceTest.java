package com.mediaiqdigital.spring.acl.jpa.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;

import com.mediaiqdigital.spring.acl.jpa.test.domain.Customer;

public class AclServiceTest extends BaseTest {

	@Autowired
	MutableAclService aclService;

	@Test
	public void insertSid() throws Exception {
		System.out.println(Customer.class.getName());
	}

	@Test
	public void test() {
		// Prepare the information we'd like in our access control entry (ACE)
		ObjectIdentity oi = new ObjectIdentityImpl(Customer.class, new Long(1));
		Sid sid = new PrincipalSid("sowdri@mediaiqdigital.com");
		Permission p = BasePermission.READ;

		// Create or update the relevant ACL
		MutableAcl acl = null;
		try {
			acl = (MutableAcl) aclService.readAclById(oi);
		} catch (NotFoundException nfe) {
			acl = aclService.createAcl(oi);
		}

		// Now grant some permissions via an access control entry (ACE)
		acl.insertAce(acl.getEntries().size(), p, sid, true);
		aclService.updateAcl(acl);
	}

}

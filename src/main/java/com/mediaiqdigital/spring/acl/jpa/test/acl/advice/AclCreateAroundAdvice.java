package com.mediaiqdigital.spring.acl.jpa.test.acl.advice;

import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.mediaiqdigital.spring.acl.jpa.test.domain.Base;

@Aspect
@Component
public class AclCreateAroundAdvice {

	@Autowired
	MutableAclService aclService;

	@Around("@annotation(com.mediaiqdigital.spring.acl.jpa.test.acl.advice.CreateAcl) && @annotation(createAcl)")
	public Object log(ProceedingJoinPoint pjp, CreateAcl createAcl)
			throws Throwable {

		Object arg0 = pjp.getArgs()[0];
		if (!(arg0 instanceof Base))
			throw new IllegalStateException(
					"Expecting arg0 to be instance of Base");

		// get the entity and check if the id is present, if yes, no op
		Base entity = (Base) arg0;

		if (entity.getId() != null)
			return pjp.proceed();

		// else, get the return value, get id, and create

		Object retVal = pjp.proceed();

		if (!(retVal instanceof Base))
			throw new IllegalStateException(
					"Expecting instance of base as return value");

		entity = (Base) retVal;

		ObjectIdentity oi = new ObjectIdentityImpl(createAcl.type(),
				entity.getId());

		Set<String> authorities = AuthorityUtils
				.authorityListToSet(SecurityContextHolder.getContext()
						.getAuthentication().getAuthorities());

		// get authority with prefix ROLE_COMPANY
		String company = null;
		for (String authority : authorities)
			if (authority.startsWith("ROLE_COMPANY")) {
				company = authority;
				break;
			}

		if (company == null)
			throw new IllegalStateException(
					"Expecting at least one authority with prefix ROLE_COMPANY");

		Sid sid = new GrantedAuthoritySid(company);
		Permission p = BasePermission.READ;

		MutableAcl acl = aclService.createAcl(oi);

		// Now grant some permissions via an access control entry (ACE)
		acl.insertAce(acl.getEntries().size(), p, sid, true);
		aclService.updateAcl(acl);
		System.out.println("Creating new acl entry for " + company + " entity "
				+ entity.getId());
		return retVal;
	}
}

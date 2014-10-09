package com.mediaiqdigital.spring.acl.jpa.test.acl.advice;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CreateAcl {

	Class<?> type();
}

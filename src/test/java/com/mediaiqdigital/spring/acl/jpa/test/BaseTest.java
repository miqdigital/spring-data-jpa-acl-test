package com.mediaiqdigital.spring.acl.jpa.test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = "classpath:application-context.xml")
public class BaseTest {

	@Before
	public void setup() {
		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		authorities.add(new SimpleGrantedAuthority("ROLE_COMPANY_MIQ"));

		Authentication authRequest = new UsernamePasswordAuthenticationToken(
				"sowdri@mediaiqdigital.com", "password", authorities);
		// authRequest.setAuthenticated(true);
		SecurityContextHolder.getContext().setAuthentication(authRequest);
	}
}

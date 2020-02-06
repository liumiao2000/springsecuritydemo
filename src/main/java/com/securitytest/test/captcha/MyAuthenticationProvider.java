package com.securitytest.test.captcha;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider extends DaoAuthenticationProvider {
	public MyAuthenticationProvider(
		UserDetailsService userDetailsService,
		PasswordEncoder passwordEncoder) {
		this.setUserDetailsService(userDetailsService);
		this.setPasswordEncoder(passwordEncoder);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		MyWebAuthenticationDetails details = 
			(MyWebAuthenticationDetails)authentication.getDetails();
		if(!details.getImageCodeIsRight()) {
			throw new VerificationCodeException("图形验证码校验失败");
		}
		super.additionalAuthenticationChecks(userDetails, authentication);
	}
	
	
}

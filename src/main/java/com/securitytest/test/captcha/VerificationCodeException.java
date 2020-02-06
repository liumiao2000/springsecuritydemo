package com.securitytest.test.captcha;

import org.springframework.security.core.AuthenticationException;

public class VerificationCodeException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -129512386203313912L;

	public VerificationCodeException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}

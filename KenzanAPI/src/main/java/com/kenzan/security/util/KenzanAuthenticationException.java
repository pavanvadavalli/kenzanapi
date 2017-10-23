package com.kenzan.security.util;

import org.springframework.security.core.AuthenticationException;

public class KenzanAuthenticationException extends AuthenticationException {

	public KenzanAuthenticationException(String msg) {
		super(msg);
	}
		

}

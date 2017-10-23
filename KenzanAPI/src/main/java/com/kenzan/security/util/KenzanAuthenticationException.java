package com.kenzan.security.util;

import org.springframework.security.core.AuthenticationException;

public class KenzanAuthenticationException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5919451260962135824L;

	public KenzanAuthenticationException(String msg) {
		super(msg);
	}
		

}

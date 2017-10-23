package com.kenzan.security.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;


public class SecurityExceptionMapper implements ExceptionMapper<AccessDeniedException> {
	
	private static final Logger LOG = LoggerFactory.getLogger(SecurityExceptionMapper.class);

    public Response toResponse(AccessDeniedException exception) {
    	 LOG.info("Access Denied Exception recieved for ",exception);
    	 return Response.status(Response.Status.FORBIDDEN).build();
    }

}
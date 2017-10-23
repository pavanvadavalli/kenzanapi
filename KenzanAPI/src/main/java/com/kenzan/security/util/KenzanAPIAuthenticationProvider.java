package com.kenzan.security.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class KenzanAPIAuthenticationProvider implements AuthenticationProvider {

		private static Logger logger = LoggerFactory.getLogger(KenzanAPIAuthenticationProvider.class);
		
		@Autowired 
		@Qualifier("KenzanAuthetincateComponent")
		private KenzanUserAuthenticationDAO authenticatioDAO;
		
		public Authentication authenticate(Authentication authentication ) throws AuthenticationException {
			String userName = authentication.getName().trim();
		    String password = authentication.getCredentials().toString().trim();
		    Authentication auth = null;
		    
		    KenzanRoles  roles[] = authenticatioDAO.authenticateUser(userName, password.toCharArray());

		        if (roles != null)

		        {
		        	List<SimpleGrantedAuthority> authorisedRoleAuthorities = new ArrayList<SimpleGrantedAuthority>();;

		        	for(KenzanRoles role:roles)
		        	{ 
		        		authorisedRoleAuthorities.add(new SimpleGrantedAuthority(role.name()));
		        	}
		        	auth = new UsernamePasswordAuthenticationToken(userName, password, authorisedRoleAuthorities);
		            return auth;
		        }

		        else      throw new KenzanAuthenticationException("userName:"+userName+" Not recongnised");
		    }

		    @Override

		    public boolean supports(Class<? extends Object> authentication) {

		        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

		    }

}

package com.kenzan.security.util;


public interface  KenzanUserAuthenticationDAO {
	
	public KenzanRoles[] authenticateUser(String userName, char[] password);
 

}

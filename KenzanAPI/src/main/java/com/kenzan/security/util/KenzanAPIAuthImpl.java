package com.kenzan.security.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("KenzanAuthetincateComponent")
public class KenzanAPIAuthImpl implements KenzanUserAuthenticationDAO {

	private static final Map<String, KenzanRoles[]> userRoles;
	private static final Map<String, char[]> userPasswordMap;
	
	static {
        		Map<String, KenzanRoles[]> temp1 = new HashMap<String, KenzanRoles[]>();
        		temp1.put("Pavan", new KenzanRoles[]{KenzanRoles.ROLE_ADMIN,KenzanRoles.ROLE_USER});
        		temp1.put("Isaac", new KenzanRoles[]{KenzanRoles.ROLE_ADMIN,KenzanRoles.ROLE_EMPLOYEE});
        		temp1.put("newIsaac", new KenzanRoles[]{KenzanRoles.ROLE_EMPLOYEE});
        		userRoles = Collections.unmodifiableMap(temp1);
        		
        		Map<String,char[]> temp2 = new HashMap<String, char[]>();
        		temp2.put("Pavan", new char[] { 'P', 'A', 'V', 'A', 'N' });
        		temp2.put("Isaac", new char[] { 'I', 'S', 'A', 'A', 'C' });
        		temp2.put("newIsaac", new char[] { 'I', 'S', 'A', 'A', 'C','1' });
        		userPasswordMap = Collections.unmodifiableMap(temp2);
    }
	
	@Override
	public KenzanRoles[] authenticateUser(String userName, char[] password) {
			
		char[] configuredPassword=userPasswordMap.get(userName);
		if(configuredPassword!=null && Arrays.equals(configuredPassword, password))
		{
			return userRoles.get(userName);				
		}
		return null;
			
	}

	
}

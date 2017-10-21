package com.kenzan.api.startup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class AppStartupListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
			System.out.println("Pavan Context Initialiased");
			String nodeID=System.getProperty("NodeID");
			/* Not Needed 
			 * System.getProperties().forEach((k,v) -> System.out.println("key: "+k+" value:"+v));
			 */
			if(nodeID==null || nodeID.trim().equals(""))
			{	System.err.println("Node Id is null..Need to stop the application");
				throw new RuntimeException("Mandatory Node ID not available in Env parameters");
			}
			else
				System.out.println("Node ID "+nodeID +" Starting");
				
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Pavan Context Destroyed");
		
	}
	
	

}

package com.kenzan.api.dao.couchdb.util;

import java.util.List;

import org.ektorp.dataload.DataLoader;
import org.ektorp.spring.InitialDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component("KenzanDataLoader")
public class KenzanDataLoader extends InitialDataLoader {

	@Value("#{systemProperties['bulkLoad'] ?: 'N'}")
	private String bulkLoad;
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeRepository.class);
	
	@Autowired
	public KenzanDataLoader(List<DataLoader> l, ResourceLoader rl) {
		super(l, rl);
		
	}
	
	public void afterPropertiesSet() throws Exception {
		 LOG.info("Bulk Load System property value is: "+bulkLoad);
		
		 if(bulkLoad!=null && bulkLoad.equals("y"))
			loadData();
	}

}

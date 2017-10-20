package com.kenzan.api.dao.couchdb.util;

import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.ektorp.CouchDbConnector;
import org.ektorp.dataload.DataLoader;
import org.ektorp.dataload.DefaultDataLoader;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@Component("EmployeeRepo")
public class EmployeeRepository extends CouchDbRepositorySupport<EmployeeDocument> implements DataLoader{
	
	private final static String[] INITIAL_DATA_PATH = {"classpath:/initLoad.json"};
	CouchDbConnector employeeDB;

	 @Autowired
    public EmployeeRepository(@Qualifier("employeeCouchdb")CouchDbConnector db) {
        super(EmployeeDocument.class, db);
        employeeDB=db;
        initStandardDesignDocument();
    }
	 
	 @GenerateView @Override
	    public java.util.List<EmployeeDocument> getAll() {
	        org.ektorp.ViewQuery q = createQuery("all")
	                        .includeDocs(true);
	        return db.queryView(q, EmployeeDocument.class);
	    }

	 	 
	 public void loadInitialData(Reader in) {
		
		 System.out.println("Pavan: loadINitial Data called in ");
			Set<String> allIds = new HashSet<String>(employeeDB.getAllDocIds());
		System.out.println("Printing ID's from Database");
			for(String  currenId: allIds)
			{
				System.out.println(currenId);
				
			}
			
			System.out.println("All Database ID's printed");
			ObjectMapper objectMapper= new ObjectMapper();
			EmployeeDocument[] employeeDocs;
			try {
				employeeDocs = objectMapper.readValue(in, EmployeeDocument[].class);
			
				
			for (EmployeeDocument eDoc:employeeDocs) {
				{
					System.out.println("adding {} to database"+ eDoc.getId());
					 db.create(eDoc);
				}
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	        System.out.println("Pavan: loadINitial load funtion finished");
	    }
	  
	    public String[] getDataLocations() {
	        return INITIAL_DATA_PATH;
	    }

	    /**
	    * Is called when all DataLoaders in the system has loaded it´s data.
	    */
	    public void allDataLoaded() {
	    	System.out.println("Init Data loaded");

	    }
	    
	   
	    
}

package com.kenzan.api.dao.couchdb.util;

import java.io.IOException;
import java.io.Reader;


import org.ektorp.CouchDbConnector;
import org.ektorp.UpdateConflictException;
import org.ektorp.ViewQuery;
import org.ektorp.dataload.DataLoader;
import org.ektorp.support.CouchDbRepositorySupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component("EmployeeRepo")
public class EmployeeRepository extends CouchDbRepositorySupport<EmployeeDocument> implements DataLoader{
	
	private final static String[] INITIAL_DATA_PATH = {"classpath:/initLoad.json"};
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeRepository.class);
	
	@Value("#{systemProperties['jsonLoad'] ?: 'NotAvailable'}")
	private String dataloadFile;
	
	CouchDbConnector employeeDB;

	 @Autowired
    public EmployeeRepository(@Qualifier("employeeCouchdb")CouchDbConnector db) {
        super(EmployeeDocument.class, db);
        employeeDB=db;
        initStandardDesignDocument();
    }
	 
   @Override
	    public java.util.List<EmployeeDocument> getAll() {
		 ViewQuery query = new ViewQuery()
                 .designDocId("_design/EmployeeDocument")
                 .viewName("getAllActiveEmployee").includeDocs(true);
                return db.queryView(query, EmployeeDocument.class);
		  
	    }

		@Override
	    public EmployeeDocument get(String employeeID) {
		 ViewQuery query = new ViewQuery()
                 .designDocId("_design/EmployeeDocument")
                 .viewName("getAllActiveEmployee").key(employeeID).includeDocs(true);
		 java.util.List<EmployeeDocument> employees=db.queryView(query, EmployeeDocument.class);
		  if(employees!=null && !employees.isEmpty())
		  {
			  return employees.get(0);
		  }
		  else 
			  return null;
			 
	    }

	 	 
	 public void loadInitialData(Reader in) {
		
		 LOG.info("***************Triggering Initial Data Load ****************");
		  ObjectMapper objectMapper= new ObjectMapper();
		 EmployeeDocument[] employeeDocs;
		 try {
				employeeDocs = objectMapper.readValue(in, EmployeeDocument[].class);
				LOG.info("Number of EMployee Docs to insert "+employeeDocs.length);
				for(EmployeeDocument eDoc: employeeDocs){
					try
						{
							LOG.info("adding "+ eDoc.getId()+ "to database");
							db.create(eDoc);
							//LOG.info("Revision of the doc"+eDoc.revision);
						}
						catch (UpdateConflictException e) {
							LOG.error("Error inserting to DB with ID"+eDoc.getId(), e);
							}
					
			}
				LOG.info("*************** Initial Data Load complete successfully****************");
		 }catch(IOException io)
		 {
			 LOG.error("Cant parse the JSON file for initiload, Skipping the load",io); 
		}
			
			
	 }
	  
	    public String[] getDataLocations() {
	        return INITIAL_DATA_PATH;
	    }

	    /**
	    * Callback for all loaded Data
	    */
	    public void allDataLoaded() {
	    	System.out.println("Init Data loaded");

	    }
	    
	   
	    
}

package com.kenzan.api.dao.couchdb.util;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component("EmployeeRepo")
public class EmployeeRepository extends CouchDbRepositorySupport<EmployeeDocument> {

	 @Autowired
    public EmployeeRepository(@Qualifier("employeeCouchdb")CouchDbConnector db) {
        super(EmployeeDocument.class, db);
        initStandardDesignDocument();
    }
	 
	 @GenerateView @Override
	    public java.util.List<EmployeeDocument> getAll() {
	        org.ektorp.ViewQuery q = createQuery("all")
	                        .includeDocs(true);
	        return db.queryView(q, EmployeeDocument.class);
	    }

}

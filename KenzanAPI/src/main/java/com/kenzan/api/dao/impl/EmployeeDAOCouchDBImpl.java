package com.kenzan.api.dao.impl;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kenzan.api.dao.EmployeeDAO;
import com.kenzan.api.dao.couchdb.util.EmployeeDataTransformerService;
import com.kenzan.api.dao.couchdb.util.EmployeeDocument;
import com.kenzan.api.dao.couchdb.util.EmployeeRepository;
import com.kenzan.api.model.Employee;
import com.kenzan.api.model.EmployeeStatus;
import com.kenzan.api.model.EmployeeToUpdate;

@Service("EmployeeDAOService")
public class EmployeeDAOCouchDBImpl implements EmployeeDAO {
	
	EmployeeRepository employeeRepo;
	private static final AtomicInteger sequenceNumber=new AtomicInteger(1);
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeDAOCouchDBImpl.class);
	
	@Value("#{systemProperties['NodeID'] ?: 'ShouldntHappen'}")
	private String nodeID;
	
	@Autowired
	public EmployeeDAOCouchDBImpl(@Qualifier("EmployeeRepo")EmployeeRepository repo)
	{
		employeeRepo=repo;
	}

	@Override
	public String createEmployee(Employee employeeToCreate) {
		
		employeeToCreate.employeeId=nodeID+System.currentTimeMillis()+sequenceNumber.getAndIncrement();
		EmployeeDocument doc=EmployeeDataTransformerService.getEmployeeDocufromEmployee(employeeToCreate);
		employeeRepo.add(doc);
		return employeeToCreate.employeeId;
	}

	@Override
	public Employee getEmployeeDetailsById(String employeeId) {
		EmployeeDocument doc=employeeRepo.get(employeeId);
		Employee emp=EmployeeDataTransformerService.getEmployeefromDocument(doc);
		return emp;
	}

	@Override
	public Employee[] getAllEmployees() {
		List<EmployeeDocument> docs=employeeRepo.getAll();
		return EmployeeDataTransformerService.getEmployeesfromDocumentList(docs);
		
	}

	@Override
	public boolean deActivateEmployee(String employeeId) {
		EmployeeDocument eDoc = employeeRepo.get(employeeId);
		if (eDoc!= null)
		{	eDoc.status=EmployeeStatus.INACTIVE;
		 	employeeRepo.update(eDoc);
		 	return true;
		}
		else 
		{ 
			LOG.info("No action taken to deactivate the employee as the employee is not existing or inactive already: "+employeeId);
			return false;
		}
		
	}

	@Override
	public void updateEmployee(String employeeId,EmployeeToUpdate employeeToUpdate) {
		EmployeeDocument empDoc=employeeRepo.get(employeeId);
		empDoc=EmployeeDataTransformerService.getUpdateEmployeeDocuforUpdateEmployee(empDoc,employeeToUpdate);
		employeeRepo.update(empDoc);
		
	}


}

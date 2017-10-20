package com.kenzan.api.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kenzan.api.dao.EmployeeDAO;
import com.kenzan.api.dao.couchdb.util.EmployeeDataTransformerService;
import com.kenzan.api.dao.couchdb.util.EmployeeDocument;
import com.kenzan.api.dao.couchdb.util.EmployeeRepository;
import com.kenzan.api.model.Employee;

@Service("EmployeeDAOService")
public class EmployeeDAOCouchDBImpl implements EmployeeDAO {
	
	EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeDAOCouchDBImpl(@Qualifier("EmployeeRepo")EmployeeRepository repo)
	{
		employeeRepo=repo;
	}

	@Override
	public long createEmployee(Employee employeeToCreate) {
		EmployeeDocument doc=EmployeeDataTransformerService.getEmployeeDocufromEmployee(employeeToCreate);
		employeeRepo.add(doc);
		return employeeToCreate.employeeId;
	}

	@Override
	public Employee getEmployeeDetailsByInternalId(String employeeId) {
		EmployeeDocument doc=employeeRepo.get(employeeId);
		Employee emp=EmployeeDataTransformerService.getEmployeefromDocument(doc);
		return emp;
	}
	
	

}

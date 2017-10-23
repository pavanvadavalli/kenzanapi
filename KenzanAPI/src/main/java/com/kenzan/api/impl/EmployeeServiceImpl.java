package com.kenzan.api.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kenzan.api.EmployeeService;
import com.kenzan.api.dao.EmployeeDAO;
import com.kenzan.api.dao.couchdb.util.EmployeeDocument;
import com.kenzan.api.dao.couchdb.util.EmployeeRepository;
import com.kenzan.api.model.Employee;
import com.kenzan.api.model.EmployeeStatus;
import com.kenzan.api.model.EmployeeToUpdate;

@Service("employeeservice")
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDao;
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("EmployeeDAOService")EmployeeDAO dao) 
	{
		employeeDao=dao;
	}
	
	
	@Override
	public Employee getEmployee(String id) {
		return employeeDao.getEmployeeDetailsById(id);
	}
		
	@Override
	public Employee[] getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public String addEmployee(Employee employee) {
		employee.status=EmployeeStatus.ACTIVE;
		return employeeDao.createEmployee(employee);
	}

	@Override
	public void removeEmployee(String employeeId) {
		employeeDao.deActivateEmployee(employeeId);
	}


	@Override
	public void updateEmployee(String employeeId,EmployeeToUpdate employee) {
		
		employeeDao.updateEmployee(employeeId,employee);
		
	}

}

package com.kenzan.api.impl;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kenzan.api.EmployeeService;

import com.kenzan.api.dao.EmployeeDAO;

import com.kenzan.api.model.Employee;
import com.kenzan.api.model.EmployeeStatus;
import com.kenzan.api.model.EmployeeToUpdate;

@Service("employeeservice")
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDao;
		
	@Autowired
	public EmployeeServiceImpl(@Qualifier("EmployeeDAOService")EmployeeDAO dao) 
	{
		employeeDao=dao;
	}
	
	
	@Override
	public Employee getEmployee(String id) {
		Employee emp=employeeDao.getEmployeeDetailsById(id);
		if(emp==null) throw new WebApplicationException(Response.Status.NOT_FOUND);
		return emp;
	}
		
	@Override
	public Employee[] getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public String addEmployee(Employee employee) {
		
		BusinessValidationResponse validationResponse=EmployeeServiceBusinessValidation.validateCreateEmloyee(employee);
		if(validationResponse.isValidationSuccessful())
		{
			employee.status=EmployeeStatus.ACTIVE;		
			return employeeDao.createEmployee(employee);
		}
		else throw new WebApplicationException(validationResponse.getErrorMessages(), Response.Status.BAD_REQUEST);
	}

	@Override
	public void removeEmployee(String employeeId) {
		boolean removeSuccessful=employeeDao.deActivateEmployee(employeeId);
		if(!removeSuccessful) throw new WebApplicationException(Response.Status.NOT_FOUND);
		
	}

	@Override
	public void updateEmployee(String employeeId,EmployeeToUpdate employee) {
		BusinessValidationResponse validationResponse=EmployeeServiceBusinessValidation.validateUpdateEmloyee(employee);
		if(validationResponse.isValidationSuccessful())
		{
			employeeDao.updateEmployee(employeeId,employee);
		}
		else throw new WebApplicationException(validationResponse.getErrorMessages(), Response.Status.BAD_REQUEST);
	}
}

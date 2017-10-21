package com.kenzan.api.dao;

import com.kenzan.api.model.Employee;

public interface EmployeeDAO {
	
	public String createEmployee(Employee employeeToCreate);
	public Employee getEmployeeDetailsById(String employeeId );
	
	}

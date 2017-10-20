package com.kenzan.api.dao;

import com.kenzan.api.model.Employee;

public interface EmployeeDAO {
	
	public long createEmployee(Employee employeeToCreate);
	public Employee getEmployeeDetailsByInternalId(String employeeId );
	
	}

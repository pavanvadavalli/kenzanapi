package com.kenzan.api.dao;

import com.kenzan.api.model.Employee;
import com.kenzan.api.model.EmployeeToUpdate;

public interface EmployeeDAO {
	
	public String createEmployee(Employee employeeToCreate);
	public Employee getEmployeeDetailsById(String employeeId );
	public Employee[] getAllEmployees();
	public void deActivateEmployee(String employeeId);
	public void updateEmployee(String employeeID,EmployeeToUpdate employeeToUpdate);
	}

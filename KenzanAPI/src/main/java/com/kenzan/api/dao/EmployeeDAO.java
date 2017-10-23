package com.kenzan.api.dao;

import com.kenzan.api.model.Employee;
import com.kenzan.api.model.EmployeeToUpdate;
/**
 * 
 * @author pavanv 
 * Employee DAO service providing data access layer to the REst Service Layer
 * Encapsulates the Database implementation from Service layer
 */
public interface EmployeeDAO {
	
	/**
	 * add the Employee to the Database, Provides the generated Unique ID
	 * Expects all the business validations are completed before invoking the Data access layer API 
	 * @param employeeToCreate Employee object to crate
	 * @return String Employee ID created successfully
	 */
	public String createEmployee(Employee employeeToCreate);
	/**
	 * Retrieves the Active Employee Details  
	 * @param employeeId the Employee ID
	 * @return Employee object
	 */
	public Employee getEmployeeDetailsById(String employeeId );
	/**
	 * Retrieves all Active Employees
	 * @return Employee[] all active employees
	 */
	public Employee[] getAllEmployees();
	/**
	 * Inactivate an already Active Employee
	 * @param employeeId String The Employee ID who needs to be made inactive
	 * @return true/false indicating the successful completion
	 */
	public boolean deActivateEmployee(String employeeId);
	/**
	 * Update an existing Active Employee
	 * @param employeeID employee ID to update
	 * @param employeeToUpdate the details of the employee to update
	 */
	public void updateEmployee(String employeeID,EmployeeToUpdate employeeToUpdate);
	}

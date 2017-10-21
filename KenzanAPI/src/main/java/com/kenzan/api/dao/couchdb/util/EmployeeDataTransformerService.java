package com.kenzan.api.dao.couchdb.util;

import com.kenzan.api.model.Employee;

public final class EmployeeDataTransformerService {
	
	
	public static Employee  getEmployeefromDocument(EmployeeDocument document)
	{
		if(document!=null)
		{
			Employee emp = new Employee();
			emp.employeeId= document.getId();
			emp.firstName=document.firstName;
			emp.lastName=document.lastName;
			emp.middleInitial=document.middleInitial;
			emp.dateOfBirth=document.dateOfBirth;
			emp.dateOfEmployement=document.dateOfEmployement;
			emp.status=document.status;
			emp.employeeAdditionalInfo=document.employeeAdditionalInfo;
			
			return emp;
		}
		return null;
	}
	
	public static EmployeeDocument   getEmployeeDocufromEmployee( Employee employee)
	{
		if(employee!=null)
		{
			EmployeeDocument doc = new EmployeeDocument();
			doc.setId(employee.employeeId);
			doc.firstName=employee.firstName;
			doc.lastName=employee.lastName;
			doc.middleInitial=employee.middleInitial;
			doc.dateOfBirth=employee.dateOfBirth;
			doc.dateOfEmployement=employee.dateOfEmployement;
			doc.status=employee.status;
			doc.employeeAdditionalInfo=employee.employeeAdditionalInfo;
			
			return doc;
		}
		return null;
	}
	

}

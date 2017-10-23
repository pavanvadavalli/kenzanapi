package com.kenzan.api.dao.couchdb.util;

import java.util.ArrayList;
import java.util.List;


import com.kenzan.api.model.Employee;
import com.kenzan.api.model.EmployeeToUpdate;

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
	
	
	public static Employee[]  getEmployeesfromDocumentList(List<EmployeeDocument> documents)
	{
		List<Employee> employees= new ArrayList<>(documents.size());
		
		documents.forEach((eDoc)->
		{
			Employee emp = new Employee();
			emp.employeeId= eDoc.getId();
			emp.firstName=eDoc.firstName;
			emp.lastName=eDoc.lastName;
			emp.middleInitial=eDoc.middleInitial;
			emp.status=eDoc.status;
			emp.dateOfBirth=eDoc.dateOfBirth;
			emp.dateOfEmployement=eDoc.dateOfEmployement;
			emp.employeeAdditionalInfo=eDoc.employeeAdditionalInfo;
			employees.add(emp);
				
		});
		return employees.toArray(new Employee[employees.size()]);
	}
	
	
	public static EmployeeDocument  getUpdateEmployeeDocuforUpdateEmployee(EmployeeDocument eDoc, EmployeeToUpdate emp)
	{
		if(eDoc!=null&& emp!=null)
		{			
			eDoc.firstName=emp.firstName;
			eDoc.lastName=emp.lastName;
			eDoc.middleInitial=emp.middleInitial;
			eDoc.dateOfBirth=emp.dateOfBirth;
			eDoc.dateOfEmployement=emp.dateOfEmployement;
			eDoc.employeeAdditionalInfo=emp.employeeAdditionalInfo;
			
			return eDoc;
		}
		return null;
	}

}

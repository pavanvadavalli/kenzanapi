package com.kenzan.api.impl;

import com.kenzan.api.model.Employee;

import com.kenzan.api.model.EmployeeToUpdate;

public class EmployeeServiceBusinessValidation {
	
	
	public static BusinessValidationResponse validateCreateEmloyee(Employee empToCreate)
	{
		StringBuffer errorMessage = new StringBuffer("");
		
		if(empToCreate.firstName==null || empToCreate.firstName.equals(""))
			errorMessage.append("FirstName cant be NUll");
		
		if(empToCreate.lastName==null || empToCreate.lastName.equals(""))
			errorMessage.append("lastName cant be NUll");
		
		if(empToCreate.dateOfBirth==null)
			errorMessage.append("dateOfBirth cant be NUll");
		
		if(empToCreate.dateOfEmployement==null)
			errorMessage.append("dateOfEmployement cant be NUll");
			
		if (!errorMessage.toString().equals("")) 
			return new BusinessValidationResponse(false,errorMessage.toString());
		else 
			return new BusinessValidationResponse(true,null);
			
		
		
	}
	
	
	public static BusinessValidationResponse validateUpdateEmloyee(EmployeeToUpdate empToUpdate)
	{
		
		StringBuffer errorMessage = new StringBuffer("");
		
		if(empToUpdate.firstName==null || empToUpdate.firstName.equals(""))
			errorMessage.append("FirstName cant be NUll");
		
		if(empToUpdate.lastName==null || empToUpdate.lastName.equals(""))
			errorMessage.append("lastName cant be NUll");
		
		if(empToUpdate.dateOfBirth==null)
			errorMessage.append("dateOfBirth cant be NUll");
		
		if(empToUpdate.dateOfEmployement==null)
			errorMessage.append("dateOfEmployement cant be NUll");
			
		if (!errorMessage.toString().equals("")) 
			return new BusinessValidationResponse(false,errorMessage.toString());
		else 
			return new BusinessValidationResponse(true,null);
			
		
	}

}

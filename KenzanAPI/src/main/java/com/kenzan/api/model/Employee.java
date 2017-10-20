package com.kenzan.api.model;

import java.util.Date;
import java.util.Hashtable;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.kenzan.api.dao.couchdb.util.CustomJsonDateDeserializer;

public class Employee  {
	/*
	 * ID - Unique identifier for an employee
	 * FirstName - Employees first name
	 * MiddleInitial - Employees middle initial
	 * LastName - Employeed last name
	 * DateOfBirth - Employee birthday and year
	 * DateOfEmployment - Employee start date
	 * Status - ACTIVE or INACTIVE
	 */
	    public long employeeId;
	    public String firstName;
	    public String middleInitial;
	    public String lastName;
	    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
	    public Date dateOfBirth;
	    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
	    public Date dateOfEmployement;
	    public EmployeeStatus status;
	    public Hashtable<String, String> employeeAdditionalInfo;
	  	    

	}


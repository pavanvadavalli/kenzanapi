package com.kenzan.api.dao.couchdb.util;

import java.util.Date;
import java.util.Hashtable;


import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kenzan.api.dao.couchdb.util.CustomJsonDateDeserializer;
import com.kenzan.api.model.EmployeeStatus;

@XmlRootElement(name = "employee")
public class EmployeeDocument extends CouchDbDocument {
	/*
	 * ID - Unique identifier for an employee
	 * FirstName - Employees first name
	 * MiddleInitial - Employees middle initial
	 * LastName - Employeed last name
	 * DateOfBirth - Employee birthday and year
	 * DateOfEmployment - Employee start date
	 * Status - ACTIVE or INACTIVE
	 */
		@TypeDiscriminator
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


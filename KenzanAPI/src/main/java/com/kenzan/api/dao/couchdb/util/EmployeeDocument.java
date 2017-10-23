package com.kenzan.api.dao.couchdb.util;

import java.util.Date;
import java.util.Hashtable;


import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.kenzan.api.dao.couchdb.util.CustomJsonDateDeserializer;
import com.kenzan.api.model.EmployeeStatus;

public class EmployeeDocument extends CouchDbDocument{
	/**
	 * 
	 */
	private static final long serialVersionUID = 132960875882683364L;

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
		public String firstName;
	    
		public String middleInitial;
	    
		public String lastName;
	    
		/**
		 * Really Yuck: Ektorp uses codehause, and its core fails if its switched to Jackson
		 * CXF, Jax-rs uses Jackson, hence need to put both json properties- 
		 * Need to find a proper solution for this
		 */
		@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	    @JsonSerialize(using= CustomJsonDateSerializer.class)
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	    public Date dateOfBirth;
	    
		@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	    @JsonSerialize(using= CustomJsonDateSerializer.class)
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	    public Date dateOfEmployement;
	    
		public EmployeeStatus status;
	    
		public Hashtable<String, String> employeeAdditionalInfo;
	  	    

	}


package com.kenzan.api.model;

import java.util.Date;
import java.util.Hashtable;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kenzan.api.dao.couchdb.util.CustomJsonDateDeserializer;
import com.kenzan.api.dao.couchdb.util.CustomJsonDateSerializer;

public class EmployeeToUpdate {
	
	 	
	 
		@NotNull
	 	public String firstName;
	    
	 	public String middleInitial;
	    
	 	@NotNull
	 	public String lastName;
	 	
	    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
	    @JsonSerialize(using= CustomJsonDateSerializer.class)
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	    @JsonProperty(required=true)
	    @NotNull
	    public Date dateOfBirth;
	    
	    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
	    @JsonSerialize(using= CustomJsonDateSerializer.class)
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	    @JsonProperty(required=true)
	    @NotNull
	    public Date dateOfEmployement;
	    
	    @NotNull
	    public Hashtable<String, String> employeeAdditionalInfo;

}

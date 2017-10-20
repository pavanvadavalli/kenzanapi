package com.kenzan.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kenzan.api.model.Employee;

@Path("/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EmployeeService {
	
	@GET
	@Path("/{id}/")	
	public Employee getEmployee(@PathParam("id") String id);

	@GET
	@Path("/getall")
	public Employee[] getAllEmployees();
	
	@PUT
	@Path("/")
	public long addEmployee(Employee employee);

}

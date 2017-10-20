package com.kenzan.api.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kenzan.api.EmployeeService;
import com.kenzan.api.dao.EmployeeDAO;
import com.kenzan.api.model.Employee;

@Service("employeeservice")
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("EmployeeDAOService")EmployeeDAO dao) 
	{
		employeeDao=dao;
	}
	
	public void initEmployeeData() {
		System.out.println("Init data called");
		}

		public EmployeeServiceImpl() {
			initEmployeeData();
		}

		
		public Employee getEmployee(String id) {
			return employeeDao.getEmployeeDetailsByInternalId(id);
		}
		
		public Employee[] getAllEmployees() {
			return  null;
		}

		@Override
		public long addEmployee(Employee employee) {
			 Date currentDate=new Date();
			  employee.employeeId=currentDate.getTime();
			employeeDao.createEmployee(employee);
			return employee.employeeId;
		}

	}

package com.kenzan.api.model;

public enum EmployeeStatus {
	ACTIVE (1), INACTIVE (0);

	    private int status;

	    EmployeeStatus(int status) {
	        this.status = status;
	    }

	    public int getStatus() {
	        return status;
	    }
	}



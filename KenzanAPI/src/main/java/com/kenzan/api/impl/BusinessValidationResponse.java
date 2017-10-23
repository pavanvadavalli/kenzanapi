package com.kenzan.api.impl;

public class BusinessValidationResponse {
	
	public BusinessValidationResponse(boolean validationSuccessful, String errorMessages) {
		super();
		this.validationSuccessful = validationSuccessful;
		this.errorMessages = errorMessages;
	}
	private boolean validationSuccessful;
	private String errorMessages;
	
	public boolean isValidationSuccessful() {
		return validationSuccessful;
	}
	public void setValidationSuccessful(boolean validationSuccessful) {
		this.validationSuccessful = validationSuccessful;
	}
	public String getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}
}

package com.electricity.nintriva.response;

public enum ErrorMessages {

	MISSING_REQUIRED_FIELDS("Missing Required fields please check documentation for required fields");

	private String errormessage;

	ErrorMessages(String errormessage) {
		this.errormessage=errormessage;
		
		
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	
}

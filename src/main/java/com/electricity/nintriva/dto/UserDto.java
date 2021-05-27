package com.electricity.nintriva.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String firstName;
	public String lastName;
	public String consumer_Number;
	
	public String publicUserId;
	public String encryptedPassword;
	public String password;
	
	
	
	
	public String getPublicUserId() {
		return publicUserId;
	}
	public void setPublicUserId(String publicUserId) {
		this.publicUserId = publicUserId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getConsumer_Number() {
		return consumer_Number;
	}
	public void setConsumer_Number(String consumer_Number) {
		this.consumer_Number = consumer_Number;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
		

	
	
	
	
}

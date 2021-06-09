package com.electricity.nintriva.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author SONY
 *
 */
public class CustomerRegisterModel {

	@NotNull(message = "first name cannot be null")
	private String firstName;
	@NotNull(message = "last name cannot be null")
	private String lastName;
	@NotNull(message = "consumer number cannot be null")
	private int consumerNumber;
	@NotNull(message = "password cannot be null")
	@Size(min=8,max=16,message = "password must be 8 characters long")
	private String password;


	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getConsumerNumber() {
		return consumerNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setConsumerNumber(int consumerNumber) {
		this.consumerNumber = consumerNumber;



	}

}

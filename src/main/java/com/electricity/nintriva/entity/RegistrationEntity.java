package com.electricity.nintriva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="UserReg")
public class RegistrationEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int userId;
	

	
	@Column(nullable=false)
	public String firstName;
	@Column(nullable=false)
	public String lastName;
	
	@Column(nullable=false,unique = true,length= 15)
	public int consumerNumber;
	
	@Column
	public String publicUserId;
	@Column
	public String encryptedPassword;
	public int getUserId() {
		return userId;
	}

	@Column
	public String email;
	public void setUserId(int userId) {
		this.userId = userId;
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
	

	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getPublicUserId() {
		return publicUserId;
	}
	public void setPublicUserId(String publicUserId) {
		this.publicUserId = publicUserId;
	}
	public int getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(int consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

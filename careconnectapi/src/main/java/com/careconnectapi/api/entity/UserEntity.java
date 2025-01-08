package com.careconnectapi.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "asutosh_patient")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "userId", nullable = false)
	@Column(name = "patientId", nullable = false)
	private int userId;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	@Column(name = "lastName", nullable = false)
	private String lastName;
	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;
	@Column(name = "emailId", nullable = false)
	private String emailId;
	@Column(name = "passWord", nullable = false)
	private String passWord;
	
	public int getUserId() {
		return userId;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord=passWord;
	}
}

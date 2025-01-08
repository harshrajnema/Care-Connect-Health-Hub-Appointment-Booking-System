package com.careconnectapi.api.model;

 
public class UserRequestBody {
 	
	private int userId;
 	private String firstName;
 	private String lastName;
 	private String phoneNumber;
 	private String emailId;
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

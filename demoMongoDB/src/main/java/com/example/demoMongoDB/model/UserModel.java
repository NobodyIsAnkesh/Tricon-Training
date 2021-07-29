package com.example.demoMongoDB.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tuser")
public class UserModel {
	@Id
	private String id;
	private String username;
	private String password;
	private String emailId;
	private BigInteger contact;
	
	public UserModel(String username, String password, String emailId, BigInteger contact) {
		super();
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.contact = contact;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public BigInteger getContact() {
		return contact;
	}
	public void setContact(BigInteger contact) {
		this.contact = contact;
	}
	
}

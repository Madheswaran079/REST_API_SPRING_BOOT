package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String password;
	private String name;
	private long phoneNum;
	private String email;
	private String address;
	public PersonalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalDetails(int id, String userName, String password, String name, long phoneNum, String email, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

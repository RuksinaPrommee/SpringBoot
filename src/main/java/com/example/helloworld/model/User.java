package com.example.helloworld.model;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private int id;
	
	private String firstName;
	private String lastName;
	
	public User() {
	}

	public User(int id,String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return String.format("User[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}


}

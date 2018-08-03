package com.example.helloworld;

public class User {
	
	private String firstName;
	private String lastName;

	public User() {
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
		return String.format("User[firstName='%s', lastName='%s']", firstName, lastName);
	}

}

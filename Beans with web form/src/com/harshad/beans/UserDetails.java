package com.harshad.beans;

public class UserDetails {
	private String firstName;
	private String lastName;

	public UserDetails() {
		this.firstName = "Harshad";
		this.lastName = "Panmand";
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
}

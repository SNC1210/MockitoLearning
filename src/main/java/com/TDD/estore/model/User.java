package com.TDD.estore.model;

public class User {

	private String firstName, lastName,email;
	private String Id;
	
	public User(String firstName, String lastName, String email, String Id) {
		super();
		this.firstName = firstName;
		this.lastName= lastName;
		this.email = email;
		this.Id=Id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	

}

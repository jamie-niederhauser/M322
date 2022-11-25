package com.example.application.views.main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Person {

	public Person(String firstName, String lastName, String email, String wohnort){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.wohnort = wohnort;
	}


	@NotEmpty
	private String firstName = "";

	@NotEmpty
	private String lastName = "";

	@NotEmpty
	private String wohnort = "";

	@Email
	@NotEmpty
	private String email = "";

	@Override
	public String toString() {
		return firstName + " " + lastName;
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

	public String getWohnort(){
		return wohnort;
	}

	public void setWohnort(String wohnort){
		this.wohnort = wohnort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
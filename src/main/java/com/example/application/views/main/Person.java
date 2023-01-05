package com.example.application.views.main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vaadin.flow.component.template.Id;

import javax.validation.constraints.*;

public class Person {

	public Person(){

	}

	public Person(String firstName, String lastName, String email, String wohnort){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.wohnort = wohnort;
	}

	@Id


	@NotBlank
	@Size(max = 45)
	private String firstName = "";

	@NotBlank
	@Size(max = 45)
	private String lastName = "";

	@NotBlank
	@Size(max = 45)
	private String wohnort = "";

	@Email
	@NotBlank
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
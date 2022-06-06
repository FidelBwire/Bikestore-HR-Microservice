package com.app.bikestore.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Name {

	@NotEmpty
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@NotEmpty
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	public Name() { }

	public Name(@NotEmpty String firstName, @NotEmpty String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

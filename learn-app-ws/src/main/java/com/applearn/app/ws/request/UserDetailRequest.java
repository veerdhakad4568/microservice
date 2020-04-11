package com.applearn.app.ws.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequest {
    
	@NotNull(message ="first name can not be null")
	private String firstName;
	
	@NotNull(message ="last name can not be null")
	private String lastName;
	
	@NotNull(message ="email  can not be null")
	@Email(message ="invalid email")
	private String email;
	
	@NotNull(message ="password can not be null")
	@Size(min = 8,message ="password length can not be less than 8")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

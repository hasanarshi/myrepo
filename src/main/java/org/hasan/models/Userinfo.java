package org.hasan.models;

// this class is based on java-bean pattern
// it will store the user related data
public class Userinfo 
{
	// data members
	private String name, email, pass;

	public String getName() {
		return name;
	}

	// setters and getters
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// no argument constructor
	public Userinfo() {
	}
	
	// constructor with parameters
	public Userinfo(String name, String email, String pass) 
	{
		this.name = name;
		this.email = email;
		this.pass = pass;
	}
}
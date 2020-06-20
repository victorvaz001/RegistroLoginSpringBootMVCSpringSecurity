package com.br.victorvaz.springboot.web.dto;

public class UserRegistratioDto {
	private String firsName;
	private String lastName;
	private String email;
	private String password;
	
	public UserRegistratioDto(){
		
	}
	
	public UserRegistratioDto(String firsName, String lastName, String email, String password) {
		super();
		this.firsName = firsName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public String getFirsName() {
		return firsName;
	}
	public void setFirsName(String firsName) {
		this.firsName = firsName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}

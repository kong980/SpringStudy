package com.netsol7.member.model;

//RegisterRequest Dto
public class RegisterRequest {
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public void setName(String name) {
		this.name = name;
	}
	//암호 암호확인 메서드 추가
	public boolean isPasswordEqualToconfirmPassword() {
		return password.equals(confirmPassword);
	}
	
	
}

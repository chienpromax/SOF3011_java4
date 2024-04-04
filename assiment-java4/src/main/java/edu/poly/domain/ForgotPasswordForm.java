package edu.poly.domain;

public class ForgotPasswordForm {
	private String username;
	private String email;
	
	public ForgotPasswordForm() {

	}
	public ForgotPasswordForm(String username, String email) {

		this.username = username;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}

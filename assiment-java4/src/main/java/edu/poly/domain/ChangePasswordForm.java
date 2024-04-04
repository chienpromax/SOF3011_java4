package edu.poly.domain;

public class ChangePasswordForm {
	private String username;
	private String password;
	private String confirmPassword;
	private String currentPassword;
	
	
	public ChangePasswordForm() {
	}
	public ChangePasswordForm(String username, String password, String confirmPassword, String currentPassword) {
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.currentPassword = currentPassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
	
}

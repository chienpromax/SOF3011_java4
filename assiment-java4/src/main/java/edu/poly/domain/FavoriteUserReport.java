package edu.poly.domain;

import java.util.Date;

public class FavoriteUserReport {
	private String username;
	private String fullname;
	private String email;
	private Date likeDate;
	
	
	public FavoriteUserReport() {
		
	}
	public FavoriteUserReport(String username, String fullname, String email, Date likeDate) {
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.likeDate = likeDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
}

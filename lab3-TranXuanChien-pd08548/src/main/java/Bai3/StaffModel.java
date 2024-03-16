package Bai3;

import java.sql.Date;

public class StaffModel {
	private String username,password, nationality,note;
	private Date date;
	private boolean gender;
	private boolean married;
//	private String[] favorites;
	private String imageName;
	public String getUsername() {
		return username;
	}
	public String getImageName() {
		return imageName;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
//	public String[] getFavorites() {
//		return favorites;
//	}
//	public void setFavorites(String[] favorites) {
//		this.favorites = favorites;
//	}
	

}

package fpoly.edu.vn;

public class User {
	String username;
	String password;
	boolean remeber;
	
	public User() {
		super();
	}
	public User(String username, String password, boolean remeber) {
		super();
		this.username = username;
		this.password = password;
		this.remeber = remeber;
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
	public boolean isRemeber() {
		return remeber;
	}
	public void setRemeber(boolean remeber) {
		this.remeber = remeber;
	}
}

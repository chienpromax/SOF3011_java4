package fpoly.edu.vn;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	List<User> users = new ArrayList<>();
	
	public List<User> dumyData() throws ParseException{
		users.add(new User("Chiến 123", "123", true));
		users.add(new User("Chiến 456", "123", false));
		users.add(new User("Chiến 789", "123", true));
		return users;
	}
	
	public List<User> getAll(){
		return users;
	}
}

package Services;

import java.util.List;

import javax.ejb.Remote;


import Entities.User;

@Remote
public interface UserServiceRemote {
	
	public List<User> users();
	public User getUserByEmailAndPassword(String email, String password);
	int ajoutUser(User u);
	void suppUser(int id);
	void modifUser(User u);
	List<User> affiAllUser();
	User affUser(int id);
	

	


}

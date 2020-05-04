package fr.jeanlouispiera.metier;

import fr.jeanlouispiera.entities.User;


public interface IUserService {
	
	public void save(User user);
	
	public User findByUsername(String username);
	
	public User createUser(String username, String adresseMail);
	
	public User createAdmin(String username);

}

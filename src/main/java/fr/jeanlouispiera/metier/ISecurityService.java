package fr.jeanlouispiera.metier;

import fr.jeanlouispiera.entities.User;

public interface ISecurityService {
	
	String findLoggedInUsername();
	
	User findLoggedInUser();
	
	void autologin(String username, String password);
	
	

}

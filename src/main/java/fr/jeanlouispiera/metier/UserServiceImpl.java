package fr.jeanlouispiera.metier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.jeanlouispiera.dao.RoleRepository;
import fr.jeanlouispiera.dao.UserRepository;
import fr.jeanlouispiera.entities.Role;
import fr.jeanlouispiera.entities.RoleEnum;
import fr.jeanlouispiera.entities.User;

@Service
public class UserServiceImpl implements IUserService {

@Autowired
private UserRepository userRepository;
@Autowired
private RoleRepository roleRepository;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;

/**
 * Cette méthode permet de persister un utilisateur en base de donnéees 
 */
@Override
public void save(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setRole(roleRepository.findByName(RoleEnum.USER));
    userRepository.save(user);
}

/**
 * Cette méthode permet de rechercher par son nom un utilisateur persisté en base de données
 */
@Override
public User findByUsername(String username) {
    return userRepository.findByUsername(username);
}

/**
 * Cette méthode permet de créer un jeu de données Utilisateur dans le Main au moment du lancement de l'appli 
 */
@Override
public User createUser(String username) {
	User u = new User(username);
	Role r = roleRepository.findByName(RoleEnum.USER);
	u.setRole(r);
	u.setPassword("$2a$10$8kVCmqZNmEu7ihwunzaNN.KxnFMn1HuDmBcj1O.mOK24gJ15C5b06");
	userRepository.save(u);
	return u;
}

/**
 * Cette méthode permet de créer un administrateur dans le Main au moment du lancement de l'appli
 */
@Override
public User createAdmin(String username) {
	User u = new User(username);
	Role r = roleRepository.findByName(RoleEnum.ADMIN);
	u.setRole(r);
	u.setPassword("$2a$10$8kVCmqZNmEu7ihwunzaNN.KxnFMn1HuDmBcj1O.mOK24gJ15C5b06");
	
	userRepository.save(u);
	
	
	return u;
}



}

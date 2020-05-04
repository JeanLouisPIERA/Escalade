package fr.jeanlouispiera.metier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import fr.jeanlouispiera.entities.User;

@Service
public class SecurityServiceImpl implements ISecurityService{
	
@Autowired
private AuthenticationManager authenticationManager;
@Autowired
private UserDetailsService userDetailsService;

private static final Logger logger = LoggerFactory.getLogger
(SecurityServiceImpl.class);

/**
 * Cette méthode permet d'identifier le nom de l'utilisateur loggé après authentification
 */
@Override
public String findLoggedInUsername() {
    Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
    if (userDetails instanceof UserDetails) {
        return ((UserDetails)userDetails).getUsername();
    }

    return null;
}

/**
 * Cette méthode permet d'identifier l'utilisateur loggé après authentification 
 */
@Override
public User findLoggedInUser() {
	Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
    if (userDetails instanceof UserDetails) {
        return (User) ((UserDetails)userDetails);
    }

    return null;
}

/**
 * Cette méthode permet à un visiteur de se logger automatiquement avec le role USER
 */
@Override
public void autologin(String username, String password) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken 
    = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

    authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    if (usernamePasswordAuthenticationToken.isAuthenticated()) {
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        logger.debug(String.format("Auto login %s successfully!", username));
    }
}




}
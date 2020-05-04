package fr.jeanlouispiera.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jeanlouispiera.dao.UserRepository;
import fr.jeanlouispiera.entities.Role;
import fr.jeanlouispiera.entities.User;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Cette méthode implémente l'interface UserDetailsService de Spring Security et permet de la customiser
     * le processus de retouver un utilisateur persisté en base de données.
     * Elle est utilisée par le processus d'Authentication pour charger les détails sur l'utilisateur pendant 
     * l'authentification 
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        
        Role role = user.getRole();
            System.out.println("le role est:" + role.getName().toString());
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().toString()));
        
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        
    }
}
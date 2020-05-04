package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.Role;
import fr.jeanlouispiera.entities.RoleEnum;

public interface RoleRepository extends JpaRepository <Role, Long>{
	
	Role findByName(RoleEnum name);
	
}

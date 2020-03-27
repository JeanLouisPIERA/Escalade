package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.jeanlouispiera.entities.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	
}

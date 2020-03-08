package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}

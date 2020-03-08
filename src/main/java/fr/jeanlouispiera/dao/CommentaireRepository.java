package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

}

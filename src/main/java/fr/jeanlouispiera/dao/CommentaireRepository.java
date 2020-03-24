package fr.jeanlouispiera.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.jeanlouispiera.entities.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

	//@Query
	//Optional<Commentaire> findById(Long numCommentaire);
	
}

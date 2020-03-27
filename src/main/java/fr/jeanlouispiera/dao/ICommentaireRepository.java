package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.jeanlouispiera.entities.Commentaire;

public interface ICommentaireRepository extends JpaRepository<Commentaire, Long>{

	
	
}

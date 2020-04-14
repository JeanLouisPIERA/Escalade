package fr.jeanlouispiera.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.jeanlouispiera.entities.Commentaire;
import fr.jeanlouispiera.entities.Site;

public interface ICommentaireRepository extends JpaRepository<Commentaire, Long>{

	@Query
	List<Commentaire> findBySite(Site site);
	
	
	
}

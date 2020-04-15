package fr.jeanlouispiera.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.jeanlouispiera.entities.Site;

@Repository
public interface ISiteRepository extends JpaRepository<Site, Long>{

	   @Query
	   List<Site> findByNomSite(String nomSite);
	   
	   
	  
	  
	   
	
	
}

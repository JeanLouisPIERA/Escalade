package fr.jeanlouispiera.dao;

import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.jeanlouispiera.entities.Site;

//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.Utilisateur;

public interface TopoRepository extends JpaRepository<Topo, Long>{
	
	
	@Query
	List<Topo> findByNomTopo(String nomTopo);
	List<Topo> findByEditeur(String editeur);
	List<Topo> findByDateParution(String dateParution);
	List<Topo> findByTopoStatut(TopoStatut topostatut);
	List<Topo> findByUtilisateur(Utilisateur utilisateur);
	List<Topo> findBySite(Site site);
 	
}

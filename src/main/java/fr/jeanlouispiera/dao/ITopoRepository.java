package fr.jeanlouispiera.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.jeanlouispiera.entities.Site;

import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.User;


public interface ITopoRepository extends JpaRepository<Topo, Long>{
	
	@Query
	List<Topo> findByNomTopo(String nomTopo);
	
	@Query
	Page<Topo> findByUser(User user, Pageable pageable);
	
	@Query
	List<Topo> findBySite(Site site);
	
 	
}

package fr.jeanlouispiera.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.User;


public interface ITopoMetier {
	
	
	
	// *******************   CRUD ************************************************************** 
	
	//1 CRUD D'UN TOPO DANS SON ESPACE PERSONNEL 
	
		//1-1 CREATE D'UN TOPO
			Topo createTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
					String langue, int nbPages, TopoStatut topoStatut, User user, Site site, String adresseMailUser) ;
			
			void addUserToTopo(Topo topo,User user);
			
			Topo addTopo(Topo topo);
			
		//1-2 READ D'UN TOPO 
			Topo readTopo(long codeTopo);

		//1-3 UPDATE D'UN TOPO
			Topo updateTopo(Topo topo);

		//1-4 DELETE D'UN TOPO
			void deleteTopo(long codeTopo);
			
	
		      
	   //2-1 AFFICHER TOUS LES TOPOS
		   public Page<Topo> findAll(Pageable pageable);
		   
		   public Page<Topo> findByUser(User user, Pageable pageable);
				
	
		   //3 GERER LE PRET D'UN TOPO *****************************************
		   public Topo changerTopoStatut(Long codeTopo, TopoStatut TopoStatut1, TopoStatut TopoStatut2);
			
		   
	

	//*********************** RECHERCHE COMMENTAIRE ******************************
	
		   
	// 4- RECHERCHER TOUS LES COMMENTAIRES PAR SITE
		
		List<Topo> findToposBySite(Site site);	

}

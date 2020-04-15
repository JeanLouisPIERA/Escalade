package fr.jeanlouispiera.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.Utilisateur;

public interface ITopoMetier {
	
	/**
	 * INTERFACE METIER. CHAQUE METHODE REPRESENTE UN USE CASE DES FONCTIONNALITES DU SITE ESCALADE	
	**/
	
	// *******************   CRUD ************************************************************** 
	
	//1 CRUD D'UN TOPO DANS SON ESPACE PERSONNEL 
	
		//1-1 CREATE D'UN TOPO
			Topo createTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
					String langue, int nbPages, TopoStatut topoStatut, Utilisateur utilisateur, Site site) ;
			
			Topo addTopo(Topo topo);
			
		//1-2 READ D'UN TOPO 
			Topo readTopo(long codeTopo);

		//1-3 UPDATE D'UN TOPO
			Topo updateTopo(Topo topo);

		//1-4 DELETE D'UN TOPO
			void deleteTopo(long codeTopo);
			
	//2 SELECTIONNER TOUS LES TOPOS EXISTANTS A PARTIR D'UNE VALEUR D'ATTRIBUTE EN COMMUN
		   List<Topo> searchByNomTopo(String nomTopo);
		   List<Topo> searchByEditeur(String editeur);
		   List<Topo> searchByDateParution(String dateParution);
		   List<Topo> searchByTopoStatut(TopoStatut topoStatut);
		   List<Topo> searchByUtilisateur(Utilisateur utilisateur);
		   List<Topo> searchBySite(Site site);
		      
	   //2-1 AFFICHER TOUS LES TOPOS
		   public Page<Topo> findAll(Pageable pageable);
				
	//3 GERER LE PRET D'UN TOPO *****************************************
		   public Topo changerTopoStatut(Long codeTopo, TopoStatut TopoStatut1, TopoStatut TopoStatut2);
				
		//3-1 FAIRE UNE DEMANDE DE RESERVATION D'UN TOPO DISPONIBLE 
			public Topo requestBooking(Long codeTopo);
				
		//3-2 ACCEPTER LA DEMANDE DE RESERVATION D'UN TOPO DISPONIBLE 
			public Topo confirmBooking(Long CodeTopo);
				
		//3-3 INDIQUER LA FIN DU PRET D'UN TOPO QUI REDEVIENT DISPONIBLE  
			public Topo endBooking(Long codeTopo);

	//*********************** RECHERCHE COMMENTAIRE ******************************
	
	// 4- RECHERCHER TOUS LES COMMENTAIRES PAR SITE
		
		List<Topo> findToposBySite(Site site);		

}

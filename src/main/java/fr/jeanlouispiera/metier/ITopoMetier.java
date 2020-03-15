package fr.jeanlouispiera.metier;

import java.util.List;

//import org.springframework.data.domain.Page;


import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.Utilisateur;

public interface ITopoMetier {
	
	/**
	 * INTERFACE METIER. CHAQUE METHODE REPRESENTE UN USE CASE DES FONCTIONNALITES DU SITE ESCALADE	
	**/
	
	// *******************   CRUD CONSULTATION ET GESTION DES TOPOS ************[PAR UN VISITEUR] OU [PAR UN MEMBRE]
	
	//1 CRUD D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
		//1-1 CREATE D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
			public Topo createTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
					String langue, int nbPages, TopoStatut topoStatut, Utilisateur utilisateur, Site site) ;
			
		//1-2 READ D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
			public Topo readTopo(Long codeTopo);

		//1-3 UPDATE D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
			public Topo updateTopo(Long codeTopo, String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur,
					int longueur, String langue, int nbPages, TopoStatut topoStatut, Utilisateur utilisateur, Site site);

		//1-4 DELETE D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
			public void deleteTopo(Long codeTopo);
			
	//2 SELECTIONNER TOUS LES TOPOS EXISTANTS A PARTIR D'UNE VALEUR D'ATTRIBUTE EN COMMUN ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
		   public List<Topo> searchByNomTopo(String nomTopo);
		   public List<Topo> searchByEditeur(String editeur);
		   public List<Topo> searchByDateParution(String dateParution);
		   public List<Topo> searchByTopoStatut(TopoStatut topoStatut);
		   public List<Topo> searchByUtilisateur(Utilisateur utilisateur);
		   public List<Topo> searchBySite(Site site);
		      
	   //2-1 AFFICHER TOUS LES TOPOS
		   public List<Topo> displayAllTopos();
				
	//3 GERER LE PRET D'UN TOPO *****************************************
		   public Topo changerTopoStatut(Long codeTopo, TopoStatut TopoStatut1, TopoStatut TopoStatut2);
				
		//3-1 FAIRE UNE DEMANDE DE RESERVATION D'UN TOPO DISPONIBLE ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
			public Topo requestBooking(Long codeTopo);
				
		//3-2 ACCEPTER LA DEMANDE DE RESERVATION D'UN TOPO DISPONIBLE ******** PAR LE PROPIETAIRE [UN VISITEUR] OU [UN MEMBRE]
			public Topo confirmBooking(Long CodeTopo);
				
		//3-3 INDIQUER LA FIN DU PRET D'UN TOPO QUI REDEVIENT DISPONIBLE  ******** PAR LE PROPIETAIRE [UN VISITEUR] OU [UN MEMBRE]
			public Topo endBooking(Long codeTopo);

			

}

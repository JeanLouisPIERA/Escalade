package fr.jeanlouispiera.metier;

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
			
	//2 CONSULTER TOUS LES TOPOS DISPONIBLES POUR UN SITE D'ESCALADE ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
			//public Page<Topo> listTopo(Long codeTopo, int page, int size);
			
	//3 FAIRE UNE DEMANDE DE RESERVATION D'UN TOPO DISPONIBLE ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
			public void requestBooking(Long codeTopo);

	//4 ACCEPTER LA DEMANDE DE RESERVATION D'UN TOPO DISPONIBLE ******** PAR LE PROPIETAIRE [UN VISITEUR] OU [UN MEMBRE]
			public void confirmBooking(Long CodeTopo);
			
	//5 INDIQUER LA FIN DU PRET D4UN TOPO QUI REDEVIENT DISPONIBLE  ******** PAR LE PROPIETAIRE [UN VISITEUR] OU [UN MEMBRE]
			public void endBooking(Long codeTopo);


}

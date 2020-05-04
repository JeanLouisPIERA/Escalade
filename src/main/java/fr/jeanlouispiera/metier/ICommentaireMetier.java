package fr.jeanlouispiera.metier;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.jeanlouispiera.entities.Commentaire;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.User;


public interface ICommentaireMetier {

//********************** CRUD COMMENTAIRE GENERAL SUR UN SITE ********************** 

//1-CREATE UN COMMENTAIRE GENERAL CONCERNANT LA FICHE OFFICIELLE D'UN SITE ****** 
	
	Commentaire createCommentaire(String titreCommentaire, Date dateCommentaire,String contenuCommentaire,
			User user, Topo topo, Site site);
		
	Commentaire addCommentaire(Commentaire commentaire);

//2-READ UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE ***** 
	
	Commentaire readCommentaire(long numCommentaire);
	

//3 UPDATE UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE ****  
	

	Commentaire updateCommentaire(Commentaire commentaire);
	
//4 DELETE UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE ******  
	
	void deleteCommentaire(Long numCommentaire);

//*********************** RECHERCHE COMMENTAIRE ******************************
	
// 5- RECHERCHER TOUS LES COMMENTAIRES PAR SITE
	
	List<Commentaire> findCommentairesBySite(Site site);
	
	
	
}

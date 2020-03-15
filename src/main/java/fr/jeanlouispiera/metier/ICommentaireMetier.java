package fr.jeanlouispiera.metier;

import java.util.Date;

import fr.jeanlouispiera.entities.Commentaire;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.Utilisateur;

public interface ICommentaireMetier {
	
	/**
	 * INTERFACE METIER. CHAQUE METHODE REPRESENTE UN USE CASE DES FONCTIONNALITES DU SITE ESCALADE	
	**/

//********************** CRUD COMMENTAIRE GENERAL SUR UN SITE ********************** [PAR UN VISITEUR]

//1-CREATE UN COMMENTAIRE GENERAL CONCERNANT LA FICHE OFFICIELLE D'UN SITE ****** [PAR UN VISITEUR] 
	public Commentaire createComment(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
			Utilisateur utilisateur, Topo topo, Site site);

//2-READ UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE ***** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
	public Commentaire readComment(Long numCommentaire);

//3 UPDATE UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE **** [PAR UN MEMBRE] 
	public Commentaire updateComment(Long numCommentaire, String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
			Utilisateur utilisateur, Topo topo, Site site);

//4 DELETE UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE ****** [PAR UN MEMBR]E 
	public void deleteComment(Long numCommentaire);

	
}

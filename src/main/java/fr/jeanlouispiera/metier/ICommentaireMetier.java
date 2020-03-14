package fr.jeanlouispiera.metier;

import fr.jeanlouispiera.entities.Commentaire;

public interface ICommentaireMetier {
	
	/**
	 * INTERFACE METIER. CHAQUE METHODE REPRESENTE UN USE CASE DES FONCTIONNALITES DU SITE ESCALADE	
	**//**

	//********************** CRUD COMMENTAIRE GENERAL SUR UN SITE ********************** [PAR UN VISITEUR]
	
			//5-1-CREATE UN COMMENTAIRE GENERAL CONCERNANT LA FICHE OFFICIELLE D'UN SITE ****** [PAR UN VISITEUR] 
			public Commentaire createComment(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
					Long codeUtilisateur, Long codeTopo, Long numSite);
			
			//5-2-READ UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE ***** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
			public Commentaire readComment(Long numCommentaire);

			//5-3 UPDATE UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE **** [PAR UN MEMBRE] 
			public Commentaire updateComment(Long numCommentaire, String titreCommentaire, String contenuCommentaire,
					Long codeUtilisateur, Long codeTopo, Long numSite);

			//5-4 DELETE UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE ****** [PAR UN MEMBR]E 
			public void deleteComment(Long numCommentaire);
	**/
	
}

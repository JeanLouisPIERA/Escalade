package fr.jeanlouispiera.metier;

import fr.jeanlouispiera.entities.Utilisateur;

public interface IUtilisateurMetier {

	/**
	 * INTERFACE METIER. CHAQUE METHODE REPRESENTE UN USE CASE DES FONCTIONNALITES DU SITE ESCALADE	
	**/
		
	// CRUD DE SON ESPACE PERSONNEL [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
		
		//1-1 CREATE DE SON ESPACE PERSONNEL PAR L'UTILISATEUR MEMBRE OU VISITEUR 
			public Utilisateur createUser(String nomUtilisateur, String adresseMail, String passWord);

		//1-2 READ DE SON ESPACE PERSONNEL ******* [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
			public Utilisateur readUser(Long codeUtilisateur);
		
		//1-3 UPDATE DE SON ESPACE PERSONNEL ******** [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
			public Utilisateur updateUser(Long codeUtilisateur, String passWord);
		
		//1-4 DELETE DE SON ESPACE PERSONNEL ******* [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
			public void deleteUser(Long codeUtilisateur);
	
}

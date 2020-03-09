package fr.jeanlouispiera.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("UV")
public class UtilisateurVisiteur extends Utilisateur{

	public UtilisateurVisiteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UtilisateurVisiteur(String nomUtilisateur, String adresseMail, String passWord) {
		super(nomUtilisateur, adresseMail, passWord);
		// TODO Auto-generated constructor stub
	}
	
	

}

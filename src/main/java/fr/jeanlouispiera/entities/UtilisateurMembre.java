package fr.jeanlouispiera.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("UM")

public class UtilisateurMembre extends Utilisateur {

	private static final long serialVersionUID = 1L;
	
	public UtilisateurMembre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UtilisateurMembre(String nomUtilisateur, String adresseMail, String passWord) {
		super(nomUtilisateur, adresseMail, passWord);
		// TODO Auto-generated constructor stub
	}

	
	
	

}

package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

public class Utilisateur implements Serializable{
	private String nomUtilisateur;
	private String adresseMail;
	private String password;
	private Collection<Topo> topos;
	private Collection<Commentaire> commentaires;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(String nomUtilisateur, String adresseMail, String password) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.adresseMail = adresseMail;
		this.password = password;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Topo> getTopos() {
		return topos;
	}
	public void setTopos(Collection<Topo> topos) {
		this.topos = topos;
	}
	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	
}

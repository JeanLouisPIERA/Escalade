package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Date;

public class Commentaire implements Serializable {
	private String titreCommentaire;
	private Date dateCommentaire;
	private String contenuCommentaire;
	private Utilisateur utilisateur;
	private Topo topo;
	private Site site;
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commentaire(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
			Utilisateur utilisateur, Topo topo, Site site) {
		super();
		this.titreCommentaire = titreCommentaire;
		this.dateCommentaire = dateCommentaire;
		this.contenuCommentaire = contenuCommentaire;
		this.utilisateur = utilisateur;
		this.topo = topo;
		this.site = site;
	}
	public String getTitreCommentaire() {
		return titreCommentaire;
	}
	public void setTitreCommentaire(String titreCommentaire) {
		this.titreCommentaire = titreCommentaire;
	}
	public Date getDateCommentaire() {
		return dateCommentaire;
	}
	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}
	public String getContenuCommentaire() {
		return contenuCommentaire;
	}
	public void setContenuCommentaire(String contenuCommentaire) {
		this.contenuCommentaire = contenuCommentaire;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}

	
}

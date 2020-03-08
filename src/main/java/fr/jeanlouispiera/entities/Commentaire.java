package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long num_Commentaire;
	private String titreCommentaire;
	private Date dateCommentaire;
	private String contenuCommentaire;
	@ManyToOne
	@JoinColumn(name="USER")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="TOPO")
	private Topo topo;
	@ManyToOne
	@JoinColumn(name="SITE")
	private Site site;
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commentaire(Long num_Commentaire, String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
			Utilisateur utilisateur, Topo topo, Site site) {
		super();
		this.num_Commentaire = num_Commentaire;
		this.titreCommentaire = titreCommentaire;
		this.dateCommentaire = dateCommentaire;
		this.contenuCommentaire = contenuCommentaire;
		this.utilisateur = utilisateur;
		this.topo = topo;
		this.site = site;
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
	public Long getNum_Commentaire() {
		return num_Commentaire;
	}
	public void setNum_Commentaire(Long num_Commentaire) {
		this.num_Commentaire = num_Commentaire;
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

package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;
@Entity
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long numCommentaire;
	@Column(length=50)
	private String titreCommentaire;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="d MMM yyyy")
	@Column
	@NotNull
	private Date dateCommentaire = new Date();
	@Column(length=255)
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
	
	
	
	public Commentaire(Long numCommentaire, String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
			Utilisateur utilisateur, Topo topo, Site site) {
		super();
		this.numCommentaire = numCommentaire;
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
	
	
	public Commentaire(String titreCommentaire, String contenuCommentaire, Utilisateur utilisateur, Topo topo,
			Site site) {
		super();
		this.titreCommentaire = titreCommentaire;
		this.contenuCommentaire = contenuCommentaire;
		this.utilisateur = utilisateur;
		this.topo = topo;
		this.site = site;
	}
	public Commentaire(Long numCommentaire) {
		super();
		this.numCommentaire = numCommentaire;
	}
	
	
	public Commentaire(Site site) {
		super();
		this.site = site;
	}
	
	
	
	public Commentaire(Utilisateur utilisateur, Site site) {
		super();
		this.utilisateur = utilisateur;
		this.site = site;
	}



	public Commentaire(Date dateCommentaire) {
		super();
		this.dateCommentaire = dateCommentaire;
	}



	public Commentaire(Date dateCommentaire, Site site) {
		super();
		this.dateCommentaire = dateCommentaire;
		this.site = site;
	}



	public Long getNumCommentaire() {
		return numCommentaire;
	}
	public void setNumCommentaire(Long numCommentaire) {
		this.numCommentaire = numCommentaire;
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

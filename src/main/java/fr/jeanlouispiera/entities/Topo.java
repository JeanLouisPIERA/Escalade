package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Topo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeTopo;
	private String nomTopo;
	private String descriptionTopo;
	private String editeur;
	private String dateParution; 
	private int largeur;
	private int longueur;
	private String langue;
	private int nbPages;
	private String statutTopo;
	@OneToMany(mappedBy="topo")
	private Collection <Commentaire> commentaires;
	@ManyToOne
	@JoinColumn(name="USER")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="SITE")
	private Site site;
	public Topo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Topo(Long codeTopo, String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur,
			int longueur, String langue, int nbPages, String statutTopo, Utilisateur utilisateur, Site site) {
		super();
		this.codeTopo = codeTopo;
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.largeur = largeur;
		this.longueur = longueur;
		this.langue = langue;
		this.nbPages = nbPages;
		this.statutTopo = statutTopo;
		this.utilisateur = utilisateur;
		this.site = site;
	}
	
	public Topo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
			String langue, int nbPages, String statutTopo, Utilisateur utilisateur, Site site) {
		super();
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.largeur = largeur;
		this.longueur = longueur;
		this.langue = langue;
		this.nbPages = nbPages;
		this.statutTopo = statutTopo;
		this.utilisateur = utilisateur;
		this.site = site;
	}
	public Long getCodeTopo() {
		return codeTopo;
	}
	public void setCodeTopo(Long codeTopo) {
		this.codeTopo = codeTopo;
	}
	public String getNomTopo() {
		return nomTopo;
	}
	public void setNomTopo(String nomTopo) {
		this.nomTopo = nomTopo;
	}
	public String getDescriptionTopo() {
		return descriptionTopo;
	}
	public void setDescriptionTopo(String descriptionTopo) {
		this.descriptionTopo = descriptionTopo;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public String getDateParution() {
		return dateParution;
	}
	public void setDateParution(String dateParution) {
		this.dateParution = dateParution;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public int getNbPages() {
		return nbPages;
	}
	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}
	public String getStatutTopo() {
		return statutTopo;
	}
	public void setStatutTopo(String statutTopo) {
		this.statutTopo = statutTopo;
	}
	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
	
	
	
	
}

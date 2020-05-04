package fr.jeanlouispiera.entities;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String adresseMailUser;
	private int largeur;
	private int longueur;
	private String langue;
	private int nbPages;
	private TopoStatut topoStatut;
	@OneToMany(mappedBy="topo")
	private Collection <Commentaire> commentaires;
	@ManyToOne
	@JoinColumn(name="USER")
	private User user;
	@ManyToOne
	@JoinColumn(name="SITE")
	private Site site;
	@OneToMany(mappedBy="topo", fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;
	
	
	public Topo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Topo(Long codeTopo) {
		super();
		this.codeTopo = codeTopo;
	}
	

	
	public Topo(Long codeTopo, String nomTopo, String descriptionTopo, String editeur, String dateParution,
			String adresseMailUser, int largeur, int longueur, String langue, int nbPages, TopoStatut topoStatut,
			Collection<Commentaire> commentaires, User user, Site site) {
		super();
		this.codeTopo = codeTopo;
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.adresseMailUser = adresseMailUser;
		this.largeur = largeur;
		this.longueur = longueur;
		this.langue = langue;
		this.nbPages = nbPages;
		this.topoStatut = topoStatut;
		this.commentaires = commentaires;
		this.user = user;
		this.site = site;
	}

	public Topo(String nomTopo, String descriptionTopo, String editeur, String dateParution, String adresseMailUser,
			int largeur, int longueur, String langue, int nbPages, TopoStatut topoStatut,
			Collection<Commentaire> commentaires, User user, Site site) {
		super();
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.adresseMailUser = adresseMailUser;
		this.largeur = largeur;
		this.longueur = longueur;
		this.langue = langue;
		this.nbPages = nbPages;
		this.topoStatut = topoStatut;
		this.commentaires = commentaires;
		this.user = user;
		this.site = site;
	}


	public Topo(Long codeTopo, String nomTopo, String descriptionTopo, String editeur, String dateParution,
			String adresseMailUser, int largeur, int longueur, String langue, int nbPages, TopoStatut topoStatut,
			Collection<Commentaire> commentaires, User user, Site site, Collection<Reservation> reservations) {
		super();
		this.codeTopo = codeTopo;
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.adresseMailUser = adresseMailUser;
		this.largeur = largeur;
		this.longueur = longueur;
		this.langue = langue;
		this.nbPages = nbPages;
		this.topoStatut = topoStatut;
		this.commentaires = commentaires;
		this.user = user;
		this.site = site;
		this.reservations = reservations;
	}




	public Topo(String nomTopo, String descriptionTopo, String editeur, String dateParution, String adresseMailUser,
			int largeur, int longueur, String langue, int nbPages, TopoStatut topoStatut,
			Collection<Commentaire> commentaires, User user, Site site, Collection<Reservation> reservations) {
		super();
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.adresseMailUser = adresseMailUser;
		this.largeur = largeur;
		this.longueur = longueur;
		this.langue = langue;
		this.nbPages = nbPages;
		this.topoStatut = topoStatut;
		this.commentaires = commentaires;
		this.user = user;
		this.site = site;
		this.reservations = reservations;
	}


	public Topo(Long codeTopo, String nomTopo, String descriptionTopo, String editeur, String dateParution,
			String adresseMailUser, int largeur, int longueur, String langue, int nbPages, TopoStatut topoStatut,
			User user, Site site) {
		super();
		this.codeTopo = codeTopo;
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.adresseMailUser = adresseMailUser;
		this.largeur = largeur;
		this.longueur = longueur;
		this.langue = langue;
		this.nbPages = nbPages;
		this.topoStatut = topoStatut;
		this.user = user;
		this.site = site;
	}

	public Topo(String nomTopo, String descriptionTopo, String editeur, String dateParution, String adresseMailUser,
			int largeur, int longueur, String langue, int nbPages, TopoStatut topoStatut, User user, Site site) {
		super();
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.adresseMailUser = adresseMailUser;
		this.largeur = largeur;
		this.longueur = longueur;
		this.langue = langue;
		this.nbPages = nbPages;
		this.topoStatut = topoStatut;
		this.user = user;
		this.site = site;
	}




	public Topo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
			String langue, int nbPages, TopoStatut topoStatut, User user, Site site) {
		super();
		this.nomTopo = nomTopo;
		this.descriptionTopo = descriptionTopo;
		this.editeur = editeur;
		this.dateParution = dateParution;
		this.largeur = largeur;
		this.longueur = longueur;
		this.langue = langue;
		this.nbPages = nbPages;
		this.topoStatut = topoStatut;
		this.user = user;
		this.site = site;
	}




	public Topo(User user) {
		super();
		this.user = user;
	}




	public Topo(Site site) {
		super();
		this.site = site;
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




	public TopoStatut getTopoStatut() {
		return topoStatut;
	}


	public void setTopoStatut(TopoStatut topoStatut) {
		this.topoStatut = topoStatut;
	}


	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}


	


	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Long getCodeTopo() {
		return codeTopo;
	}




	public void setCodeTopo(Long codeTopo) {
		this.codeTopo = codeTopo;
	}




	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}




	public Collection<Reservation> getReservations() {
		return reservations;
	}




	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}




	public String getAdresseMailUser() {
		return adresseMailUser;
	}




	public void setAdresseMailUser(String adresseMailUser) {
		this.adresseMailUser = adresseMailUser;
	}
	
	
	
	
	
	
	
	
	
	
	

	
}

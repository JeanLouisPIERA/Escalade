package fr.jeanlouispiera.entities;

import java.io.Serializable;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="site")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long numSite;
	private String nomSite;
	private int altitude;
	private int nbVoies;
	private int hauteurMin;
	private int hauteurMax;
	private int longueurTotaleVoies;
	private SiteNiveauDePratique siteNiveauDePratique;
	private SiteCotation siteCotation;
	private SiteOrientation siteOrientation;
	private SiteRegion siteRegion; 
	private SiteTypeRoche siteTypeRoche;
	private SiteTag siteTag;
	@OneToMany(mappedBy="site", fetch=FetchType.LAZY)
	private Collection<Topo> topos;
	@OneToMany(mappedBy="utilisateur", fetch=FetchType.LAZY)
	private Collection<Commentaire> commentaires;
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Site(Long numSite) {
		super();
		this.numSite = numSite;
	}



	public Site(Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation,
			SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag) {
		super();
		this.numSite = numSite;
		this.nomSite = nomSite;
		this.altitude = altitude;
		this.nbVoies = nbVoies;
		this.hauteurMin = hauteurMin;
		this.hauteurMax = hauteurMax;
		this.longueurTotaleVoies = longueurTotaleVoies;
		this.siteNiveauDePratique = siteNiveauDePratique;
		this.siteCotation = siteCotation;
		this.siteOrientation = siteOrientation;
		this.siteRegion = siteRegion;
		this.siteTypeRoche = siteTypeRoche;
		this.siteTag = siteTag;
	}

	public Site(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
			SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation, SiteOrientation siteOrientation,
			SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag) {
		super();
		this.nomSite = nomSite;
		this.altitude = altitude;
		this.nbVoies = nbVoies;
		this.hauteurMin = hauteurMin;
		this.hauteurMax = hauteurMax;
		this.longueurTotaleVoies = longueurTotaleVoies;
		this.siteNiveauDePratique = siteNiveauDePratique;
		this.siteCotation = siteCotation;
		this.siteOrientation = siteOrientation;
		this.siteRegion = siteRegion;
		this.siteTypeRoche = siteTypeRoche;
		this.siteTag = siteTag;
	}

	public Long getNumSite() {
		return numSite;
	}

	public void setNumSite(Long numSite) {
		this.numSite = numSite;
	}

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public int getNbVoies() {
		return nbVoies;
	}

	public void setNbVoies(int nbVoies) {
		this.nbVoies = nbVoies;
	}

	public int getHauteurMin() {
		return hauteurMin;
	}

	public void setHauteurMin(int hauteurMin) {
		this.hauteurMin = hauteurMin;
	}

	public int getHauteurMax() {
		return hauteurMax;
	}

	public void setHauteurMax(int hauteurMax) {
		this.hauteurMax = hauteurMax;
	}

	public int getLongueurTotaleVoies() {
		return longueurTotaleVoies;
	}

	public void setLongueurTotaleVoies(int longueurTotaleVoies) {
		this.longueurTotaleVoies = longueurTotaleVoies;
	}

	public SiteNiveauDePratique getSiteNiveauDePratique() {
		return siteNiveauDePratique;
	}

	public void setSiteNiveauDePratique(SiteNiveauDePratique siteNiveauDePratique) {
		this.siteNiveauDePratique = siteNiveauDePratique;
	}

	public SiteCotation getSiteCotation() {
		return siteCotation;
	}

	public void setSiteCotation(SiteCotation siteCotation) {
		this.siteCotation = siteCotation;
	}

	public SiteOrientation getSiteOrientation() {
		return siteOrientation;
	}

	public void setSiteOrientation(SiteOrientation siteOrientation) {
		this.siteOrientation = siteOrientation;
	}

	public SiteRegion getSiteRegion() {
		return siteRegion;
	}

	public void setSiteRegion(SiteRegion siteRegion) {
		this.siteRegion = siteRegion;
	}

	public SiteTypeRoche getSiteTypeRoche() {
		return siteTypeRoche;
	}

	public void setSiteTypeRoche(SiteTypeRoche siteTypeRoche) {
		this.siteTypeRoche = siteTypeRoche;
	}

	public SiteTag getSiteTag() {
		return siteTag;
	}

	public void setSiteTag(SiteTag siteTag) {
		this.siteTag = siteTag;
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

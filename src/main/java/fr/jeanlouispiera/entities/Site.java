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
	private String tag;
	@OneToMany(mappedBy="site")
	private Collection<Topo> topos;
	@OneToMany(mappedBy="site")
	private Collection<Commentaire> commentaires;
	@ManyToOne
	@JoinColumn(name="PRACTLEVEL")
	private NiveauDePratique niveauDePratique;
	@ManyToOne
	@JoinColumn(name="ROCHE")
	private TypeRoche typeRoche;
	@ManyToOne
	@JoinColumn(name="COTATION")
	private Cotation cotation;
	@ManyToOne
	@JoinColumn(name="TYPE")
	private TypeEscalade typeEscalade;
	@ManyToOne
	@JoinColumn(name="ESCALEVEL")
	private NiveauEscalade niveauEscalade;
	@ManyToOne
	@JoinColumn(name="ORIENTATION")
	private Orientation orientation;
	@ManyToOne
	@JoinColumn(name="MASSIF")
	private Massif massif;
	@ManyToOne
	@JoinColumn(name="CARTE_IGN")
	private CarteIgn carteIgn;
	@ManyToOne
	@JoinColumn(name="COMMUNE")
	private Commune commune;
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Site(Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, String tag, Collection<Topo> topos, Collection<Commentaire> commentaires,
			NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation, TypeEscalade typeEscalade,
			NiveauEscalade niveauEscalade, Orientation orientation, Massif massif, CarteIgn carteIgn, Commune commune) {
		super();
		this.numSite = numSite;
		this.nomSite = nomSite;
		this.altitude = altitude;
		this.nbVoies = nbVoies;
		this.hauteurMin = hauteurMin;
		this.hauteurMax = hauteurMax;
		this.longueurTotaleVoies = longueurTotaleVoies;
		this.tag = tag;
		this.topos = topos;
		this.commentaires = commentaires;
		this.niveauDePratique = niveauDePratique;
		this.typeRoche = typeRoche;
		this.cotation = cotation;
		this.typeEscalade = typeEscalade;
		this.niveauEscalade = niveauEscalade;
		this.orientation = orientation;
		this.massif = massif;
		this.carteIgn = carteIgn;
		this.commune = commune;
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
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
	public NiveauDePratique getNiveauDePratique() {
		return niveauDePratique;
	}
	public void setNiveauDePratique(NiveauDePratique niveauDePratique) {
		this.niveauDePratique = niveauDePratique;
	}
	public TypeRoche getTypeRoche() {
		return typeRoche;
	}
	public void setTypeRoche(TypeRoche typeRoche) {
		this.typeRoche = typeRoche;
	}
	public Cotation getCotation() {
		return cotation;
	}
	public void setCotation(Cotation cotation) {
		this.cotation = cotation;
	}
	public TypeEscalade getTypeEscalade() {
		return typeEscalade;
	}
	public void setTypeEscalade(TypeEscalade typeEscalade) {
		this.typeEscalade = typeEscalade;
	}
	public NiveauEscalade getNiveauEscalade() {
		return niveauEscalade;
	}
	public void setNiveauEscalade(NiveauEscalade niveauEscalade) {
		this.niveauEscalade = niveauEscalade;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	public Massif getMassif() {
		return massif;
	}
	public void setMassif(Massif massif) {
		this.massif = massif;
	}
	public CarteIgn getCarteIgn() {
		return carteIgn;
	}
	public void setCarteIgn(CarteIgn carteIgn) {
		this.carteIgn = carteIgn;
	}
	public Commune getCommune() {
		return commune;
	}
	public void setCommune(Commune commune) {
		this.commune = commune;
	}
	
	

	
}

package fr.jeanlouispiera.entities;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_FICHE", discriminatorType=DiscriminatorType.STRING, length=4)
public abstract class Site implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long numSite;
	private String nomSite;
	private int altitude;
	private int nbVoies;
	private int hauteurMin;
	private int hauteurMax;
	private int longueurTotaleVoies;
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
	}

	public Site(Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
			TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
			CarteIgn carteIgn, Commune commune) {
		super();
		this.numSite = numSite;
		this.nomSite = nomSite;
		this.altitude = altitude;
		this.nbVoies = nbVoies;
		this.hauteurMin = hauteurMin;
		this.hauteurMax = hauteurMax;
		this.longueurTotaleVoies = longueurTotaleVoies;
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

	public Site(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
			NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation, TypeEscalade typeEscalade,
			NiveauEscalade niveauEscalade, Orientation orientation, Massif massif, CarteIgn carteIgn, Commune commune) {
		super();
		this.nomSite = nomSite;
		this.altitude = altitude;
		this.nbVoies = nbVoies;
		this.hauteurMin = hauteurMin;
		this.hauteurMax = hauteurMax;
		this.longueurTotaleVoies = longueurTotaleVoies;
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

	public Site(Long numSite) {
		super();
		this.numSite = numSite;
	}
	
	
	

	
}

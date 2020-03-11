package fr.jeanlouispiera.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("FINF")

public class SiteFicheInfos extends Site{

	private static final long serialVersionUID = 1L;
	private Date dateInfos;
	private String nomVisiteur;
	private String adresseMailVisiteur;
	
	public SiteFicheInfos(Long numSite) {
		super(numSite);
		// TODO Auto-generated constructor stub
	}

	public SiteFicheInfos(Long numSite, Date dateInfos, String nomVisiteur, String adresseMailVisiteur) {
		super(numSite);
		this.dateInfos = dateInfos;
		this.nomVisiteur = nomVisiteur;
		this.adresseMailVisiteur = adresseMailVisiteur;
	}

	public SiteFicheInfos(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
			TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
			CarteIgn carteIgn, Commune commune, String nomVisiteur, String adresseMailVisiteur) {
		super(nomSite, altitude, nbVoies, hauteurMin, hauteurMax, longueurTotaleVoies, niveauDePratique, typeRoche,
				cotation, typeEscalade, niveauEscalade, orientation, massif, carteIgn, commune);
		this.nomVisiteur = nomVisiteur;
		this.adresseMailVisiteur = adresseMailVisiteur;
	}

	public SiteFicheInfos(Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
			TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
			CarteIgn carteIgn, Commune commune, Date dateInfos, String nomVisiteur, String adresseMailVisiteur) {
		super(numSite, nomSite, altitude, nbVoies, hauteurMin, hauteurMax, longueurTotaleVoies, niveauDePratique,
				typeRoche, cotation, typeEscalade, niveauEscalade, orientation, massif, carteIgn, commune);
		this.dateInfos = dateInfos;
		this.nomVisiteur = nomVisiteur;
		this.adresseMailVisiteur = adresseMailVisiteur;
	}

	public Date getDateInfos() {
		return dateInfos;
	}
	public void setDateInfos(Date dateInfos) {
		this.dateInfos = dateInfos;
	}
	public String getNomVisiteur() {
		return nomVisiteur;
	}
	public void setNomVisiteur(String nomVisiteur) {
		this.nomVisiteur = nomVisiteur;
	}
	public String getAdresseMailVisiteur() {
		return adresseMailVisiteur;
	}
	public void setAdresseMailVisiteur(String adresseMailVisiteur) {
		this.adresseMailVisiteur = adresseMailVisiteur;
	}
	
}

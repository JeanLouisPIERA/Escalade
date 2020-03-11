package fr.jeanlouispiera.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FOFF")

public class SiteFicheOfficielle extends Site {

	private static final long serialVersionUID = 1L;
	
	private String tag;

	public SiteFicheOfficielle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SiteFicheOfficielle(Long numSite) {
		super(numSite);
		// TODO Auto-generated constructor stub
	}

	public SiteFicheOfficielle(Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
			TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
			CarteIgn carteIgn, Commune commune, String tag) {
		super(numSite, nomSite, altitude, nbVoies, hauteurMin, hauteurMax, longueurTotaleVoies, niveauDePratique,
				typeRoche, cotation, typeEscalade, niveauEscalade, orientation, massif, carteIgn, commune);
		this.tag = tag;
	}

	public SiteFicheOfficielle(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
			TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
			CarteIgn carteIgn, Commune commune, String tag) {
		super(nomSite, altitude, nbVoies, hauteurMin, hauteurMax, longueurTotaleVoies, niveauDePratique, typeRoche,
				cotation, typeEscalade, niveauEscalade, orientation, massif, carteIgn, commune);
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


}

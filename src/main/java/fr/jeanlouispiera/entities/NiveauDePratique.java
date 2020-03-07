package fr.jeanlouispiera.entities;

public class NiveauDePratique implements Serializable{
	private String nomNiveauPratique;
	private collection<Site> sites ;
	public NiveauDePratique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NiveauDePratique(String nomNiveauPratique) {
		super();
		this.nomNiveauPratique = nomNiveauPratique;
	}
	public String getNomNiveauPratique() {
		return nomNiveauPratique;
	}
	public void setNomNiveauPratique(String nomNiveauPratique) {
		this.nomNiveauPratique = nomNiveauPratique;
	}
	public collection<Site> getSites() {
		return sites;
	}
	public void setSites(collection<Site> sites) {
		this.sites = sites;
	}

	
}

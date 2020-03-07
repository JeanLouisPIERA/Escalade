package fr.jeanlouispiera.entities;

public class NiveauEscalade implements Serializable {
	private String nomNiveauEscalade;
	private Collection<Site> sites;
	public NiveauEscalade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NiveauEscalade(String nomNiveauEscalade) {
		super();
		this.nomNiveauEscalade = nomNiveauEscalade;
	}
	public String getNomNiveauEscalade() {
		return nomNiveauEscalade;
	}
	public void setNomNiveauEscalade(String nomNiveauEscalade) {
		this.nomNiveauEscalade = nomNiveauEscalade;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	
	

}

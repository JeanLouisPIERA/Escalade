package fr.jeanlouispiera.entities;

public class TypeRoche implements Serializable {
	private String nomRoche;
	private Collection<Site> sites ;
	public TypeRoche() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeRoche(String nomRoche) {
		super();
		this.nomRoche = nomRoche;
	}
	public String getNomRoche() {
		return nomRoche;
	}
	public void setNomRoche(String nomRoche) {
		this.nomRoche = nomRoche;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	
	

}

package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

public class Commune implements Serializable{
	private String nomCommune;
	private Departement departement;
	private Collection<Site> sites;
	public Commune() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commune(String nomCommune, Departement departement) {
		super();
		this.nomCommune = nomCommune;
		this.departement = departement;
	}
	public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	

}

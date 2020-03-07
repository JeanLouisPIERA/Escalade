package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

public class Orientation implements Serializable {
	private String nomOrientation;
	private Collection<Site> sites;
	public Orientation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orientation(String nomOrientation) {
		super();
		this.nomOrientation = nomOrientation;
	}
	public String getNomOrientation() {
		return nomOrientation;
	}
	public void setNomOrientation(String nomOrientation) {
		this.nomOrientation = nomOrientation;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	
	

}

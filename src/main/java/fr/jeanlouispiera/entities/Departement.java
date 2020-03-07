package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

public class Departement implements Serializable  {
	private String nomDpt;
	private Region region;
	private Collection <Commune> communes;
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(String nomDpt, Region region) {
		super();
		this.nomDpt = nomDpt;
		this.region = region;
	}
	public String getNomDpt() {
		return nomDpt;
	}
	public void setNomDpt(String nomDpt) {
		this.nomDpt = nomDpt;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Collection<Commune> getCommunes() {
		return communes;
	}
	public void setCommunes(Collection<Commune> communes) {
		this.communes = communes;
	}
	
	
	
	
	

}

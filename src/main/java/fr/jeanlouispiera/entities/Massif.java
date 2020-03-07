package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

public class Massif implements Serializable {
	private String nomMassif;
	private Collection<Site> site;
	public Massif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Massif(String nomMassif) {
		super();
		this.nomMassif = nomMassif;
	}
	public String getNomMassif() {
		return nomMassif;
	}
	public void setNomMassif(String nomMassif) {
		this.nomMassif = nomMassif;
	}
	public Collection<Site> getSite() {
		return site;
	}
	public void setSite(Collection<Site> site) {
		this.site = site;
	}
	
	

}

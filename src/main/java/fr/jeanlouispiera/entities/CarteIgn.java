package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

public class CarteIgn implements Serializable {
	private int numCarte;
	private String nomCarte;
	private Collection <Site> sites;
	public CarteIgn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarteIgn(int numCarte, String nomCarte) {
		super();
		this.numCarte = numCarte;
		this.nomCarte = nomCarte;
	}
	public int getNumCarte() {
		return numCarte;
	}
	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}
	public String getNomCarte() {
		return nomCarte;
	}
	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	
	
	

}

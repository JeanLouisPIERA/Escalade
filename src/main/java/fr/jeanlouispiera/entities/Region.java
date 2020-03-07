package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

public class Region implements Serializable {
	private String nomRegion;
	private Pays pays;
	private Collection <Departement> departements;
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Region(String nomRegion, Pays pays) {
		super();
		this.nomRegion = nomRegion;
		this.pays = pays;
	}
	public String getNomRegion() {
		return nomRegion;
	}
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public Collection<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(Collection<Departement> departements) {
		this.departements = departements;
	}
	
	

}

package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

public class TypeEscalade implements Serializable {
	private String nomTypeEscalade;
	private Collection <Site> sites;
	public TypeEscalade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeEscalade(String nomTypeEscalade) {
		super();
		this.nomTypeEscalade = nomTypeEscalade;
	}
	public String getNomTypeEscalade() {
		return nomTypeEscalade;
	}
	public void setNomTypeEscalade(String nomTypeEscalade) {
		this.nomTypeEscalade = nomTypeEscalade;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	
	

}

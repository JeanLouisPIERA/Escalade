package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class CarteIgn implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeCarte;
	private int numCarte;
	private String nomCarte;
	@OneToMany(mappedBy="carteIgn")
	private Collection <Site> sites;
	public CarteIgn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CarteIgn(Long codeCarte, int numCarte, String nomCarte, Collection<Site> sites) {
		super();
		this.codeCarte = codeCarte;
		this.numCarte = numCarte;
		this.nomCarte = nomCarte;
		this.sites = sites;
	}
	public Long getCodeCarte() {
		return codeCarte;
	}
	public void setCodeCarte(Long codeCarte) {
		this.codeCarte = codeCarte;
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

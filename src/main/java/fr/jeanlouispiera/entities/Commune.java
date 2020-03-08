package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Commune implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeCommune;
	private String nomCommune;
	@ManyToOne
	@JoinColumn(name="DEPT")
	private Departement departement;
	@OneToMany(mappedBy="commune")
	private Collection<Site> sites;
	public Commune() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commune(Long codeCommune, String nomCommune, Departement departement) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.departement = departement;
	}
	public Long getCodeCommune() {
		return codeCommune;
	}
	public void setCodeCommune(Long codeCommune) {
		this.codeCommune = codeCommune;
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

package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class NiveauDePratique implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeNiveauPratique;
	private String nomNiveauPratique;
	@OneToMany(mappedBy="niveauDePratique")
	private Collection<Site> sites ;
	public NiveauDePratique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NiveauDePratique(Long codeNiveauPratique, String nomNiveauPratique, Collection<Site> sites) {
		super();
		this.codeNiveauPratique = codeNiveauPratique;
		this.nomNiveauPratique = nomNiveauPratique;
		this.sites = sites;
	}
	
	public NiveauDePratique(String nomNiveauPratique) {
		super();
		this.nomNiveauPratique = nomNiveauPratique;
	}
	public Long getCodeNiveauPratique() {
		return codeNiveauPratique;
	}
	public void setCodeNiveauPratique(Long codeNiveauPratique) {
		this.codeNiveauPratique = codeNiveauPratique;
	}
	public String getNomNiveauPratique() {
		return nomNiveauPratique;
	}
	public void setNomNiveauPratique(String nomNiveauPratique) {
		this.nomNiveauPratique = nomNiveauPratique;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	

	
}

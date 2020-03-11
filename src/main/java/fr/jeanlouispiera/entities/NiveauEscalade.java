package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class NiveauEscalade implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeNiveauEscalade;
	private String nomNiveauEscalade;
	@OneToMany(mappedBy="niveauEscalade")
	private Collection<Site> sites;
	public NiveauEscalade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NiveauEscalade(Long codeNiveauEscalade, String nomNiveauEscalade) {
		super();
		this.codeNiveauEscalade = codeNiveauEscalade;
		this.nomNiveauEscalade = nomNiveauEscalade;
	}
	public NiveauEscalade(String nomNiveauEscalade) {
		super();
		this.nomNiveauEscalade = nomNiveauEscalade;
	}
	public NiveauEscalade(Long codeNiveauEscalade) {
		super();
		this.codeNiveauEscalade = codeNiveauEscalade;
	}
	
	
	public Long getCodeNiveauEscalade() {
		return codeNiveauEscalade;
	}
	public void setCodeNiveauEscalade(Long codeNiveauEscalade) {
		this.codeNiveauEscalade = codeNiveauEscalade;
	}
	public String getNomNiveauEscalade() {
		return nomNiveauEscalade;
	}
	public void setNomNiveauEscalade(String nomNiveauEscalade) {
		this.nomNiveauEscalade = nomNiveauEscalade;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	
	

}

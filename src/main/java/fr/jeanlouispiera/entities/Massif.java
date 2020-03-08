package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Massif implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeMassif;
	private String nomMassif;
	@OneToMany(mappedBy="massif")
	private Collection<Site> sites;
	public Massif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Massif(Long codeMassif, String nomMassif) {
		super();
		this.codeMassif = codeMassif;
		this.nomMassif = nomMassif;
	}
	public Long getCodeMassif() {
		return codeMassif;
	}
	public void setCodeMassif(Long codeMassif) {
		this.codeMassif = codeMassif;
	}
	public String getNomMassif() {
		return nomMassif;
	}
	public void setNomMassif(String nomMassif) {
		this.nomMassif = nomMassif;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	
	
	

}

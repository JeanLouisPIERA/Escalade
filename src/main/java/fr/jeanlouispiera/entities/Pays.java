package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Pays implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codePays;
	private String nomPays;
	@OneToMany(mappedBy="pays")
	private Collection<Region> regions;
	public Pays() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pays(Long codePays, String nomPays) {
		super();
		this.codePays = codePays;
		this.nomPays = nomPays;
	}
	public Pays(String nomPays) {
		super();
		this.nomPays = nomPays;
	}
	public Pays(Long codePays) {
		super();
		this.codePays = codePays;
	}
	
	
	public Long getCodePays() {
		return codePays;
	}
	public void setCodePays(Long codePays) {
		this.codePays = codePays;
	}
	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	public Collection<Region> getRegions() {
		return regions;
	}
	public void setRegions(Collection<Region> regions) {
		this.regions = regions;
	}
	
	

}

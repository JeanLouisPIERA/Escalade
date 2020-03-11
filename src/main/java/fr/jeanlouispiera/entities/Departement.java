package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Departement implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeDpt;
	private String nomDpt;
	@ManyToOne
	@JoinColumn(name="REGION")
	private Region region;
	@OneToMany(mappedBy="departement")
	private Collection <Commune> communes;
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(Long codeDpt, String nomDpt, Region region) {
		super();
		this.codeDpt = codeDpt;
		this.nomDpt = nomDpt;
		this.region = region;
	}
	public Departement(String nomDpt, Region region) {
		super();
		this.nomDpt = nomDpt;
		this.region = region;
	}
	public Departement(Long codeDpt) {
		super();
		this.codeDpt = codeDpt;
	}
	
	public Long getCodeDpt() {
		return codeDpt;
	}
	public void setCodeDpt(Long codeDpt) {
		this.codeDpt = codeDpt;
	}
	public String getNomDpt() {
		return nomDpt;
	}
	public void setNomDpt(String nomDpt) {
		this.nomDpt = nomDpt;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Collection<Commune> getCommunes() {
		return communes;
	}
	public void setCommunes(Collection<Commune> communes) {
		this.communes = communes;
	}
	
	
	
	
	

}

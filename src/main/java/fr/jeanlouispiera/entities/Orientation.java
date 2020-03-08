package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Orientation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeOrientation;
	private String nomOrientation;
	@OneToMany(mappedBy="orientation")
	private Collection<Site> sites;
	public Orientation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orientation(Long codeOrientation, String nomOrientation) {
		super();
		this.codeOrientation = codeOrientation;
		this.nomOrientation = nomOrientation;
	}
	public Long getCodeOrientation() {
		return codeOrientation;
	}
	public void setCodeOrientation(Long codeOrientation) {
		this.codeOrientation = codeOrientation;
	}
	public String getNomOrientation() {
		return nomOrientation;
	}
	public void setNomOrientation(String nomOrientation) {
		this.nomOrientation = nomOrientation;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	
	

}

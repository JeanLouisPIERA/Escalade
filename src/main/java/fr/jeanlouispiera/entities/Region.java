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
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeRegion;
	private String nomRegion;
	@ManyToOne
	@JoinColumn(name="PAYS")
	private Pays pays;
	@OneToMany(mappedBy="region")
	private Collection <Departement> departements;
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Region(Long codeRegion, String nomRegion, Pays pays) {
		super();
		this.codeRegion = codeRegion;
		this.nomRegion = nomRegion;
		this.pays = pays;
	}
	
	public Region(String nomRegion, Pays pays) {
		super();
		this.nomRegion = nomRegion;
		this.pays = pays;
	}
	public Long getCodeRegion() {
		return codeRegion;
	}
	public void setCodeRegion(Long codeRegion) {
		this.codeRegion = codeRegion;
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

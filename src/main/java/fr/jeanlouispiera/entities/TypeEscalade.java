package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypeEscalade implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeTypeEscalade;
	private String nomTypeEscalade;
	@OneToMany(mappedBy="typeEscalade")
	private Collection <Site> sites;
	public TypeEscalade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeEscalade(Long codeTypeEscalade, String nomTypeEscalade) {
		super();
		this.codeTypeEscalade = codeTypeEscalade;
		this.nomTypeEscalade = nomTypeEscalade;
	}
	public TypeEscalade(String nomTypeEscalade) {
		super();
		this.nomTypeEscalade = nomTypeEscalade;
	}
	public TypeEscalade(Long codeTypeEscalade) {
		super();
		this.codeTypeEscalade = codeTypeEscalade;
	}
	
	
	public Long getCodeTypeEscalade() {
		return codeTypeEscalade;
	}
	public void setCodeTypeEscalade(Long codeTypeEscalade) {
		this.codeTypeEscalade = codeTypeEscalade;
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

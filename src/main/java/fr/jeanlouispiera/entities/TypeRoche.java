package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypeRoche implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeRoche;
	private String nomRoche;
	@OneToMany(mappedBy="typeRoche")
	private Collection<Site> sites ;
	public TypeRoche() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeRoche(Long codeRoche, String nomRoche) {
		super();
		this.codeRoche = codeRoche;
		this.nomRoche = nomRoche;
	}
	
	public TypeRoche(String nomRoche) {
		super();
		this.nomRoche = nomRoche;
	}
	public TypeRoche(Long codeRoche) {
		super();
		this.codeRoche = codeRoche;
	}
	
	
	public Long getCodeRoche() {
		return codeRoche;
	}
	public void setCodeRoche(Long codeRoche) {
		this.codeRoche = codeRoche;
	}
	public String getNomRoche() {
		return nomRoche;
	}
	public void setNomRoche(String nomRoche) {
		this.nomRoche = nomRoche;
	}
	
	
	

}

package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Cotation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeCotation;
	private String refCotationMin;
	private String refCotationMax;
	@OneToMany(mappedBy="cotation")
	private Collection<Site> sites ;
	public Cotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cotation(Long codeCotation, String refCotationMin, String refCotationMax) {
		super();
		this.codeCotation = codeCotation;
		this.refCotationMin = refCotationMin;
		this.refCotationMax = refCotationMax;
	}
	
	public Cotation(String refCotationMin, String refCotationMax) {
		super();
		this.refCotationMin = refCotationMin;
		this.refCotationMax = refCotationMax;
	}
	public Long getCodeCotation() {
		return codeCotation;
	}
	public void setCodeCotation(Long codeCotation) {
		this.codeCotation = codeCotation;
	}
	public String getRefCotationMin() {
		return refCotationMin;
	}
	public void setRefCotationMin(String refCotationMin) {
		this.refCotationMin = refCotationMin;
	}
	public String getRefCotationMax() {
		return refCotationMax;
	}
	public void setRefCotationMax(String refCotationMax) {
		this.refCotationMax = refCotationMax;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	
	
	
	
	
	

}

package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

public class Cotation implements Serializable {
	private String refCotationMin;
	private String refCotationMax;
	private Collection<Site> sites ;
	public Cotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cotation(String refCotationMin, String refCotationMax) {
		super();
		this.refCotationMin = refCotationMin;
		this.refCotationMax = refCotationMax;
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

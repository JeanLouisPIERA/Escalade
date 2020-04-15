package fr.jeanlouispiera.metier;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import fr.jeanlouispiera.entities.Site;

import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteMassif;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;


public interface ISiteMetier {
	
/**
 * INTERFACE METIER. CHAQUE METHODE REPRESENTE UN USE CASE DES FONCTIONNALITES DU SITE ESCALADE	
**/

//1 CRUD SITE
	
	
	//1-1 CREATE SITE  
	    
	    Site createSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation, SiteMassif siteMassif,
				SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag);
	    
	
		Site addSite(Site site);

	//1-2 READ SITE
		Site readSite (long numSite);
	
	//1-3 UPDATE DE SON ESPACE PERSONNEL 
		
		Site updateSite(Site site);
		
	
		
	//1-4 DELETE DE SON ESPACE PERSONNEL
		
		void deleteSite (Long numSite);

	
		
		
//2 SELECTIONNER TOUS LES SITES EXISTANTS A PARTIR D'UNE VALEUR D'ATTRIBUTE EN COMMUN 
      
	//2-1 AFFICHER TOUS LES SITES
		   
		   public Page<Site> findAll(Pageable pageable);

}




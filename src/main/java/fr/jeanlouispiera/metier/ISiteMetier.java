package fr.jeanlouispiera.metier;

import java.util.List;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import fr.jeanlouispiera.entities.Site;

import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteMassif;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;


public interface ISiteMetier {
	
//1 CRUD SITE
	
	
	//1-1 CREATE SITE  
	    
	    Site createSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation, SiteMassif siteMassif,
				SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag);
	    
	
		Site addSite(Site site);

	//1-2 READ SITE
		Site readSite (long numSite);
	
	//1-3 UPDATE DE SON ESPACE PERSONNEL ******** [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
		
		Site updateSite(Site site);
		
		//1-4 DELETE DE SON ESPACE PERSONNEL ******* [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
		void deleteSite (Long numSite);

    
	//2-1 AFFICHER TOUS LES SITES
		   public List<Site> displayAllSites();

		   public Page<Site> findAll(Pageable pageable);
		   
		   public Page<Site> searchAllByNomSite(String nomSite, Pageable pageable);
		   
		   public Page<Site> searchByNomSiteAndSiteMassif(String nomSite, @Param("massif") String massif, Pageable pageable);
		   
		   public Page<Site> searchByNomSiteAndSiteMassifAndSiteCotation(String nomSite, @Param("massif") String massif, @Param("cotation") String cotation,Pageable pageable);

		   
		   }




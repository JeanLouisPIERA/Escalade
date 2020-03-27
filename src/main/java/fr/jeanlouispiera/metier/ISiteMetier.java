package fr.jeanlouispiera.metier;

import java.util.List;

import fr.jeanlouispiera.entities.Site;

import fr.jeanlouispiera.entities.SiteCotation;
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
	    Site createSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation,
			SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag);
	
		Site addSite(Site site);

	//1-2 READ SITE
		Site readSite (Long numSite);
	
	//1-3 UPDATE DE SON ESPACE PERSONNEL ******** [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
		/**public Site updateSite (Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
				int longueurTotaleVoies, SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation,
				SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag);**/
		
		Site update(Long numSite);
		
	
		
		//1-3-1 CREATION D'UN TAG 
		Site createSiteTag (Long numSite, SiteTag siteTag);
		
	//1-4 DELETE DE SON ESPACE PERSONNEL ******* [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
		void deleteSite (Long numSite);

	
		
		
//2 SELECTIONNER TOUS LES SITES EXISTANTS A PARTIR D'UNE VALEUR D'ATTRIBUTE EN COMMUN ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
   public List<Site> searchByNomSite(String nomSite);
   public List<Site> searchByAltitude(int altitude);
   public List<Site> searchByNbVoies(int nbVoies);
   public List<Site> searchByHauteurMin(int hauteurMin);
   public List<Site> searchByHauteurMax(int hauteurMax);
   public List<Site> searchByHauteurlongueurTotalesVoies(int longueurTotaleVoies);
   public List<Site> searchBySiteNiveauDePratique(SiteNiveauDePratique siteNiveauDePratique);
   public List<Site> searchBySiteCotation(SiteCotation siteCotation);
   public List<Site> searchBySiteOrientation(SiteOrientation siteOrientation);
   public List<Site> searchBySiteRegion(SiteRegion siteRegion);
   public List<Site> searchBySiteTypeRoche(SiteTypeRoche siteTypeRoche);
   public List<Site> searchBySiteTag(SiteTag siteTag);
	      
	//2-1 AFFICHER TOUS LES SITES
		   public List<Site> displayAllSites();

   

}





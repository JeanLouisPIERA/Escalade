package fr.jeanlouispiera.metier;

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

	//2 CRUD SITE
	
	//1-1 CREATE DE SON ESPACE PERSONNEL PAR L'UTILISATEUR MEMBRE OU VISITEUR 
	public Site createSite (String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation,
			SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag);

//1-2 READ DE SON ESPACE PERSONNEL ******* [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
	public Site readSite (Long numSite);

//1-3 UPDATE DE SON ESPACE PERSONNEL ******** [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
	public Site updateSite (Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation,
			SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag);

	//1-3-1 UPDATE DE SON ESPACE PERSONNEL ******** [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
		public Site updateSiteTag (Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
				int longueurTotaleVoies, SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation,
				SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag);

	
//1-4 DELETE DE SON ESPACE PERSONNEL ******* [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
	public void deleteUser (Long numSite);
}

package fr.jeanlouispiera.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;

public interface SiteRepository extends JpaRepository<Site, Long>{

	   @Query
	   List<Site> findByNomSite(String nomSite);
	   List<Site> findByAltitude(int altitude);
	   List<Site> findByNbVoies(int nbVoies);
	   List<Site> findByHauteurMin(int hauteurMin);
	   List<Site> findByHauteurMax(int hauteurMax);
	   List<Site> findByLongueurTotaleVoies(int longueurTotaleVoies);
	   List<Site> findBySiteNiveauDePratique(SiteNiveauDePratique siteNiveauDePratique);
	   List<Site> findBySiteCotation(SiteCotation siteCotation);
	   List<Site> findBySiteOrientation(SiteOrientation siteOrientation);
	   List<Site> findBySiteRegion(SiteRegion siteRegion);
	   List<Site> findBySiteTypeRoche(SiteTypeRoche siteTypeRoche);
	   List<Site> findBySiteTag(SiteTag siteTag);


	
	
}

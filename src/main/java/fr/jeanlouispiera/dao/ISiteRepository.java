package fr.jeanlouispiera.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteMassif;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;

@Repository
public interface ISiteRepository extends JpaRepository<Site, Long>{

	   
	   @Query("select s from Site s where s.nomSite like %?1")
	   Page<Site> findByNomSite(String nomSite, Pageable pageable);
	   
	   
	   @Query("select site from Site site where (:siteMassif is null "+" or site.siteMassif like :siteMassif) "+" AND (:nomSite is null "+" or site.nomSite like :nomSite)")
	   Page<Site> findBySiteMassifAndNomSiteNamedParams(@Param("siteMassif")SiteMassif siteMassif, @Param("nomSite")String nomSite, Pageable pageable);
	   
	   @Query("select site from Site site where (:siteMassif is null "+" or site.siteMassif like :siteMassif) "+" AND (:nomSite is null "+" or site.nomSite like :nomSite) "+" AND (:siteCotation is null "+" or site.siteCotation like :siteCotation)")
	   Page<Site> findBySiteMassifAndNomSiteAndCotationNamedParams(@Param("siteMassif")SiteMassif siteMassif, @Param("nomSite")String nomSite, @Param("siteCotation") SiteCotation siteCotation, Pageable pageable);
	   
	   
	   
	  
	   
	
	
}

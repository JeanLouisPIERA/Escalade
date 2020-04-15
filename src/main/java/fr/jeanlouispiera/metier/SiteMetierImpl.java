package fr.jeanlouispiera.metier;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jeanlouispiera.dao.ISiteRepository;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteMassif;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;



@Service
@Transactional
public class SiteMetierImpl implements ISiteMetier{
	@Autowired
	private ISiteRepository iSiteRepository; 

	
	@Override
	public Site addSite(Site site) {
		return iSiteRepository.save(site);
	}
	
	@Override
	public Site createSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
			SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation, SiteMassif siteMassif,
			SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag) {
		Site s = new Site (nomSite, altitude, nbVoies, hauteurMin, hauteurMax,
				longueurTotaleVoies, siteNiveauDePratique, siteCotation, siteMassif,
				siteOrientation, siteRegion, siteTypeRoche, siteTag);
				iSiteRepository.save(s);
		return s;
		
	}
	

	@Override
	public Site readSite(long numSite) {
		Site s = iSiteRepository.findById(numSite).get();
		if(s==null) throw new RuntimeException("Espace site introuvable");
		return s;
	}
	
	@Override
	public Site updateSite(Site site) {
		return iSiteRepository.save(site);
	}

	@Override
	public void deleteSite(Long numSite) {
		iSiteRepository.deleteById(numSite);
		
	}
	
	//********SELECTIONNER LES SITES A PARTIR D'UN ATTRIBUT COMMUN ******** 


	@Override
	public Page<Site> findAll(Pageable pageable) {
		Page<Site> allSites = iSiteRepository.findAll(pageable);
		return allSites;
	}

	


	
	

	

	

	
	
	
	

}

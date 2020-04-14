package fr.jeanlouispiera.metier;

import java.util.List;


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
	public List<Site> searchByNomSite(String nomSite) {
		List<Site> s = iSiteRepository.findByNomSite(nomSite);
		return s;
	}

	@Override
	public List<Site> searchByAltitude(int altitude) {
		List<Site> s = iSiteRepository.findByAltitude(altitude);
		return s;
	}

	@Override
	public List<Site> searchByNbVoies(int nbVoies) {
		List<Site> s = iSiteRepository.findByNbVoies(nbVoies);
		return s;
	}

	@Override
	public List<Site> searchByHauteurMin(int hauteurMin) {
		List<Site> s = iSiteRepository.findByHauteurMin(hauteurMin);
		return s;
	}

	@Override
	public List<Site> searchByHauteurMax(int hauteurMax) {
		List<Site> s = iSiteRepository.findByHauteurMax(hauteurMax);
		return s;
	}
	
	@Override
	public List<Site> searchByHauteurlongueurTotalesVoies(int longueurTotaleVoies) {
		List<Site> s = iSiteRepository.findByLongueurTotaleVoies(longueurTotaleVoies);
		return s;
	}

	@Override
	public List<Site> searchBySiteNiveauDePratique(SiteNiveauDePratique siteNiveauDePratique) {
		List<Site> s = iSiteRepository.findBySiteNiveauDePratique(siteNiveauDePratique);
		return s;
	}

	@Override
	public List<Site> searchBySiteCotation(SiteCotation siteCotation) {
		List<Site> s = iSiteRepository.findBySiteCotation(siteCotation);
		return s;
	}
	
	@Override
	 public List<Site> searchBySiteMassif(SiteMassif siteMassif) {
		List<Site> s = iSiteRepository.findBySiteMassif(siteMassif);
		return s;
		
	}

	@Override
	public List<Site> searchBySiteOrientation(SiteOrientation siteOrientation) {
		List<Site> s = iSiteRepository.findBySiteOrientation(siteOrientation);
		return s;
	}

	@Override
	public List<Site> searchBySiteRegion(SiteRegion siteRegion) {
		List<Site> s = iSiteRepository.findBySiteRegion(siteRegion);
		return s;
	}

	@Override
	public List<Site> searchBySiteTypeRoche(SiteTypeRoche siteTypeRoche) {
		List<Site> s = iSiteRepository.findBySiteTypeRoche(siteTypeRoche);
		return s;
	}

	@Override
	public List<Site> searchBySiteTag(SiteTag siteTag) {
		List<Site> s = iSiteRepository.findBySiteTag(siteTag);
		return s;
	}
	
		
	//*******AFFICHER ET SELECTIONNER LES SITES *****************
		

	@Override
	public List<Site> displayAllSites() {
		List<Site> s = iSiteRepository.findAll();
		return s;
	}


	@Override
	public Page<Site> findAll(Pageable pageable) {
		Page<Site> allSites = iSiteRepository.findAll(pageable);
		return allSites;
	}

	@Override
	public Site createSiteTag(Long numSite, SiteTag siteTag) {
		// TODO Auto-generated method stub
		return null;
	}


	
	

	

	

	
	
	
	

}

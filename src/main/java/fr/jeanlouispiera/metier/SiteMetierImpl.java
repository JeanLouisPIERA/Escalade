package fr.jeanlouispiera.metier;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jeanlouispiera.dao.SiteRepository;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;



@Service
@Transactional
public class SiteMetierImpl implements ISiteMetier{
	@Autowired
	private SiteRepository siteRepository; 

	
	
	
	@Override
	public Site createSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation,
			SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag) {
		Site s = new Site (nomSite, altitude, nbVoies, hauteurMin, hauteurMax,
				longueurTotaleVoies, siteNiveauDePratique, siteCotation,
				siteOrientation, siteRegion, siteTypeRoche, siteTag);
				siteRepository.save(s);
		return s;
		
	}

	@Override
	public Site readSite(Long numSite) {
		Site s = siteRepository.findById(numSite).get();
		if(s==null) throw new RuntimeException("Espace utilisateur introuvable");
		return s;
	}
	

	@Override
	public Site updateSite(Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation,
			SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag) {
		Site s=readSite(numSite);
		s.setAltitude(altitude);
		s.setHauteurMax(hauteurMax);
		s.setHauteurMin(hauteurMin);
		s.setLongueurTotaleVoies(longueurTotaleVoies);
		s.setNbVoies(nbVoies);
		s.setSiteCotation(siteCotation);
		s.setSiteNiveauDePratique(siteNiveauDePratique);
		s.setSiteOrientation(siteOrientation);
		s.setSiteRegion(siteRegion);
		s.setSiteTypeRoche(siteTypeRoche);
		return s;
		
	}
	
	
	@Override
	public Site createSiteTag(Long numSite,  SiteTag siteTag) {
		Site s=readSite(numSite);
		s.setSiteTag(siteTag);
		return s;
	}

	@Override
	public void deleteSite(Long numSite) {
		siteRepository.delete(readSite(numSite));
		
	}
	
	//********SELECTIONNER LES SITES A PARTIR D'UN ATTRIBUT COMMUN ******** 


	@Override
	public List<Site> searchByNomSite(String nomSite) {
		List<Site> s = siteRepository.findByNomSite(nomSite);
		return s;
	}

	@Override
	public List<Site> searchByAltitude(int altitude) {
		List<Site> s = siteRepository.findByAltitude(altitude);
		return s;
	}

	@Override
	public List<Site> searchByNbVoies(int nbVoies) {
		List<Site> s = siteRepository.findByNbVoies(nbVoies);
		return s;
	}

	@Override
	public List<Site> searchByHauteurMin(int hauteurMin) {
		List<Site> s = siteRepository.findByHauteurMin(hauteurMin);
		return s;
	}

	@Override
	public List<Site> searchByHauteurMax(int hauteurMax) {
		List<Site> s = siteRepository.findByHauteurMax(hauteurMax);
		return s;
	}
	
	@Override
	public List<Site> searchByHauteurlongueurTotalesVoies(int longueurTotaleVoies) {
		List<Site> s = siteRepository.findByLongueurTotaleVoies(longueurTotaleVoies);
		return s;
	}

	@Override
	public List<Site> searchBySiteNiveauDePratique(SiteNiveauDePratique siteNiveauDePratique) {
		List<Site> s = siteRepository.findBySiteNiveauDePratique(siteNiveauDePratique);
		return s;
	}

	@Override
	public List<Site> searchBySiteCotation(SiteCotation siteCotation) {
		List<Site> s = siteRepository.findBySiteCotation(siteCotation);
		return s;
	}

	@Override
	public List<Site> searchBySiteOrientation(SiteOrientation siteOrientation) {
		List<Site> s = siteRepository.findBySiteOrientation(siteOrientation);
		return s;
	}

	@Override
	public List<Site> searchBySiteRegion(SiteRegion siteRegion) {
		List<Site> s = siteRepository.findBySiteRegion(siteRegion);
		return s;
	}

	@Override
	public List<Site> searchBySiteTypeRoche(SiteTypeRoche siteTypeRoche) {
		List<Site> s = siteRepository.findBySiteTypeRoche(siteTypeRoche);
		return s;
	}

	@Override
	public List<Site> searchBySiteTag(SiteTag siteTag) {
		List<Site> s = siteRepository.findBySiteTag(siteTag);
		return s;
	}
	
		
	//*******AFFICHER ET SELECTIONNER LES SITES *****************
		

	@Override
	public List<Site> displayAllSites() {
		List<Site> s = siteRepository.findAll();
		return s;
	}

	

	

	

	
	
	
	

}

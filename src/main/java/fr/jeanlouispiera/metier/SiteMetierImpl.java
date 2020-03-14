package fr.jeanlouispiera.metier;

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
		Site s = siteRepository.findById(numSite).orElse(null);
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
	public Site updateSiteTag(Long numSite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax,
			int longueurTotaleVoies, SiteNiveauDePratique siteNiveauDePratique, SiteCotation siteCotation,
			SiteOrientation siteOrientation, SiteRegion siteRegion, SiteTypeRoche siteTypeRoche, SiteTag siteTag) {
		Site s=readSite(numSite);
		s.setSiteTag(siteTag);
		return s;
	}

	@Override
	public void deleteUser(Long numSite) {
		siteRepository.delete(readSite(numSite));
		
	}


	
	
	
	

}

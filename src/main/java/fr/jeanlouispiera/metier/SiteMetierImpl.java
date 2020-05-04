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

	/**
	 * Cette méthode permet de persister le site en base de données
	 */
	@Override
	public Site addSite(Site site) {
		return iSiteRepository.save(site);
	}
	
	/**
	 * Cette méthode permet de créer un jeu de données Site dans le main au lancement de l'application
	 */
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
	
	/**
	 * Cette méthode permet de récupérer les informations en base de données sur un site
	 */
	@Override
	public Site readSite(long numSite) {
		Site s = iSiteRepository.findById(numSite).get();
		if(s==null) throw new RuntimeException("Espace site introuvable");
		return s;
	}
	
	/**
	 * Cette méthode permet de persister en base de données les mise à jour d'un site
	 */
	@Override
	public Site updateSite(Site site) {
		return iSiteRepository.save(site);
	}

	/**
	 * Cette méthode permet de supprimer un site	
	 */
	@Override
	public void deleteSite(Long numSite) {
		iSiteRepository.deleteById(numSite);
		
	}
	
	
	//*******AFFICHER ET SELECTIONNER LES SITES *****************
		
	/**
	 * Cette méthode permet de récupérer tous les sites persistés en base de données
	 */
	@Override
	public List<Site> displayAllSites() {
		List<Site> s = iSiteRepository.findAll();
		return s;
	}

	/**
	 * Cette méthode permet de récupérer tous les sites persistés en base de données sous forme de page
	 */
	@Override
	public Page<Site> findAll(Pageable pageable) {
		Page<Site> allSites = iSiteRepository.findAll(pageable);
		return allSites;
	}
	
	/**
	 * Cette méthode permet de rechercher un site par son nom 
	 */
	@Override
	public Page<Site> searchAllByNomSite(String nomSite, Pageable pageable) {
		Page<Site> sites = iSiteRepository.findByNomSite(nomSite, pageable);
		return sites;
	}

    /**
     * Cette méthode permet de rechercher un site par son nom et par le massif où il se trouve
     */
	@Override
	public Page<Site> searchByNomSiteAndSiteMassif(String nomSite,String massif, Pageable pageable) {
		
		Page<Site> sites = iSiteRepository.findBySiteMassifAndNomSiteNamedParams(SiteMassif.getSiteMassifByText(massif), nomSite,pageable);
		return sites;
	}

	/**
	 * Cette méthode permet de rechercher un site par son nom/son massif et sa cotation	
	 */
	@Override
	public Page<Site> searchByNomSiteAndSiteMassifAndSiteCotation(String nomSite, String massif, String cotation,
			Pageable pageable) {
			Page<Site> sites = iSiteRepository.findBySiteMassifAndNomSiteAndCotationNamedParams(SiteMassif.getSiteMassifByText(massif), nomSite, SiteCotation.getSiteCotationByText(cotation), pageable);
		return sites;
	}
	
}

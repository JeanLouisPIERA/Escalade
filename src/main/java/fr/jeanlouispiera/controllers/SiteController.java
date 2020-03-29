package fr.jeanlouispiera.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteMassif;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;
import fr.jeanlouispiera.metier.ISiteMetier;



@Controller
public class SiteController {
	
	@Autowired
	private ISiteMetier siteMetier; 
	
	
	
	
	@RequestMapping(value= {"/SiteVue"}, method=RequestMethod.GET)
	public String listeSite(Model model){
		List<Site> sites = siteMetier.displayAllSites();
		model.addAttribute("sites",sites);
		return "sites";
	}
	
    @RequestMapping(value = "/SiteVue/{numSite}", method = RequestMethod.GET)
    public String deleteSite(@PathVariable long numSite) {
        siteMetier.deleteSite(numSite);
        return "redirect:/SiteVue";
    }	

    @RequestMapping(value = "/NewSite", method = RequestMethod.GET)
    public String showAddSitePage(ModelMap model) {
        model.addAttribute("site", new Site());
        model.addAttribute("siteRegion", EnumSet.allOf(SiteRegion.class) );
        model.addAttribute("siteNiveauDePratique", EnumSet.allOf(SiteNiveauDePratique.class));
        model.addAttribute("siteCotation", EnumSet.allOf(SiteCotation.class));
        model.addAttribute("siteMassif", EnumSet.allOf(SiteMassif.class));
        model.addAttribute("siteOrientation", EnumSet.allOf(SiteOrientation.class));
        model.addAttribute("siteTypeRoche", EnumSet.allOf(SiteTypeRoche.class));
        model.addAttribute("siteTag", EnumSet.allOf(SiteTag.class));
        return "site";
    }

    @RequestMapping(value = "/NewSite", method = RequestMethod.POST)
    public String addNewSite(Site site){

        siteMetier.addSite(site);
        return "redirect:/SiteVue";
    }
    
}

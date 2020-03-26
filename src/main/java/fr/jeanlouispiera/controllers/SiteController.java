package fr.jeanlouispiera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.jeanlouispiera.entities.Site;
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

    
	
    
}

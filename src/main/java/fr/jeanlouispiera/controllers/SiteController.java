package fr.jeanlouispiera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.metier.ISiteMetier;
import fr.jeanlouispiera.metier.SiteMetierImpl;

@Controller
public class SiteController {
	
	@Autowired
	private SiteMetierImpl siteMetier; 
	
	@RequestMapping(value= {"/SiteVue"}, method=RequestMethod.GET)
	public String listeSite(Model model){
		List<Site> sites = siteMetier.displayAllSites();
		model.addAttribute("sites",sites);
		return "sites";
	}
	
	/**
	@RequestMapping("/SiteVue")
	//public String index() {
		//return "SiteVue";
	//}
	
	//public String read(Model model, Long numSite) {
	public String read(Model model) {
		//model.addAttribute("numSite", numSite);
		try {
			//Site si = siteMetier.readSite(numSite);
			//List<Site> listSites = siteMetier.displayAllSites();
			//model.addAttribute("listSites", listSites.listIterator());
			//model.addAttribute("site", si);
			model.addAttribute("sites", siteMetier.displayAllSites());
		} catch (Exception e) {
			model.addAttribute("exception",e);
		}	
		return "SiteVue";
		
	}**/
	

}

package fr.jeanlouispiera.controllers;

import java.util.EnumSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.jeanlouispiera.entities.Commentaire;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteMassif;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.metier.ICommentaireMetier;
import fr.jeanlouispiera.metier.ISiteMetier;
import fr.jeanlouispiera.metier.ITopoMetier;



@Controller

public class SiteController {
	
	@Autowired
	private ISiteMetier siteMetier; 
	
	@Autowired
	private ICommentaireMetier commentaireMetier;
	
	@Autowired
	private ITopoMetier topoMetier;
	
	
	//****************************** CREATE **********************************************
	
		@RequestMapping(value = "/user/sites/newSite", method = RequestMethod.GET)
	    public String showAddSitePage(ModelMap model) {
	        model.addAttribute("site", new Site());
	        model.addAttribute("siteRegion", EnumSet.allOf(SiteRegion.class) );
	        model.addAttribute("siteNiveauDePratique", EnumSet.allOf(SiteNiveauDePratique.class));
	        model.addAttribute("siteCotation", EnumSet.allOf(SiteCotation.class));
	        model.addAttribute("siteMassif", EnumSet.allOf(SiteMassif.class));
	        model.addAttribute("siteOrientation", EnumSet.allOf(SiteOrientation.class));
	        model.addAttribute("siteTypeRoche", EnumSet.allOf(SiteTypeRoche.class));
	        model.addAttribute("siteTag", EnumSet.allOf(SiteTag.class));
	        return "sites/siteCreation";
	    }
		
		@RequestMapping(value="/user/sites/newSite", method = RequestMethod.POST)
	    public String addNewSite(ModelMap model, Site site, BindingResult result){
			
			if(result.hasErrors()) {
				return "sites/siteCreation";
			}
			
	        Site sitecree = siteMetier.addSite(site);
	        model.addAttribute(sitecree);
			return "sites/siteConfirmation";
	        
	    }
		
		//**************************** READ DES SITES *************************************************
		
		
		@RequestMapping(value="/user/sites",method=RequestMethod.GET)
		public String listeSite(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="4") int size ){
			
			Page<Site> sites = siteMetier.findAll(PageRequest.of(page, size, Sort.unsorted()));
			
			model.addAttribute("sites",sites.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", sites.getNumber());
	        model.addAttribute("totalPages", sites.getTotalPages());
	        model.addAttribute("totalElements", sites.getTotalElements());
	        model.addAttribute("size", sites.getSize());
	        
			return "sites/siteListe";
		}
		
		
		@RequestMapping(value="/user/sitesByMassif",method=RequestMethod.GET)
		public String listeSiteByMassif(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="4") int size ){
		
			Page<Site> sites = siteMetier.findAll(PageRequest.of(page, size, Sort.by("siteMassif").ascending()));
		
			model.addAttribute("sites",sites.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", sites.getNumber());
	        model.addAttribute("totalPages", sites.getTotalPages());
	        model.addAttribute("totalElements", sites.getTotalElements());
	        model.addAttribute("size", sites.getSize());
			
			return "sites/siteListeByMassif";
			
			}
		
		@RequestMapping(value="/user/sitesByCotation",method=RequestMethod.GET)
		public String listeSiteByCotation(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="4") int size ){
		
			Page<Site> sites = siteMetier.findAll(PageRequest.of(page, size, Sort.by("siteCotation").ascending()));
		
			model.addAttribute("sites",sites.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", sites.getNumber());
	        model.addAttribute("totalPages", sites.getTotalPages());
	        model.addAttribute("totalElements", sites.getTotalElements());
	        model.addAttribute("size", sites.getSize());
			
			return "sites/siteListeByCotation";
			
			}
		
		@RequestMapping(value="/user/sitesByNiveau",method=RequestMethod.GET)
		public String listeSiteByNiveau(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="4") int size ){
		
			Page<Site> sites = siteMetier.findAll(PageRequest.of(page, size, Sort.by("siteNiveauDePratique").ascending()));
		
			model.addAttribute("sites",sites.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", sites.getNumber());
	        model.addAttribute("totalPages", sites.getTotalPages());
	        model.addAttribute("totalElements", sites.getTotalElements());
	        model.addAttribute("size", sites.getSize());
			
			return "sites/siteListeByNiveau";
			
			}
		
		@RequestMapping(value="/user/sitesByTag",method=RequestMethod.GET)
		public String listeSiteByTag(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="4") int size ){
		
			Page<Site> sites = siteMetier.findAll(PageRequest.of(page, size, Sort.by("siteTag").ascending()));
		
			model.addAttribute("sites",sites.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", sites.getNumber());
	        model.addAttribute("totalPages", sites.getTotalPages());
	        model.addAttribute("totalElements", sites.getTotalElements());
	        model.addAttribute("size", sites.getSize());
			
			return "sites/siteListeByTag";
			
			}
		
		@RequestMapping(value="/user/sitesByNom",method=RequestMethod.GET)
		public String listeSiteByNom(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="4") int size ){
		
			Page<Site> sites = siteMetier.findAll(PageRequest.of(page, size, Sort.by("nomSite").ascending()));
		
			model.addAttribute("sites",sites.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", sites.getNumber());
	        model.addAttribute("totalPages", sites.getTotalPages());
	        model.addAttribute("totalElements", sites.getTotalElements());
	        model.addAttribute("size", sites.getSize());
			
			return "sites/siteListeByNom";
			
			}
		
		//*************************** READ UN SITE ************************************************
		
		
		@RequestMapping(value="/user/sites/{numSite}", method = RequestMethod.GET)
		public String readSite(ModelMap model, @PathVariable long numSite) {
			Site site = siteMetier.readSite(numSite);
			model.addAttribute(site);
			
			List<Commentaire> commentaires = commentaireMetier.findCommentairesBySite(site);
			model.addAttribute("commentaires", commentaires);
			
			model.addAttribute("commentaire", new Commentaire(site));	
			
			List<Topo> topos = topoMetier.findToposBySite(site);
			model.addAttribute("topos", topos);
			
			return "sites/siteView";
		}
		
		
		@RequestMapping(value="/user/sites/{numSite}", method = RequestMethod.POST)
		public String addCommentaireSite(ModelMap model, Site site, Commentaire commentaire) {
			
			Commentaire newComment= commentaireMetier.addCommentaire(commentaire);
			model.addAttribute(newComment);
			
			return "redirect:/user/sites/{numSite}";
		}
		
		@RequestMapping(value="/user/sites/{numSite}/{numCommentaire}", method = RequestMethod.GET)
		public String deleteCommentaireSite(ModelMap model, Site site, Commentaire commentaire, @PathVariable Long numCommentaire) {
			
			commentaireMetier.deleteCommentaire(numCommentaire);
			
			return "redirect:/user/sites/{numSite}";
		}
			
	    // ***************************** UPDATE ******************************************
	    
	    @RequestMapping(value="/user/sites/updateSite/{numSite}", method = RequestMethod.GET)
	    public String ShowSitePageToUpdate(ModelMap model, @PathVariable long numSite) {
	    
	    	model.addAttribute("site", new Site());
	    	model.addAttribute("siteRegion", EnumSet.allOf(SiteRegion.class) );
	        model.addAttribute("siteNiveauDePratique", EnumSet.allOf(SiteNiveauDePratique.class));
	        model.addAttribute("siteCotation", EnumSet.allOf(SiteCotation.class));
	        model.addAttribute("siteMassif", EnumSet.allOf(SiteMassif.class));
	        model.addAttribute("siteOrientation", EnumSet.allOf(SiteOrientation.class));
	        model.addAttribute("siteTypeRoche", EnumSet.allOf(SiteTypeRoche.class));
	        model.addAttribute("siteTag", EnumSet.allOf(SiteTag.class));
	        Site site = siteMetier.readSite(numSite); 
			model.addAttribute("site", site);
	    	return "sites/siteEdition";
	    	
	    }
	    
	    @RequestMapping(value = "/user/sites/updateSite/{numSite}", method = RequestMethod.POST)
	    public String addNewSiteToUpdate(ModelMap model, Site site){
	
	    	Site siteupdate = siteMetier.addSite(site);
	        model.addAttribute(siteupdate);
	        siteMetier.updateSite(site);
	        return "sites/siteConfirmation";
	    }
	    
	    
	    
	    
	    
    	//************************ DELETE ****************************************
		
	    @RequestMapping(value = "/admin/sites/deleteSite/{numSite}", method = RequestMethod.GET)
	    public String deleteSite(@PathVariable long numSite) {
	        siteMetier.deleteSite(numSite);
	        return "redirect:/user/sites";
	
	    }	
}

package fr.jeanlouispiera.controllers;

import java.util.EnumSet;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.jeanlouispiera.dao.ISiteRepository;
import fr.jeanlouispiera.entities.Commentaire;
import fr.jeanlouispiera.entities.Reservation;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteMassif;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.User;
import fr.jeanlouispiera.metier.ICommentaireMetier;
import fr.jeanlouispiera.metier.IReservationMetier;
import fr.jeanlouispiera.metier.ISiteMetier;
import fr.jeanlouispiera.metier.ITopoMetier;
import fr.jeanlouispiera.metier.IUserService;



@Controller

public class SiteController {
	
	@Autowired
	private ISiteMetier siteMetier; 
	
	@Autowired
	private ISiteRepository siteRepository;
	
	@Autowired
	private ICommentaireMetier commentaireMetier;
	
	@Autowired
	private ITopoMetier topoMetier;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IReservationMetier reservationMetier;
	
	
	//****************************** CREATE **********************************************
	
		/**
		 * Cette méthode permet à l'utilisateur loggé d'afficher le formulaire de création d'un nouveau site
		 * @param model
		 * @return
		 */
	
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
		
		/**
		 * Cette méthode permet à l'utilisateur loggé de créer le nouveau site
		 * @param model
		 * @param site
		 * @param result
		 * @return
		 */
		
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
		
		
		/**
		 * Cette méthode permet à l'utilisateur loggé d'afficher la liste de tous les sites repertoriés sur le 
		 * site web des Amis de l'Escalade.
		 * La taille par défaut de la page d'affichage est de 3 sites. 
		 * @param model
		 * @param page
		 * @param size
		 * @return
		 */
		
		@RequestMapping(value="/user/sites",method=RequestMethod.GET)
		public String listeSite(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="3") int size){
			
			Page<Site> sites = siteMetier.findAll(PageRequest.of(page, size, Sort.unsorted()));
			
			model.addAttribute("sites",sites.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", sites.getNumber());
	        model.addAttribute("totalPages", sites.getTotalPages());
	        model.addAttribute("totalElements", sites.getTotalElements());
	        model.addAttribute("size", sites.getSize());
	        
			return "sites/siteListe";
		}
		
		/**
		 * Cette méthode permet de sélectionner les sites affichés avec une recherche multicritères sur le Nom,
		 * le Massif et la cotation.
		 * La sélection peut être réalisée sur 1, 2 ou 3 critères.
		 * @param model
		 * @param page
		 * @param size
		 * @param nomSite
		 * @param massif
		 * @param cotation
		 * @return
		 */
		
		@RequestMapping(value="/user/sites/trisites",method=RequestMethod.GET)
		public String listeSiteSelectedBy(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="3") int size, @RequestParam(name="nomSite", defaultValue="") String nomSite
				,@RequestParam(name="massif", defaultValue="")String massif, @RequestParam(name="cotation", defaultValue="")String cotation){
						
			Page<Site> sites = siteMetier.searchByNomSiteAndSiteMassifAndSiteCotation("%"+nomSite+"%", massif,cotation,PageRequest.of(page, size, Sort.unsorted()) );
			
			model.addAttribute("sites",sites.getContent());
			
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", sites.getNumber());
	        model.addAttribute("totalPages", sites.getTotalPages());
	        model.addAttribute("totalElements", sites.getTotalElements());
	        model.addAttribute("size", sites.getSize());
	        
			return "sites/siteListe";
		}
		
		
		//*************************** READ UN SITE ************************************************
		
		/**
		 * Cette méthode permet d'appeler la fiche de présentation d'un site
		 * @param model
		 * @param numSite
		 * @return
		 */
		
		@RequestMapping(value="/user/sites/{numSite}", method = RequestMethod.GET)
		public String readSite(ModelMap model, @PathVariable long numSite) {
			Site site = siteMetier.readSite(numSite);
			model.addAttribute(site);
			
			List<Commentaire> commentaires = commentaireMetier.findCommentairesBySite(site);
			model.addAttribute("commentaires", commentaires);
			
			model.addAttribute("commentaire", new Commentaire());	
			
			List<Topo> topos = topoMetier.findToposBySite(site);
			model.addAttribute("topos", topos);
			
			return "sites/siteView";
		}
		
		/**
		 * Cette méthode permet à l'utilisateur loggé de créer un commentaire.
		 * Ce commentaire lui est automatiquement attribué.
		 * La date de création est enregistrée automatiquement. 
		 * @param commentaire
		 * @param model
		 * @param site
		 * @return
		 */
		@RequestMapping(value="/user/sites/{numSite}", method = RequestMethod.POST)
		public String addCommentaireSite(Commentaire commentaire, ModelMap model, Site site) {
			
			UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User userInLogged = userService.findByUsername(userdetails.getUsername());
	        commentaire.setUser(userInLogged);
	        commentaire.setSite(site);
			
			Commentaire newComment= commentaireMetier.addCommentaire(commentaire);
			
			model.addAttribute("commentaire", newComment);
			
			return "redirect:/user/sites/{numSite}";
		}
		
		/**
		 * Cette méthode permet d'afficher le textarea du commentaire à modifier 
		 * @param model
		 * @param numSite
		 * @param numCommentaire
		 * @return
		 */
		
		@RequestMapping(value="/user/sites/update/{numSite}/{numCommentaire}", method = RequestMethod.GET)
		public String displayToUpdateCommentaireSite(ModelMap model, @PathVariable long numSite, @PathVariable long numCommentaire) {
			
			UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User userInLogged = userService.findByUsername(userdetails.getUsername());
			Boolean moderation = false;
			if (userInLogged.getRole().getName().getCode().equals("ADMIN")) {
				moderation = true;
				model.addAttribute("moderation", moderation);}
			
			Site site = siteMetier.readSite(numSite);
			model.addAttribute(site);
			
			List<Commentaire> commentaires = commentaireMetier.findCommentairesBySite(site);
			model.addAttribute("commentaires", commentaires);
			
			model.addAttribute("commentaire", new Commentaire());	
			
			List<Topo> topos = topoMetier.findToposBySite(site);
			model.addAttribute("topos", topos);
			
			
			Commentaire commentaireToUpdate = commentaireMetier.readCommentaire(numCommentaire);
			model.addAttribute("commentaire", commentaireToUpdate);
			
			return "sites/siteView";
		}
		
		/**
		 * Cette méthode permet de modérer un commentaire 
		 * @param model
		 * @param commentaire
		 * @return
		 */
		
		@RequestMapping(value="/user/sites/update/{numSite}/{numCommentaire}", method = RequestMethod.POST)
		public String updateCommentaireSite(ModelMap model, Commentaire commentaire) {
			
			UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User userInLogged = userService.findByUsername(userdetails.getUsername());
			
			commentaire.setUser(userInLogged);
					
			Commentaire commentaireUpdate = commentaireMetier.addCommentaire(commentaire);
			
			model.addAttribute("commentaire", commentaireUpdate);
			commentaireMetier.updateCommentaire(commentaire);
		
			return "redirect:/user/sites/{numSite}";
			
		}
		
		/**
		 * Cette méthode permet de supprimer un commentaire.
		 * @param model
		 * @param site
		 * @param commentaire
		 * @param numCommentaire
		 * @return
		 */
		
		@RequestMapping(value="/user/sites/{numSite}/{numCommentaire}", method = RequestMethod.GET)
		public String deleteCommentaireSite(ModelMap model, Site site, Commentaire commentaire, @PathVariable Long numCommentaire) {
			
			commentaireMetier.deleteCommentaire(numCommentaire);
			
			return "redirect:/user/sites/{numSite}";
		}
			
	    // ***************************** UPDATE ******************************************
	    
	    /**
	     * Cette méthode permet d'appeler le support de mise à jour d'un site et de le renseigner des informations
	     * disponibles dans la base de données;
	     * @param model
	     * @param numSite
	     * @return
	     */
		
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
	    
		
		/**
		 * Cette méthode permet de mettre à jour une ou plusieurs des attributs d'un site d'escalade
		 * @param model
		 * @param site
		 * @return
		 */
	    @RequestMapping(value = "/user/sites/updateSite/{numSite}", method = RequestMethod.POST)
	    public String addNewSiteToUpdate(ModelMap model, Site site){
	
	    	Site siteupdate = siteMetier.addSite(site);
	        model.addAttribute(siteupdate);
	        siteMetier.updateSite(site);
	        return "sites/siteConfirmation";
	    }
	    
	    
	    
	    
	    
    	//************************ DELETE ****************************************
		
	    /**
	     * Cette méthode détruit d'abord tous les commentaires, tous les topos et leurs réservations 
	     * persistés sur un site avant de détruire le site lui-même (Respect des propriétés ACID)
	     * @param numSite
	     * @return
	     */
	    
	    @RequestMapping(value = "/admin/sites/deleteSite/{numSite}", method = RequestMethod.GET)
	    public String deleteSite(@PathVariable long numSite) {
	    	
	    	Site siteToDelete = siteMetier.readSite(numSite);
	    	
	    	List<Commentaire> commentairesToDelete = commentaireMetier.findCommentairesBySite(siteToDelete);
	    	for (Commentaire commentaireToDelete : commentairesToDelete) {
    		Long numCommentaireToDelete = commentaireToDelete.getNumCommentaire();
	    	commentaireMetier.deleteCommentaire(numCommentaireToDelete);
	    	}
	    	
	    	List<Topo> toposToDelete = topoMetier.findToposBySite(siteToDelete);
	    	for (Topo topoToDelete : toposToDelete) {
	    		Long codeTopoToDelete = topoToDelete.getCodeTopo();
	    		List<Reservation> reservationsToDelete = reservationMetier.findReservationByTopo(topoToDelete);
	    		for (Reservation reservationToDelete : reservationsToDelete) {
	    			Long numReservationToDelete = reservationToDelete.getNumReservation();
	    			reservationMetier.deleteReservation(numReservationToDelete);
	    			}
	    		topoMetier.deleteTopo(codeTopoToDelete);
		    	}
	    	
	    	siteMetier.deleteSite(numSite);
	        
	        return "redirect:/user/sites/trisites";
	
	    }	
	    
}

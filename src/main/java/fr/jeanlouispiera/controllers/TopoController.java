package fr.jeanlouispiera.controllers;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;

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

import fr.jeanlouispiera.entities.Reservation;
import fr.jeanlouispiera.entities.ReservationReponse;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.User;
import fr.jeanlouispiera.metier.IReservationMetier;
import fr.jeanlouispiera.metier.ISecurityService;
import fr.jeanlouispiera.metier.ISiteMetier;
import fr.jeanlouispiera.metier.ITopoMetier;
import fr.jeanlouispiera.metier.IUserService;

@Controller
public class TopoController {
	
	@Autowired
	private ISiteMetier siteMetier; 
	
	@Autowired
	private ITopoMetier topoMetier;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IReservationMetier reservationMetier;
	
	@Autowired
	private ISecurityService securityService; 
	
	
	
	
	//****************************** CREATE **********************************************
	
		/**
		 * Cette méthode permet d'appeler le formulaire de création d'un topo
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "/user/topos/newTopo", method = RequestMethod.GET)
	    public String showAddTopoPage(ModelMap model) {
			
			List<Site> sites = siteMetier.displayAllSites();
			model.addAttribute("sites", sites);
			
			Topo t = new Topo();
			
	        model.addAttribute("topo", t);
	        
	        model.addAttribute("topoStatut", EnumSet.allOf(TopoStatut.class) );
	        
	        return "topos/topoCreation";
	    }
		
		/**
		 * Cette méthode permet de valider les informations saisies pour la création d'un topo
		 * @param model
		 * @param topo
		 * @param result
		 * @return
		 */
		
		@RequestMapping(value="/user/topos/newTopo", method = RequestMethod.POST)
	    public String addNewTopo(ModelMap model, Topo topo, BindingResult result){
			
			if(result.hasErrors()) {
				return "topos/topoCreation";
			}
			
			UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User userInLogged = userService.findByUsername(userdetails.getUsername());
	        topo.setUser(userInLogged);
	        Topo t = topoMetier.addTopo(topo);
	        model.addAttribute("topo", t);
	        model.addAttribute("user", userInLogged);
	        
			return "topos/topoConfirmation";
	        
	    }
		
		//**************************** READ DES TOPOS *************************************************
		
		/**
		 * Cette méthode permet d'afficher les topos de tous les membres de l'association sous la forme de pages.
		 * La taille par défaut de chacune de ces pages est de 3 topos.
		 * @param model
		 * @param page
		 * @param size
		 * @return
		 */
		@RequestMapping(value="/user/topos",method=RequestMethod.GET)
		public String listeTopo(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="3") int size ){
			
			Page<Topo> topos = topoMetier.findAll(PageRequest.of(page, size, Sort.unsorted()));
			
			model.addAttribute("topos",topos.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", topos.getNumber());
	        model.addAttribute("totalPages", topos.getTotalPages());
	        model.addAttribute("totalElements", topos.getTotalElements());
	        model.addAttribute("size", topos.getSize());
	        
			return "topos/topoListe";
		}
		
		
		/**
		 * Cette méthode permet à un utilisateur loggé de n'afficher que ses propres topos
		 * @param model
		 * @param page
		 * @param size
		 * @return
		 */
		@RequestMapping(value="/user/topos/mesTopos",method=RequestMethod.GET)
		public String maListeTopo(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="3") int size ){
			
			UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User userInLogged = userService.findByUsername(userdetails.getUsername());
			
			Page<Topo> topos = topoMetier.findByUser(userInLogged, PageRequest.of(page, size, Sort.unsorted()));
			
			model.addAttribute("topos",topos.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", topos.getNumber());
	        model.addAttribute("totalPages", topos.getTotalPages());
	        model.addAttribute("totalElements", topos.getTotalElements());
	        model.addAttribute("size", topos.getSize());
	        
			return "topos/topoMaListe";
		}
		
		/**
		 * Cette méthode permet d'afficher tous les topos triés par statut de disponibilité
		 * @param model
		 * @param page
		 * @param size
		 * @return
		 */
						
		@RequestMapping(value="/user/toposByStatut",method=RequestMethod.GET)
		public String listeSiteByStatut(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="3") int size ){
		
			Page<Topo> topos = topoMetier.findAll(PageRequest.of(page, size, Sort.by("topoStatut").ascending()));
		
			model.addAttribute("topos",topos.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", topos.getNumber());
	        model.addAttribute("totalPages", topos.getTotalPages());
	        model.addAttribute("totalElements", topos.getTotalElements());
	        model.addAttribute("size", topos.getSize());
			
			return "topos/topoListeByStatut";
			
			}
		
		
	
		//*************************** READ UN TOPO ************************************************
		
				/**
				 * Cette méthode permet d'afficher la fiche de présentation d'un topo
				 * @param model
				 * @param codeTopo
				 * @return
				 */
		
				@RequestMapping(value="/user/topos/{codeTopo}", method = RequestMethod.GET)
				public String readTopo(ModelMap model, @PathVariable long codeTopo) {
					Topo topo = topoMetier.readTopo(codeTopo);
					model.addAttribute(topo);
					
					return "topos/topoView";
				}
				
					
			    // ***************************** UPDATE ******************************************
			    
				/**
				 * Cette méthode permet d'afficher le formulaire de mise à jour d'un topo
				 * @param model
				 * @param codeTopo
				 * @return
				 */
				
			    @RequestMapping(value="/user/topos/updateTopo/{codeTopo}", method = RequestMethod.GET)
			    public String ShowTopoPageToUpdate(ModelMap model, @PathVariable long codeTopo) {
			    
			    	model.addAttribute("topo", new Topo());
			    	model.addAttribute("topoStatut", EnumSet.allOf(TopoStatut.class) );
			        Topo topo = topoMetier.readTopo(codeTopo);
					model.addAttribute("topo", topo);
			    	return "topos/topoEdition";
			    	
			    }
			    
			    /**
			     * Cette méthode permet de valider les informations d'un topo mis à jour
			     * @param model
			     * @param topo
			     * @return
			     */
			    @RequestMapping(value = "/user/topos/updateTopo/{codeTopo}", method = RequestMethod.POST)
			    public String addNewTopoToUpdate(ModelMap model, Topo topo){
			
			    	Topo topoupdate = topoMetier.addTopo(topo);
			        model.addAttribute(topoupdate);
			        topoMetier.updateTopo(topo);
			        return "topos/topoConfirmation";
			    }
			    
			    
			    /**
			     * Cette méthode permet de modifier le statut d'un topo INDISPONIBLE et de le passer en disponible
			     * @param model
			     * @param codeTopo
			     * @return
			     */
			    @RequestMapping(value = "/user/topos/updateStatutTopo/{codeTopo}", method = RequestMethod.GET)
			    public String updateStatusFromNdisToDis(ModelMap model, @PathVariable long codeTopo){
			    	
			    	
			    	model.addAttribute("topoStatut", EnumSet.allOf(TopoStatut.class) );
			    	Topo topo = topoMetier.readTopo(codeTopo);
			    	topo.setTopoStatut(TopoStatut.DIS);
			    	topoMetier.addTopo(topo);
					model.addAttribute("topo", topo);
			    	
			        return "topos/topoDisponible";
			    }
			    
			    /**
			     * Cette méthode permet de demander la réservation d'un topo DISPONIBLE 
			     * @param model
			     * @param codeTopo
			     * @return
			     */
			    
			    @RequestMapping(value="/user/topos/demandeReservation/{codeTopo}", method = RequestMethod.GET)
			    public String addDemandeReservation(ModelMap model, @PathVariable long codeTopo) {
			    	model.addAttribute("topo", new Topo());
			    	model.addAttribute("topoStatut", EnumSet.allOf(TopoStatut.class) );
			        Topo topo = topoMetier.readTopo(codeTopo);
					model.addAttribute("topo", topo);
					
					Reservation reservation = new Reservation();
					model.addAttribute("reservation", reservation);
					
					UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					User userInLogged = userService.findByUsername(userdetails.getUsername());
			        reservation.setUser(userInLogged);
			        reservation.setTopo(topo);
			        reservation.setReservationReponse(ReservationReponse.ENCOURS);
			        reservation.setDateDemande(new Date());
					
			        Reservation newReservation = reservationMetier.demanderReservation(reservation);
			        
					model.addAttribute("reservation", newReservation);	
			    	
			    	return "reservations/reservationDemandeConfirmation";
			    }
			    
			    
		    	//************************ DELETE ****************************************
				
			    
			    /**
			     * Cette méthode permet à un utilisateur de détruire ses topos
			     * Cette méthode détruit d'abord toutes les réservations persistées sur un topo 
			     * avant de détruire le site lui-même (Respect des propriétés ACID)
			     * @param numSite
			     * @param codeTopo
			     * @return
			     */
			    @RequestMapping(value = "/user/topos/mes Topos/deleteTopo/{codeTopo}", method = RequestMethod.GET)
			    public String deleteMonTopo(@PathVariable long codeTopo) {
			    	
			    	Topo topoToDelete = topoMetier.readTopo(codeTopo);
			    	
			    	List<Reservation> reservationsToDelete = reservationMetier.findReservationByTopo(topoToDelete);
		    		for (Reservation reservationToDelete : reservationsToDelete) {
		    			Long numReservationToDelete = reservationToDelete.getNumReservation();
		    			reservationMetier.deleteReservation(numReservationToDelete);
		    			}
			    	
			        topoMetier.deleteTopo(codeTopo);
			        return "redirect:/user/topos";
			
			    }	

		
			    /**
			     * Cette méthode permet à un administrateur de supprimer un topos
			     * Cette méthode détruit d'abord toutes les réservations persistées sur un topo 
			     * avant de détruire le site lui-même (Respect des propriétés ACID)
			     * @param codeTopo
			     * @return
			     */
			    @RequestMapping(value = "/admin/topos/deleteTopo/{codeTopo}", method = RequestMethod.GET)
			    public String deleteTopo(@PathVariable long codeTopo) {
			    	
		    		Topo topoToDelete = topoMetier.readTopo(codeTopo);
			    	
			    	List<Reservation> reservationsToDelete = reservationMetier.findReservationByTopo(topoToDelete);
		    		for (Reservation reservationToDelete : reservationsToDelete) {
		    			Long numReservationToDelete = reservationToDelete.getNumReservation();
		    			reservationMetier.deleteReservation(numReservationToDelete);
		    			}
			        topoMetier.deleteTopo(codeTopo);
			        return "redirect:/user/topos";
			
			    }	
		
		
		

}

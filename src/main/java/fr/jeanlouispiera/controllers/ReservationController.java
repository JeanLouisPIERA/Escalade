package fr.jeanlouispiera.controllers;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.jeanlouispiera.entities.Reservation;
import fr.jeanlouispiera.entities.ReservationReponse;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.User;
import fr.jeanlouispiera.metier.IReservationMetier;
import fr.jeanlouispiera.metier.ITopoMetier;
import fr.jeanlouispiera.metier.IUserService;


@Controller
public class ReservationController {
	
	@Autowired
	private IReservationMetier reservationMetier;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ITopoMetier topoMetier;
	
	
	//**************************** READ DE MES RESERVATION *************************************************
	
			/**
			 * Cette méthode permet à l'utilisateur loggé de consulter ses demandes de réservations en cours et d'afficher les demandes 
			 * de réservation des autres membres pour ses propres topos.
			 * Elle retourne la jsp reservationListe
			 * @param model
			 * @param page
			 * @param size
			 * @return
			 */
			@RequestMapping(value="/user/reservations",method=RequestMethod.GET)
			public String listeTopo(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
					@RequestParam(name="size", defaultValue="3") int size ){
				
				UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				User userInLogged = userService.findByUsername(userdetails.getUsername());
				
				model.addAttribute("user", userInLogged);
		        
				Page<Reservation> reservations = reservationMetier.consulterReponseMesDemandesReservation(userdetails.getUsername(), PageRequest.of(page, size, Sort.unsorted()));
										
				model.addAttribute("reservations",reservations.getContent());
				model.addAttribute("page", Integer.valueOf(page));
				model.addAttribute("number", reservations.getNumber());
		        model.addAttribute("totalPages", reservations.getTotalPages());
		        model.addAttribute("totalElements", reservations.getTotalElements());
		        model.addAttribute("size", reservations.getSize());
		        
		        Page<Reservation> demandeReservations = reservationMetier.afficherDemandesReservation(userdetails.getUsername(), PageRequest.of(page, size, Sort.unsorted()));

		        model.addAttribute("demandeReservations",demandeReservations.getContent());
				model.addAttribute("page", Integer.valueOf(page));
				model.addAttribute("number", demandeReservations.getNumber());
		        model.addAttribute("totalPages", demandeReservations.getTotalPages());
		        model.addAttribute("totalElements", demandeReservations.getTotalElements());
		        model.addAttribute("size", demandeReservations.getSize());
		        
				return "reservations/reservationListe";
			}
			
			

			//**************************** UPDATE *************************************************	
			
			/**
			 * Cette méthode permet à l'utilisateur loggé de donner son accord à une demande de réservation et de 
			 * générer une mise à jour automatique du statut de son topo en Non Disponible 
			 * @param model
			 * @param numReservation
			 * @return
			 */
			
			@RequestMapping(value="/user/reservations/{numReservation}", method = RequestMethod.GET)
		    public String addDemandeReservation(ModelMap model, @PathVariable long numReservation) {
		    	
		    	model.addAttribute("reservationReponse", EnumSet.allOf(ReservationReponse.class) );
				Reservation demandeReservation = reservationMetier.readReservation(numReservation);
				demandeReservation.setReservationReponse(ReservationReponse.ACCORD);				
				
				Reservation accordReservation = reservationMetier.updateReservation(demandeReservation);
				model.addAttribute("demandeReservation", accordReservation);
				
				
				Topo topoAvecDecisionAccord = accordReservation.getTopo();
				topoAvecDecisionAccord.setTopoStatut(TopoStatut.NDIS);
				
				Topo topoStatutIndisponible = topoMetier.updateTopo(topoAvecDecisionAccord);
				model.addAttribute("topo", topoStatutIndisponible);
				
		    	return "reservations/reservationDemandeAccord";
		    }
			
			//************************ DELETE ****************************************
			
			@RequestMapping(value="/user/reservations/deleteReservation/{numReservation}", method = RequestMethod.GET)
			public String deleteMaReservation(@PathVariable Long numReservation) {
				
				reservationMetier.deleteReservation(numReservation);
				
				return "redirect:/user/reservations";
				
			}
			
}

package fr.jeanlouispiera.controllers;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.metier.ICommentaireMetier;
import fr.jeanlouispiera.metier.ISiteMetier;
import fr.jeanlouispiera.metier.ITopoMetier;

@Controller
public class TopoController {
	
	@Autowired
	private ISiteMetier siteMetier; 
	
	@Autowired
	private ICommentaireMetier commentaireMetier;
	
	@Autowired
	private ITopoMetier topoMetier;
	
	
	//****************************** CREATE **********************************************
	
		@RequestMapping(value = "/user/topos/newTopo", method = RequestMethod.GET)
	    public String showAddTopoPage(ModelMap model) {
	        model.addAttribute("topo", new Topo());
	        model.addAttribute("topoStatut", EnumSet.allOf(TopoStatut.class) );
	        return "topos/topoCreation";
	    }
		
		@RequestMapping(value="/user/topos/newTopo", method = RequestMethod.POST)
	    public String addNewTopo(ModelMap model, Topo topo, BindingResult result){
			
			if(result.hasErrors()) {
				return "topos/topoCreation";
			}
			
	        Topo t = topoMetier.addTopo(topo);
	        model.addAttribute(t);
			return "topos/topoConfirmation";
	        
	    }
		
		//**************************** READ DES SITES *************************************************
		
		
		@RequestMapping(value="/user/topos",method=RequestMethod.GET)
		public String listeTopo(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="4") int size ){
			
			Page<Topo> topos = topoMetier.findAll(PageRequest.of(page, size, Sort.unsorted()));
			
			model.addAttribute("topos",topos.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", topos.getNumber());
	        model.addAttribute("totalPages", topos.getTotalPages());
	        model.addAttribute("totalElements", topos.getTotalElements());
	        model.addAttribute("size", topos.getSize());
	        
			return "topos/topoListe";
		}
		
		
		@RequestMapping(value="/user/toposBySite",method=RequestMethod.GET)
		public String listeSiteByMassif(ModelMap model, @RequestParam(name="page", defaultValue="0") int page, 
				@RequestParam(name="size", defaultValue="4") int size ){
		
			Page<Topo> topos = topoMetier.findAll(PageRequest.of(page, size, Sort.by("site").ascending()));
		
			model.addAttribute("topos",topos.getContent());
			model.addAttribute("page", Integer.valueOf(page));
			model.addAttribute("number", topos.getNumber());
	        model.addAttribute("totalPages", topos.getTotalPages());
	        model.addAttribute("totalElements", topos.getTotalElements());
	        model.addAttribute("size", topos.getSize());
			
			return "topos/topoListeBySite";
			
			}
	
	

}

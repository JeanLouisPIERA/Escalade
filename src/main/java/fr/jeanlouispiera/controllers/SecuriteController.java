package fr.jeanlouispiera.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecuriteController {
	
	/**private String getLoggedinUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }**/
	
	private String getLoggedinUserName() {
        Object principal = SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }
	
	@RequestMapping(value="/login")
	public String login(ModelMap model) {
		 model.put("name", getLoggedinUserName());
		return "login";
	}
	
	@RequestMapping(value = "/")
    public String showAccueilSitesPage() {
        //model.put("name", getLoggedinUserName());
        return "accueil";
    }
	
	
	
	/**@RequestMapping(value="/")
	public String home(ModelMap model) {
		 model.put("name", getLoggedinUserName());
		return "accueil";
	}**/
	
	/**
	 @RequestMapping(value = "/SiteVue", method = RequestMethod.GET)
	    public String showAccueilSitesPage(ModelMap model) {
	        model.put("name", getLoggedinUserName());
	        return "accueilSites";
	    }**/

	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,
        HttpServletResponse response) {

        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();           

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response,
                authentication);
        }

        return "redirect:/login";
    }

}

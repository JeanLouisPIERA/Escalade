package fr.jeanlouispiera.controllers;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.jeanlouispiera.entities.User;
import fr.jeanlouispiera.metier.ISecurityService;
import fr.jeanlouispiera.metier.IUserService;
import fr.jeanlouispiera.validator.UserValidator;

@Controller
public class UserController {

@Autowired
private IUserService userService;
@Autowired
private ISecurityService securityService;

@Autowired
private UserValidator userValidator;

/**
 * Cette méthode permet d'afficher le formulaire d'inscription d'un nouvel utilisateur
 * @param model
 * @return
 */
@RequestMapping(value = "/registration", method = RequestMethod.GET)
public String registration(Model model) {
    model.addAttribute("userForm", new User());

    return "registration";
}

/**
 * Cette méthode permet d'enregistrer le formulaire d'inscription d'un nouveau membre
 * @param userForm
 * @param bindingResult
 * @param model
 * @return
 */

@RequestMapping(value = "/registration", method = RequestMethod.POST)
public String registration(@ModelAttribute("userForm") User userForm, 
 BindingResult bindingResult, Model model) {
    userValidator.validate(userForm, bindingResult);

    if (bindingResult.hasErrors()) {
        return "registration";
    }

    userService.save(userForm);

    securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

    return "registrationOk";
}

/**
 * Cette méthode permet d'afficher le formulaire de login
 * @param model
 * @param error
 * @param logout
 * @return
 */
@RequestMapping(value = "/login", method = RequestMethod.GET)
public String login(Model model, String error, String logout) {
    if (error != null)
        model.addAttribute("error", "Votre nom d'utilisateur et/ou votre mot de passe sont invalides.");

    if (logout != null)
        model.addAttribute("message", "Vous avez bien été déconnecté.");

    return "login";
}


/**
 * Cette méthode gère l'affichage de la page accueil
 * @param model
 * @return
 */
@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
public String welcome(Model model) {
    return "accueil";
}

}
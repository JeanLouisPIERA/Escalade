package fr.jeanlouispiera;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.SiteCotation;
import fr.jeanlouispiera.entities.SiteNiveauDePratique;
import fr.jeanlouispiera.entities.SiteOrientation;
import fr.jeanlouispiera.entities.SiteRegion;
import fr.jeanlouispiera.entities.SiteTag;
import fr.jeanlouispiera.entities.SiteTypeRoche;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.Utilisateur;
import fr.jeanlouispiera.metier.ISiteMetier;
import fr.jeanlouispiera.metier.ITopoMetier;
import fr.jeanlouispiera.metier.IUtilisateurMetier;



@SpringBootApplication
public class EscaladeApplication implements CommandLineRunner {
	
	@Autowired
	private IUtilisateurMetier utilisateurMetier;
	@Autowired
	private ITopoMetier topoMetier;
	@Autowired
	private ISiteMetier siteMetier;
		
	public static void main(String[] args) throws Exception{
		SpringApplication.run(EscaladeApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		Utilisateur u1 = utilisateurMetier.createUser("Jean", "jeannot@gmail.com", "jj56p");
		Utilisateur u2 = utilisateurMetier.createUser("Bob", "bobby@gmail.com", "42f56");
		Utilisateur u3 = utilisateurMetier.createUser("Charles","charlot@yahoo.fr", "hgf56r");
		utilisateurMetier.updateUser((long) 1, "new_password");
		//utilisateurMetier.deleteUser((long) 2);
		Utilisateur u4 = utilisateurMetier.createUser("Charlemagne", "aixlachapelle@yahoo.fr", "gtpo87");
		Site s1 = siteMetier.createSite("Ailefroide", 1500, 500, 4, 500, 8000, SiteNiveauDePratique.CONFIRME, SiteCotation.C41, SiteOrientation.NE, SiteRegion.AUV, SiteTypeRoche.GRANIT, SiteTag.AMIS);
		Site s2 = siteMetier.createSite("Valgorge", 800, 60, 5, 5, 600, SiteNiveauDePratique.DEBUTANT, SiteCotation.C51, SiteOrientation.SO, SiteRegion.AUV, SiteTypeRoche.GRANIT, SiteTag.PAS); 
		topoMetier.createTopo("420 itinéraires", "Oisans sauvage Livre Est", "Jean-Michel Cambon", "2011", 15, 30, "français", 250, TopoStatut.DIS, u1, s1);
		topoMetier.createTopo("Esacalade en Briançonnais", "Haute Vallée de la Durance et Queyras", "Yann, Martine et Jean-jacques Rolland","2012", 20, 20, "français", 130, TopoStatut.DEM, u4, s1);
		topoMetier.createTopo("Valgorge", "site récent", "castelbloc@gmail.com","2010", 15, 30, "français", 250, TopoStatut.PEC, u2, s2);
		
		
		//topoMetier.searchByNomTopo("420 itinéraires");
	    //topoMetier.requestBooking((long) 7);
		//topoMetier.confirmBooking((long) 8);
		//topoMetier.endBooking((long) 9);
	    }
	
	
	    
}




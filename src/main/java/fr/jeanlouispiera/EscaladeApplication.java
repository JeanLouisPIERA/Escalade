package fr.jeanlouispiera;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.Utilisateur;
import fr.jeanlouispiera.metier.ICommentaireMetier;
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
	@Autowired
	private ICommentaireMetier commentaireMetier;
		
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
		Site s1 = siteMetier.createSite("Ailefroide", 1500, 500, 4, 500, 8000, SiteNiveauDePratique.CONFIRME, SiteCotation.C41, SiteMassif.ALP ,SiteOrientation.NE, SiteRegion.AUV, SiteTypeRoche.GRANIT, SiteTag.AMIS);
		Site s2 = siteMetier.createSite("Valgorge", 800, 60, 5, 5, 600, SiteNiveauDePratique.DEBUTANT, SiteCotation.C51, SiteMassif.ARD,SiteOrientation.SO, SiteRegion.AUV, SiteTypeRoche.GRANIT, SiteTag.PAS); 
		Site s3 = siteMetier.createSite("Tolser", 1600, 430, 120, 600, 2880, SiteNiveauDePratique.CONFIRME, SiteCotation.C43, SiteMassif.JUR, SiteOrientation.S, SiteRegion.AUV, SiteTypeRoche.GNEISS, SiteTag.PAS);	
		Site s4 = siteMetier.createSite("Sincrista", 1800, 50, 50, 900, 3200, SiteNiveauDePratique.SPORTIF, SiteCotation.C85, SiteMassif.PYR, SiteOrientation.N, SiteRegion.OCC, SiteTypeRoche.CALCAIRE, SiteTag.AMIS);
		Topo t1= topoMetier.createTopo("420 itinéraires", "Oisans sauvage Livre Est", "Jean-Michel Cambon", "2011", 15, 30, "français", 250, TopoStatut.DIS, u1, s1);
		Topo t2 =topoMetier.createTopo("Esacalade en Briançonnais", "Haute Vallée de la Durance et Queyras", "Yann, Martine et Jean-jacques Rolland","2012", 20, 20, "français", 130, TopoStatut.DEM, u4, s1);
		Topo t3 =topoMetier.createTopo("Valgorge", "site récent", "castelbloc@gmail.com","2010", 15, 30, "français", 250, TopoStatut.PEC, u2, s2);
		Commentaire c1=commentaireMetier.createCommentaire("Super site",new Date(),"Super site pour s'éclater en famille et progresser en technique", u1, t1, s1);
		
		//topoMetier.searchByNomTopo("420 itinéraires");
	    //topoMetier.requestBooking((long) 7);
		//topoMetier.confirmBooking((long) 8);
		//topoMetier.endBooking((long) 9);
	    }
	
	
	    
}




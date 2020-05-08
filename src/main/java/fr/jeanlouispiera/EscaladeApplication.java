package fr.jeanlouispiera;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.jeanlouispiera.dao.RoleRepository;
import fr.jeanlouispiera.entities.Commentaire;
import fr.jeanlouispiera.entities.Role;
import fr.jeanlouispiera.entities.RoleEnum;
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
import fr.jeanlouispiera.entities.User;
import fr.jeanlouispiera.metier.ICommentaireMetier;
import fr.jeanlouispiera.metier.ISiteMetier;
import fr.jeanlouispiera.metier.ITopoMetier;
import fr.jeanlouispiera.metier.IUserService;




@SpringBootApplication
public class EscaladeApplication implements CommandLineRunner {
	
	@Autowired
	private IUserService userservice;
	@Autowired
	private ITopoMetier topoMetier;
	@Autowired
	private ISiteMetier siteMetier;
	@Autowired
	private ICommentaireMetier commentaireMetier;
	
	@Autowired
	private RoleRepository iRoleRepository;
		
	public static void main(String[] args) throws Exception{
		SpringApplication.run(EscaladeApplication.class, args);
	}

	/*
	 * Implementation du Command Line Runner
	 * Mise en place d'un jeu de données en base au lancement de l'application en mode create de jpa hibernate en 
	 * application properties
	 */
	
	@Override
	public void run(String... args) throws Exception {


		Role admin = new Role(RoleEnum.ADMIN);
		Role user = new Role(RoleEnum.USER);
		iRoleRepository.save(admin);
		iRoleRepository.save(user);
		
		User u1 = userservice.createUser("Jean-Jacques");
		User u2 = userservice.createUser("Bobby120");
		User u3 = userservice.createUser("Henri-Charles");
		User u4 = userservice.createUser("Charlemagne");
		
		Site s1 = siteMetier.createSite("Ailefroide", 1500, 500, 4, 500, 8000, SiteNiveauDePratique.CONFIRME, SiteCotation.C41, SiteMassif.ALP ,SiteOrientation.NE, SiteRegion.AUV, SiteTypeRoche.GRANIT, SiteTag.AMIS);
		Site s2 = siteMetier.createSite("Valgorge", 800, 60, 5, 5, 600, SiteNiveauDePratique.DEBUTANT, SiteCotation.C51, SiteMassif.ARD,SiteOrientation.SO, SiteRegion.AUV, SiteTypeRoche.GRANIT, SiteTag.PAS); 
		Site s3 = siteMetier.createSite("Tolser", 1600, 430, 120, 600, 2880, SiteNiveauDePratique.CONFIRME, SiteCotation.C43, SiteMassif.JUR, SiteOrientation.S, SiteRegion.AUV, SiteTypeRoche.GNEISS, SiteTag.PAS);	
		Site s4 = siteMetier.createSite("Sincrista", 1800, 50, 50, 900, 3200, SiteNiveauDePratique.SPORTIF, SiteCotation.C85, SiteMassif.PYR, SiteOrientation.N, SiteRegion.OCC, SiteTypeRoche.CALCAIRE, SiteTag.AMIS);
		Topo t1= topoMetier.createTopo("420 itinéraires", "Oisans sauvage Livre Est", "Jean-Michel Cambon", "2011", 15, 30, "français", 250, TopoStatut.DIS, u1, s1, "jeannot@gmail.com");
		Topo t2 =topoMetier.createTopo("Esacalade en Briançonnais", "Haute Vallée de la Durance et Queyras", "Yann, Martine et Jean-jacques Rolland","2012", 20, 20, "français", 130, TopoStatut.NDIS, u4, s1, "charlemagne@yahoo.fr");
		Topo t3 =topoMetier.createTopo("Valgorge", "site récent", "castelbloc@gmail.com","2010", 15, 30, "français", 250, TopoStatut.NDIS, u2, s2, "bobby120@hotmail.fr");
		Topo t4= topoMetier.createTopo("Les voies de Sincrista", "Vallées Corses", "Jean-Michel Cambon", "2016", 20, 25, "français/anglais", 125, TopoStatut.DIS, u3, s4, "henricharles@gmail.com");
		Topo t5 =topoMetier.createTopo("Sincrista Valley", "Journey in Corsica", " Roll Kurtz","2006", 25, 25, "english/german", 90, TopoStatut.NDIS, u2, s4, "bobby120@hotmail.fr");
		Topo t6 =topoMetier.createTopo("Randos sur Tolse", "Versant Nord", "Kolk & Sanders","2019", 15, 30, "français", 250, TopoStatut.NDIS, u1, s3, "jeannot@gmail.com");		
		Commentaire c1=commentaireMetier.createCommentaire("Super site",new Date(),"Super site pour s'éclater en famille et progresser en technique", u1, t1, s1);
		
		User administrateur = userservice.createAdmin("admin10"); 
	

	}
	    
}




package fr.jeanlouispiera;

import java.util.Date;

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
public class EscaladeApplication implements CommandLineRunner{
	
	@Autowired
	private IUtilisateurMetier utilisateurMetier;
	@Autowired
	private ITopoMetier topoMetier;
	@Autowired
	private ISiteMetier siteMetier;
	public static void main(String[] args) {
		SpringApplication.run(EscaladeApplication.class, args);
		/**ApplicationContext ctx=SpringApplication.run(EscaladeApplication.class, args);
		UtilisateurRepository utilisateurRepository=(UtilisateurRepository) ctx.getBean(UtilisateurRepository.class);
		utilisateurRepository.save(new Utilisateur("Jean", "jeannot@gmail.com", "jj56p"));**/
	}

	@Override
	public void run(String... args) throws Exception {
		/**Utilisateur u1=utilisateurRepository.save(new Utilisateur("Jean", "jeannot@gmail.com", "jj56p"));
		Utilisateur u2=utilisateurRepository.save(new Utilisateur("Bob", "bobby@gmail.com", "42f56"));
		TypeRoche tr1=typeRocheRepository.save(new TypeRoche("granit"));
		TypeEscalade ty1=typeEscaladeRepository.save(new TypeEscalade("Bloc Falaise"));
		TypeEscalade ty2=typeEscaladeRepository.save(new TypeEscalade("Bloc"));
		TypeEscalade ty3=typeEscaladeRepository.save(new TypeEscalade("Falaise"));
		CarteIgn ca1=carteIgnRepository.save(new CarteIgn("1:25000:3537ET", "L'Argentière-la-Bessée"));
		CarteIgn ca2=carteIgnRepository.save(new CarteIgn("1:25000:2838OT", "Largentière-Labastide"));
		Cotation co1=cotationRepository.save(new Cotation("3a", "8a"));
		Cotation co2=cotationRepository.save(new Cotation("4+", "8a+"));
		Massif ma1=massifRepository.save(new Massif("Les Ecrins"));
		Massif ma2=massifRepository.save(new Massif("Monts d'Ardèche"));
		NiveauDePratique np1=niveauDePratiqueRepository.save(new NiveauDePratique("Confirmé"));
		NiveauDePratique np2=niveauDePratiqueRepository.save(new NiveauDePratique("Grand Débutant"));
		NiveauEscalade ne1=niveauEscaladeRepository.save(new NiveauEscalade("Sportif-Engagé"));
		NiveauEscalade ne2=niveauEscaladeRepository.save(new NiveauEscalade("Kids welcome"));
		Orientation or1=orientationRepository.save(new Orientation("Toutes"));
		Pays pa1=paysRepository.save(new Pays("France"));
		Region re1=regionRepository.save(new Region("Rhone-Alpes Auvergne", pa1));
		Departement de1=departementRepository.save(new Departement("Hautes-Alpes 05", re1));
		Departement de2=departementRepository.save(new Departement("Ardèche 07", re1));
		Commune com1=communeRepository.save(new Commune("L'argentière la Bessière", de1));
		Commune com2=communeRepository.save(new Commune("Valgorge Saint Martin", de2));
		Site si1=siteRepository.save(new Site("Ailefroide", 1500, 500, 4, 400, 8000, SiteNiveauDePratique.DEBUTANT, null, null, tr1, co1, ty1, ne1, or1, ma1, ca1, com1));
		Site si2=siteRepository.save(new Site("Valgorge", 800, 60, 5, 5, 600, SiteNiveauDePratique.valueOf("SPORTIF"), null, null, tr1, co2, ty2, ne2, or1, ma2, ca2, com2));
		Topo to1=topoRepository.save(new Topo("420 itinéraires", "Oisans sauvage Livre Est", "Jean-Michel Cambon","2011", 15, 30, "français", 250, "prêt en cours",u1,si1));
		Topo to2=topoRepository.save(new Topo("Esacalade en Briançonnais", "Haute Vallée de la Durance et Queyras", "Yann, Martine et Jean-jacques Rolland","2012", 20, 20, "français", 130, "disponible",u1,si1));
		Topo to3=topoRepository.save(new Topo("Valgorge", "site récent", "castelbloc@gmail.com","2010", 15, 30, "français", 250, "disponible",u1,si2));
		Commentaire comm1=commentaireRepository.save(new Commentaire("Un site grandiose", new Date(), "J'en suis à ma 15ème rando dans ce massif et je le recommande à tous !",u1, to1,si1 ));
		Commentaire comm2=commentaireRepository.save(new Commentaire("Attention propriété privée", new Date(), "Je signale à tout le monde que le site se trouve sur une propriété privée dans une chaitaigneraie. Interdit de dormir sur place, de faire du feu et de ramasser des chataignes !",u2, to3,si2 ));
	
		/**escaladeMetier.createUserM("Charles","charlot@yahoo.fr", "hgf56r");
		//escaladeMetier.updateUser((long) 31, "new_password_de_charlot");
		escaladeMetier.deleteUser((long) 1);
		escaladeMetier.createUserV("Charlemagne", "aixlachapelle@yahoo.fr", "gtpo87");
		//escaladeMetier.updateUser((long) 32, "DWBHMan");**/
		
		Utilisateur u1 = utilisateurMetier.createUser("Jean", "jeannot@gmail.com", "jj56p");
		Utilisateur u2 = utilisateurMetier.createUser("Bob", "bobby@gmail.com", "42f56");
		Utilisateur u3 = utilisateurMetier.createUser("Charles","charlot@yahoo.fr", "hgf56r");
		utilisateurMetier.updateUser((long) 1, "new_password");
		utilisateurMetier.deleteUser((long) 2);
		Utilisateur u4 = utilisateurMetier.createUser("Charlemagne", "aixlachapelle@yahoo.fr", "gtpo87");
		Site s1 = siteMetier.createSite("Ailefroide", 1500, 500, 4, 500, 8000, SiteNiveauDePratique.CONFIRME, SiteCotation.C41, SiteOrientation.NE, SiteRegion.AUV, SiteTypeRoche.GRANIT, SiteTag.AMIS);
		Site s2 = siteMetier.createSite("Valgorge", 800, 60, 5, 5, 600, SiteNiveauDePratique.DEBUTANT, SiteCotation.C51, SiteOrientation.SO, SiteRegion.AUV, SiteTypeRoche.GRANIT, SiteTag.PAS); 
		topoMetier.createTopo("420 itinéraires", "Oisans sauvage Livre Est", "Jean-Michel Cambon", "2011", 15, 30, "français", 250, TopoStatut.PEC, u1, s1);
		topoMetier.createTopo("Esacalade en Briançonnais", "Haute Vallée de la Durance et Queyras", "Yann, Martine et Jean-jacques Rolland","2012", 20, 20, "français", 130, TopoStatut.DIS, u4, s1);
	    topoMetier.createTopo("Valgorge", "site récent", "castelbloc@gmail.com","2010", 15, 30, "français", 250, TopoStatut.DEM, u2, s2);
		
	   // utilisateurMetier.createUser("Jean", "jeannot@gmail.com", "mot_de_passe_de_jean");
	}
}



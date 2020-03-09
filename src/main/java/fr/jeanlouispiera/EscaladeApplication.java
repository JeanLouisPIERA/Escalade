package fr.jeanlouispiera;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.jeanlouispiera.dao.CarteIgnRepository;
import fr.jeanlouispiera.dao.CommentaireRepository;
import fr.jeanlouispiera.dao.CommuneRepository;
import fr.jeanlouispiera.dao.CotationRepository;
import fr.jeanlouispiera.dao.DepartementRepository;
import fr.jeanlouispiera.dao.MassifRepository;
import fr.jeanlouispiera.dao.NiveauDePratiqueRepository;
import fr.jeanlouispiera.dao.NiveauEscaladeRepository;
import fr.jeanlouispiera.dao.OrientationRepository;
import fr.jeanlouispiera.dao.PaysRepository;
import fr.jeanlouispiera.dao.RegionRepository;
import fr.jeanlouispiera.dao.SiteRepository;
import fr.jeanlouispiera.dao.TopoRepository;
import fr.jeanlouispiera.dao.TypeEscaladeRepository;
import fr.jeanlouispiera.dao.TypeRocheRepository;
import fr.jeanlouispiera.dao.UtilisateurRepository;
import fr.jeanlouispiera.entities.CarteIgn;
import fr.jeanlouispiera.entities.Commentaire;
import fr.jeanlouispiera.entities.Commune;
import fr.jeanlouispiera.entities.Cotation;
import fr.jeanlouispiera.entities.Departement;
import fr.jeanlouispiera.entities.Massif;
import fr.jeanlouispiera.entities.NiveauDePratique;
import fr.jeanlouispiera.entities.NiveauEscalade;
import fr.jeanlouispiera.entities.Orientation;
import fr.jeanlouispiera.entities.Pays;
import fr.jeanlouispiera.entities.Region;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TypeEscalade;
import fr.jeanlouispiera.entities.TypeRoche;
import fr.jeanlouispiera.entities.Utilisateur;
import fr.jeanlouispiera.entities.UtilisateurMembre;
import fr.jeanlouispiera.entities.UtilisateurVisiteur;

@SpringBootApplication
public class EscaladeApplication implements CommandLineRunner{
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private TypeRocheRepository typeRocheRepository;
	@Autowired
	private TypeEscaladeRepository typeEscaladeRepository;
	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private PaysRepository paysRepository;
	@Autowired
	private OrientationRepository orientationRepository;
	@Autowired
	private NiveauEscaladeRepository niveauEscaladeRepository;
	@Autowired
	private NiveauDePratiqueRepository niveauDePratiqueRepository;
	@Autowired
	private MassifRepository massifRepository;
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private CotationRepository cotationRepository;
	@Autowired
	private CommuneRepository communeRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private CarteIgnRepository carteIgnRepository;
	public static void main(String[] args) {
		SpringApplication.run(EscaladeApplication.class, args);
		/**ApplicationContext ctx=SpringApplication.run(EscaladeApplication.class, args);
		UtilisateurRepository utilisateurRepository=(UtilisateurRepository) ctx.getBean(UtilisateurRepository.class);
		utilisateurRepository.save(new Utilisateur("Jean", "jeannot@gmail.com", "jj56p"));**/
	}

	@Override
	public void run(String... args) throws Exception {
		Utilisateur u1=utilisateurRepository.save(new UtilisateurMembre("Jean", "jeannot@gmail.com", "jj56p"));
		Utilisateur u2=utilisateurRepository.save(new UtilisateurVisiteur("Bob", "bobby@gmail.com", "42f56"));
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
		Site si1=siteRepository.save(new Site("Ailefroide", 1500, 500, 4, 400, 8000, "Officiel Les Amis de l'escalade", np1, tr1, co1, ty1, ne1, or1, ma1, ca1, com1));
		Site si2=siteRepository.save(new Site("Valgorge", 800, 60, 5, 5, 600, "", np2, tr1, co2, ty2, ne2, or1, ma2, ca2, com2));
		Topo to1=topoRepository.save(new Topo("420 itinéraires", "Oisans sauvage Livre Est", "Jean-Michel Cambon","2011", 15, 30, "français", 250, "prêt en cours",u1,si1));
		Topo to2=topoRepository.save(new Topo("Esacalade en Briançonnais", "Haute Vallée de la Durance et Queyras", "Yann, Martine et Jean-jacques Rolland","2012", 20, 20, "français", 130, "disponible",u1,si1));
		Topo to3=topoRepository.save(new Topo("Valgorge", "site récent", "castelbloc@gmail.com","2010", 15, 30, "français", 250, "disponible",u1,si2));
		Commentaire comm1=commentaireRepository.save(new Commentaire("Un site grandiose", new Date(), "J'en suis à ma 15ème rando dans ce massif et je le recommande à tous !",u1, to1,si1 ));
		Commentaire comm2=commentaireRepository.save(new Commentaire("Attention propriété privée", new Date(), "Je signale à tout le monde que le site se trouve sur une propriété privée dans une chaitaigneraie. Interdit de dormir sur place, de faire du feu et de ramasser des chataignes !",u2, to3,si2 ));
		}
	

}


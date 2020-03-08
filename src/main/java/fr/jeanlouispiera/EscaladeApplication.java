package fr.jeanlouispiera;

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
import fr.jeanlouispiera.entities.Commune;
import fr.jeanlouispiera.entities.Cotation;
import fr.jeanlouispiera.entities.Massif;
import fr.jeanlouispiera.entities.NiveauDePratique;
import fr.jeanlouispiera.entities.NiveauEscalade;
import fr.jeanlouispiera.entities.Orientation;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TypeEscalade;
import fr.jeanlouispiera.entities.TypeRoche;
import fr.jeanlouispiera.entities.Utilisateur;

@SpringBootApplication
public class EscaladeApplication implements CommandLineRunner{
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private TypeRocheRepository typeRocheRepository;
	@Autowired
	private TypeEscaladeRepository typeEscaladeRepository;
	/**
	@Autowired
	private TopoRepository topoRepository;
	private SiteRepository siteRepository;
	private RegionRepository regionRepository;
	private PaysRepository paysRepository;
	private OrientationRepository orientationRepository;
	private NiveauEscaladeRepository niveauEscaladeRepository;
	private NiveauDePratiqueRepository niveauDePratiqueRepository;
	private MassifRepository massifRepository;
	private DepartementRepository departementRepository;
	private CotationRepository cotationRepository;
	private CommuneRepository communeRepository;
	private CommentaireRepository commentaireRepository;
	private CarteIgnRepository carteIgnRepository;**/
	public static void main(String[] args) {
		SpringApplication.run(EscaladeApplication.class, args);
		/**ApplicationContext ctx=SpringApplication.run(EscaladeApplication.class, args);
		UtilisateurRepository utilisateurRepository=(UtilisateurRepository) ctx.getBean(UtilisateurRepository.class);
		utilisateurRepository.save(new Utilisateur("Jean", "jeannot@gmail.com", "jj56p"));**/
	}

	@Override
	public void run(String... args) throws Exception {
		Utilisateur u1=utilisateurRepository.save(new Utilisateur("Jean", "jeannot@gmail.com", "jj56p"));
		Utilisateur u2=utilisateurRepository.save(new Utilisateur("Bob", "bobby@gmail.com", "42f56"));
		TypeRoche tr1=typeRocheRepository.save(new TypeRoche("granit"));
		TypeEscalade ty1=typeEscaladeRepository.save(new TypeEscalade("Rocher"));
		//CarteIgn
		//Cotation
		//Massif
		//NiveauDePratique
		//NiveauEscalade
		//Orientation
		//Pays
		//Region
		//Departement
		//Commune
		//TypeEscalade
		/**Topo topo1=topoRepository.save(new Topo("420 itinéraires", "Oisans sauvage Livre Est", "Jean-Michel Cambon","2011", 15, 30, "français", 250, "prêt en cours",u1,site1));
		Site site1=siteRepository.save(new Site("Ailefroide"), 1500, 500, 4, 400, "Ailefroide", "Débutant à Surconfirmé",  );
				public Site(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
						String tag, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
						TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
						CarteIgn carteIgn, Commune commune)**/
		//Commentaire
	
	

}
}

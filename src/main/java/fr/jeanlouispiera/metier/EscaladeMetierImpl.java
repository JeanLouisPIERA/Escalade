package fr.jeanlouispiera.metier;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jeanlouispiera.dao.CarteIgnRepository;
import fr.jeanlouispiera.dao.CommentaireRepository;
import fr.jeanlouispiera.dao.CommuneRepository;
import fr.jeanlouispiera.dao.DepartementRepository;
import fr.jeanlouispiera.dao.CotationRepository;
import fr.jeanlouispiera.dao.MassifRepository;
import fr.jeanlouispiera.dao.NiveauDePratiqueRepository;
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
@Service
@Transactional
public class EscaladeMetierImpl implements IEscaladeMetier {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private NiveauDePratiqueRepository niveauDePratiqueRepository;
	@Autowired
	private TypeRocheRepository typeRocheRepository;
	@Autowired
	private CotationRepository cotationRepository;
	@Autowired
	private TypeEscaladeRepository typeEscaladeRepository;
	
	
	
	// ********** CRUD UTILISATEUR **********
	
	@Override
	public void createUserM(String nomUtilisateur, String adresseMail, String passWord) {
		utilisateurRepository.save(new UtilisateurMembre(nomUtilisateur, adresseMail, passWord));
	}

	@Override
	public void createUserV(String nomUtilisateur, String adresseMail, String passWord) {
		utilisateurRepository.save(new UtilisateurVisiteur(nomUtilisateur, adresseMail, passWord));
	}
	
	@Override
	public Utilisateur readUser(Long codeUtilisateur) {
		Utilisateur u=utilisateurRepository.findById(codeUtilisateur).orElse(null);
		if(u==null) throw new RuntimeException("Espace utilisateur introuvable");
		return u;
	}

	@Override
	public void updateUser(Long codeUtilisateur, String passWord) {
		Utilisateur u=readUser(codeUtilisateur);
		u.setPassWord(passWord);
	}
	
	@Override
	public void deleteUser(Long codeUtilisateur) {
		Utilisateur u = readUser(codeUtilisateur);
		utilisateurRepository.delete(u);
	}
	
	
	//********** CRUD SITE FICHE OFFICIELLE**********
	
	@Override
	public void createSiteFO (String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
			Long codeNiveauDePratique, Long codeRoche, Long codeCotation, 
			Long codeTypeEscalade, Long codeNiveauEscalade, Long codeOrientation, Long codeMassif,
			Long codeCarte, Long codeCommune, String tag)  {
	}

	@Override
	public Site readSiteFicheOfficielle(Long numSite) {
		return null;
	}

	@Override
	public void updateSiteFO(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
			Long codeNiveauDePratique, Long codeRoche, Long codeCotation, 
			Long codeTypeEscalade, Long codeNiveauEscalade, Long codeOrientation, Long codeMassif,
			Long codeCarte, Long codeCommune, String tag) {
		
	}
	
	@Override
	public void createTagSiteFO(Long numSite, String tag) {
		
	}
	
	@Override
	public void deleteSiteFO(Long numSite) {
		// TODO Auto-generated method stub
		
	}
	
	// ********** CRUD SITE FICHE INFOS **********
	
	@Override
	public void createSiteFI(Long numsite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
			Long codeNiveauDePratique, Long codeRoche, Long codeCotation, 
			Long codeTypeEscalade, Long codeNiveauEscalade, Long codeOrientation, Long codeMassif,
			Long codeCarte, Long codeCommune, Date dateInfos, String nomVisiteur, String adresseMailVisiteur){
	
		// TODO Auto-generated method stub
	}

	@Override
	public Site readSiteFI(Long numsite) {
		return null;
	}
	
	public void updateSiteFI(Long numsite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
			Long codeNiveauDePratique, Long codeRoche, Long codeCotation, 
			Long codeTypeEscalade, Long codeNiveauEscalade, Long codeOrientation, Long codeMassif,
			Long codeCarte, Long codeCommune, Date dateInfos, String nomVisiteur, String adresseMailVisiteur) {
		
	}
	
	public void deleteSiteFI(Long numSite) {
		
	}

	

	//******************************
	
	@Override
	public void createComment(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
			Long codeUtilisateur, Long codeTopo, Long numSite) {
		
	}

	@Override
	public Commentaire readComment(Long numCommentaire) {
		return null;		
	}

	@Override
	public void updateComment(Long numCommentaire, String titreCommentaire, String contenuCommentaire,
			Long codeUtilisateur, Long codeTopo, Long numSite) {
		
	}
	
	@Override
	public void deleteComment(Long numCommentaire) {
		
	}

	//********** CRUD TOPO **********
	
	@Override
	public void createTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
			String langue, int nbPages, String statutTopo, Long numCommentaire, Long codeUtilisateur, Long numSite) {
		
	}

	@Override
	public Topo readTopo(String nomTopo) {
		return null;
		
	}

	@Override
	public void updateTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
			String langue, int nbPages, String statutTopo, Long numCommentaire, Long codeUtilisateur, Long numSite) {
		
	}

	@Override
	public void deleteTopo(String nomTopo) {
		
	}
	
	//********** GESTION TOPO **********

	@Override
	public Page<Topo> listTopo(Long codeTopo, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void requestBooking(Long codeTopo) {
		
	}

	@Override
	public void confirmBooking(Long CodeTopo) {
		
	}

	@Override
	public void endBooking(Long codeTopo) {
		
	}

	//************ CRUD DU SITE **********
	
	//CRUD DES ATTRIBUTS DU SITE
	
	//CREATE & READ NIVEAU DE PRATIQUE ******************************************
			
	@Override
	public void createNiveauDePratique(String nomNiveauPratique) {
		niveauDePratiqueRepository.save(new NiveauDePratique(nomNiveauPratique));
	}

	@Override
	public NiveauDePratique lireNiveauDePratique(Long codeNiveauPratique) {
		// TODO Auto-generated method stub
		return null;
	}

	//CREATE & READ TYPE DE ROCHE *************************************************
	
	@Override
	public void createTypeRoche(String nomRoche) {
		typeRocheRepository.save(new TypeRoche(nomRoche));
	}

	@Override
	public TypeRoche lireTypeRoche(Long codeRoche) {
		// TODO Auto-generated method stub
		return null;
	}

	//CREATE & READ COTATION *********************************************************
		

	@Override
	public void createCotation(String refCotationMin, String refCotationMax) {
		cotationRepository.save(new Cotation(refCotationMin, refCotationMax));
		
	}

	@Override
	public Cotation lireCotation(Long codeCotation) {
		// TODO Auto-generated method stub
		return null;
	}

	//CREATE & READ TYPE ESCALADE *******************************************************
	

	@Override
	public void createTypeEscalade(String nomTypeEscalade) {
		typeEscaladeRepository.save(new TypeEscalade(nomTypeEscalade));
	}

	@Override
	public TypeEscalade lireTypeEscalade(Long codeTypeEscalade) {
		// TODO Auto-generated method stub
		return null;
	}

	//CREATE & READ NIVEAU ESCALADE ******************************************************
			

	@Override
	public void createNiveauEscalade(String nomNiveauEscalade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NiveauEscalade lireNiveauEscalade(Long codeNiveauEscalade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//CREATE & READ ORIENTATION************************************************************
			

	@Override
	public void createOrientation(String nomOrientation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orientation lireOrientation(Long codeOrientation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//CREATE & READ MASSIF*******************************************************************
	
	
	@Override
	public void createMassif(String nomMassif) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Massif lireMassif(Long codeMassif) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//CREATE & READ CARTE IGN***********************************************************	

	@Override
	public void createCarteIgn(String nomCarte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CarteIgn lirecarteIgn(Long codeCarte) {
		// TODO Auto-generated method stub
		return null;
	}

	//CREATE & READ COMMUNE*******************************************************
		

	@Override
	public void createCommune(String nomCommune) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Commune lireCommune(Long codeCommune) {
		// TODO Auto-generated method stub
		return null;
	}

	//CRUD ATTRIBUTS COMMUNE *****************************************************

	//CREATE & READ DEPARTEMENT***************************************************

	@Override
	public void createDepartement(String nomDpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departement lireDepartement(Long codeDpt) {
		// TODO Auto-generated method stub
		return null;
	}
	

	//CREATE & READ REGION*********************************************************

	@Override
	public void createRegion(String nomRegion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Region lireRegion(Long codeRegion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//CREATE & READ PAYS*****************************************************
	

	@Override
	public void createNomPays(String nomPays) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pays lirePays(Long codePays) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

	
	

	

	

	

	

	

	

	

	

		

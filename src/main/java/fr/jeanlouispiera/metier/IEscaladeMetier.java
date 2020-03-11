package fr.jeanlouispiera.metier;

import java.util.Date;

import org.springframework.data.domain.Page;

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

public interface IEscaladeMetier {

/**
 * INTERFACE METIER. CHAQUE METHODE REPRESENTE UN USE CASE DES FONCTIONNALITES DU SITE ESCALADE	
**/
	
//1 ********************CRUD DE SON ESPACE PERSONNEL ****************** [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
	
	//1-1 CREATE DE SON ESPACE PERSONNEL PAR L'UTILISATEUR MEMBRE OU VISITEUR 
		public void createUserM(String nomUtilisateur, String adresseMail, String passWord);
		public void createUserV(String nomUtilisateur, String adresseMail, String passWord);

	//1-2 READ DE SON ESPACE PERSONNEL ******* [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
		public Utilisateur readUser(Long codeUtilisateur);
	
	//1-3 UPDATE DE SON ESPACE PERSONNEL ******** [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
		public void updateUser(Long codeUtilisateur, String passWord);
	
	//1-4 DELETE DE SON ESPACE PERSONNEL ******* [PAR L'UTILISATEUR MEMBRE OU VISITEUR]
		public void deleteUser(Long codeUtilisateur);
		
	
//2 ***************  CRUD D'UNE FICHE OFFICIELLE UNIQUE D'UN SITE ESCALADE ****************** [PAR UN MEMBRE]
	
		//2-1 CREATE D'UNE FICHE OFFICIELLE DE SITE ESCALADE ******* [PAR UN MEMBRE] 
		public void createSiteFO(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				Long codeNiveauDePratique, Long codeRoche, Long codeCotation, 
				Long codeTypeEscalade, Long codeNiveauEscalade, Long codeOrientation, Long codeMassif,
				Long codeCarte, Long codeCommune, String tag);
		
	//2-2 READ D'UNE PAGE DE SITE ESCALADE PAR UN MEMBRE OU UN VISITEUR - VOIR 3/
		public Site readSiteFicheOfficielle(Long numSite);
		
	//2-3 UPDATE D'UNE FICHE OFFICIELLE DE SITE ESCALADE ********* [PAR UN MEMBRE] 
		public void updateSiteFO (String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				Long codeNiveauDePratique, Long codeRoche, Long codeCotation, 
				Long codeTypeEscalade, Long codeNiveauEscalade, Long codeOrientation, Long codeMassif,
				Long codeCarte, Long codeCommune, String tag);
		
	//2-4 RENSEIGNER UN TAG SUR UNE PAGE OFFICIELLE DU SITE ESCALADE ********[PAR UN MEMBRE]
		public void createTagSiteFO(Long numSite, String tag);
		
	//2-5 DELETE D'UNE FICHE OFFICIELLE DE SITE ESCALADE ******** [PAR UN MEMBRE] 
		public void deleteSiteFO(Long numSite);
		
//3-CONSULTER UNE FICHE OFFICIELLE DE SITE ESCALADE PAR UN VISITEUR - VOIR 2.2
		
		
//4 **************** CRUD D'UNE OU PLUSIEURS FICHE INFOS D'UN SITE ESCALADE ******************* [PAR VISITEUR]
		
		//4-1 DONNER UNE OU PLUSIEURS INFORMATIONS DANS UNE FICHE INFO SUR UN SITE ESCALADE SANS MODIFIER LA FICHE OFFICIELLE ***** [PAR UN VISITEUR]
		public void createSiteFI(Long numsite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				Long codeNiveauDePratique, Long codeRoche, Long codeCotation, 
				Long codeTypeEscalade, Long codeNiveauEscalade, Long codeOrientation, Long codeMassif,
				Long codeCarte, Long codeCommune, Date dateInfos, String nomVisiteur, String adresseMailVisiteur);
		
	
		//4-2-LIRE LES INFOS D'UNE FICHE INFOS D'UN VISITEUR ****** [PAR UN UTILISATEUR] OU [PAR UN MEMBRE] 	
		public Site readSiteFI(Long numsite);

		
		//4-3 UPDATE LES INFOS D'UNE FICHE INFORMATIONS D'UN VISITEUR **** [PAR UN MEMBRE]
		public void updateSiteFI(Long numsite, String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				Long codeNiveauDePratique, Long codeRoche, Long codeCotation, 
				Long codeTypeEscalade, Long codeNiveauEscalade, Long codeOrientation, Long codeMassif,
				Long codeCarte, Long codeCommune, Date dateInfos, String nomVisiteur, String adresseMailVisiteur);
		
		//4-4 SUPPRIMER LES INFORMATIONS D'UNE FICHE INFORMATION D'UN VISITEUR ***** [PAR UN MEMBRE] 
		public void deleteSiteFI(Long numSite);
		
				
//5 ********************** CRUD COMMENTAIRE GENERAL SUR UN SITE ********************** [PAR UN VISITEUR]
			
		//5-1-CREATE UN COMMENTAIRE GENERAL CONCERNANT LA FICHE OFFICIELLE D'UN SITE ****** [PAR UN VISITEUR] 
		public void createComment(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
				Long codeUtilisateur, Long codeTopo, Long numSite);
		
		//5-2-READ UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE ***** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
		public Commentaire readComment(Long numCommentaire);

		//5-3 UPDATE UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE **** [PAR UN MEMBRE] 
		public void updateComment(Long numCommentaire, String titreCommentaire, String contenuCommentaire,
				Long codeUtilisateur, Long codeTopo, Long numSite);

		//5-4 DELETE UN COMMENTAIRE GENERAL D'UN VISITEUR CONCERNANT LA FICHE OFFICIELLE D'UN SITE ****** [PAR UN MEMBR]E 
		public void deleteComment(Long numCommentaire);
		
		
//6 *******************   CRUD CONSULTATION ET GESTION DES TOPOS ************[PAR UN VISITEUR] OU [PAR UN MEMBRE]
		
//6-1 CRUD D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
	//6-1-1 CREATE D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
		public void createTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
				String langue, int nbPages, String statutTopo, Long numCommentaire, Long codeUtilisateur, Long numSite);

	//6-1-2 READ D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
		public Topo readTopo(String nomTopo);

	//6-1-3 UPDATE D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
		public void updateTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
				String langue, int nbPages, String statutTopo, Long numCommentaire, Long codeUtilisateur, Long numSite);


	//6-1-4 DELETE D'UN TOPO DANS SON ESPACE PERSONNEL ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
		public void deleteTopo(String nomTopo);
		
//6-2 CONSULTER TOUS LES TOPOS DISPONIBLES POUR UN SITE D'ESCALADE ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
		public Page<Topo> listTopo(Long codeTopo, int page, int size);
		
//6-3 FAIRE UNE DEMANDE DE RESERVATION D'UN TOPO DISPONIBLE ******** [PAR UN VISITEUR] OU [PAR UN MEMBRE]
		public void requestBooking(Long codeTopo);

//6-4 ACCEPTER LA DEMANDE DE RESERVATION D'UN TOPO DISPONIBLE ******** PAR LE PROPIETAIRE [UN VISITEUR] OU [UN MEMBRE]
		public void confirmBooking(Long CodeTopo);
		
//6-5 INDIQUER LA FIN DU PRET D4UN TOPO QUI REDEVIENT DISPONIBLE  ******** PAR LE PROPIETAIRE [UN VISITEUR] OU [UN MEMBRE]
		public void endBooking(Long codeTopo);


//*************************** CRUD DES CLASSES ATTRIBUTS @MANY-TO-ONE DE LA CLASSE SITE ET COMMUNE
		
		//CRUD DES ATTRIBUTS DU SITE*************************************************
		
		//CREATE & READ NIVEAU DE PRATIQUE ******************************************
				
		public void createNiveauDePratique(String nomNiveauPratique);

		public NiveauDePratique lireNiveauDePratique(Long codenomNiveauPratique);

		//CREATE & READ TYPE DE ROCHE *************************************************
		
		public void createTypeRoche(String nomRoche);

		public TypeRoche lireTypeRoche(Long codeRoche);

		//CREATE & READ COTATION *********************************************************
			
		public void createCotation(String refCotationMin, String refCotationMax);

		public Cotation lireCotation(Long codeCotation);
		

		//CREATE & READ TYPE ESCALADE *******************************************************
		
		public void createTypeEscalade(String nomTypeEscalade);

		public TypeEscalade lireTypeEscalade(Long codeTypeEscalade) ;

		//CREATE & READ NIVEAU ESCALADE ******************************************************
				
		public void createNiveauEscalade(String nomNiveauEscalade) ;

		public NiveauEscalade lireNiveauEscalade(Long codeNiveauEscalade);
		
		//CREATE & READ ORIENTATION************************************************************
				
		public void createOrientation(String nomOrientation);

		public Orientation lireOrientation(Long codeOrientation);
		
		//CREATE & READ MASSIF*******************************************************************
		
		public void createMassif(String nomMassif);

		public Massif lireMassif(Long codeMassif);
		
		//CREATE & READ CARTE IGN***********************************************************	

		public void createCarteIgn(String nomCarte);

		public CarteIgn lirecarteIgn(Long codeCarte);

		//CREATE & READ COMMUNE*******************************************************
		
		public void createCommune(String nomCommune);

		public Commune lireCommune(Long codeCommune);

		//CRUD ATTRIBUTS COMMUNE *****************************************************

		//CREATE & READ DEPARTEMENT***************************************************

		public void createDepartement(String nomDpt);

		public Departement lireDepartement(Long codeDpt);
		

		//CREATE & READ REGION*********************************************************

		public void createRegion(String nomRegion);

		public Region lireRegion(Long codeRegion);
		
		//CREATE & READ PAYS*****************************************************
		
		public void createNomPays(String nomPays);

		public Pays lirePays(Long codePays); 
		
		
		
		
}

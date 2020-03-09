package fr.jeanlouispiera.metier;

import java.util.Date;

import org.springframework.data.domain.Page;

import fr.jeanlouispiera.entities.CarteIgn;
import fr.jeanlouispiera.entities.Commentaire;
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

public interface IEscaladeMetier {

//1-CRUD de son Espace Personnel par l'Utilisateur Membre ou Visiteur
	//1-1 CREATE de son Espace Personnel par l'Utilisateur Membre ou Visiteur
		public Utilisateur createUser(String nomUtilisateur, String adresseMail, String passWord);

	//1-2 READ de son Espace Personnel par l'Utilisateur Membre ou Visiteur
		public Utilisateur readUser(String nomUtilisateur, String adresseMail, String passWord);
	
	//1-3 UPDATE de son Espace Personnel par l'Utilisateur Membre ou Visiteur
		public Utilisateur updateUser(String nomUtilisateur, String adresseMail, String passWord);
	
	//1-4 DELETE de son Espace Personnel par l'Utilisateur Membre ou Visiteur
		public Utilisateur deleteUser(String nomUtilisateur, String adresseMail, String passWord);
	
//2-CRUD d'une Page Site Escalade par un Membre
	//2-1 CREATE d'une Page Site Escalade par un Membre
		public Site createSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				String tag, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
				TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
				CarteIgn carteIgn, Commune commune);
		
	//2-2 READ d'une Page Site Escalade par un Membre ou par un Visiteur (voir 3)
		public Site readSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				String tag, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
				TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
				CarteIgn carteIgn, Commune commune);
		
	//2-3 UPDATE d'une Page Site Escalade par un Membre
		public Site updateSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				String tag, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
				TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
				CarteIgn carteIgn, Commune commune);
		
	//2-4 DELETE d'une Page Site Escalade par un Membre
		public Site deleteSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				String tag, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
				TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
				CarteIgn carteIgn, Commune commune);
		
//3-Consulter une Page du Site Escalade par un Visiteur (voir 2-2)

//4-Modifier une Page Site Escalade avec un TAG par un Visiteur
		public Site createTagSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				String tag, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
				TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
				CarteIgn carteIgn, Commune commune);
		
//5-Commenter chaque information du Site Escalade sans les modifier par un Visiteur
		public Site commentInfoSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				String tag, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
				TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
				CarteIgn carteIgn, Commune commune);
		
		
//6-UD par un Membre de chaque commentaire d'une information du site par un Membre
	//6-1 UPDATE de chaque commentaire Visiteur d'une information du site par un Membre
		public Site updateCommentInfoSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				String tag, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
				TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
				CarteIgn carteIgn, Commune commune);
		
	//6-2 DELETE de chaque commentaire Visiteur d'une information du site par un Membre
		public Site deleteCommentInfoSite(String nomSite, int altitude, int nbVoies, int hauteurMin, int hauteurMax, int longueurTotaleVoies,
				String tag, NiveauDePratique niveauDePratique, TypeRoche typeRoche, Cotation cotation,
				TypeEscalade typeEscalade, NiveauEscalade niveauEscalade, Orientation orientation, Massif massif,
				CarteIgn carteIgn, Commune commune);
		
//7-Faire un Commentaire Général sur un Site Escalade par un Visiteur
		public Commentaire addComment(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
				Utilisateur utilisateur, Topo topo, Site site);

//8-UD de chaque commentaire général Visiteur d'un Site d'Escalade par un Membre
	//8-1 UPDATE de chaque commentaire général Visiteur d'un Site d'Escalade par un Membre
		public Commentaire updateComment(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
				Utilisateur utilisateur, Topo topo, Site site);

	//8-2 DELETE de chaque commentaire général Visiteur d'un Site d'Escalade par un Membre
		public Commentaire deleteComment(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
				Utilisateur utilisateur, Topo topo, Site site);

		
//9-CRUD Topo dans l'Espace Personnel par un Utilisateur Membre ou Visiteur
	//9-1 CREATE Topo dans l'Espace Personnel par un Utilisateur Membre ou Visiteur
		public Topo createTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
				String langue, int nbPages, String statutTopo, Utilisateur utilisateur, Site site);

	//9-2 READ Topo dans l'Espace Personnel par un Utilisateur Membre ou Visiteur
		public Topo readTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
				String langue, int nbPages, String statutTopo, Utilisateur utilisateur, Site site);

	//9-3 UPDATE Topo dans l'Espace Personnel par un Utilisateur Membre ou Visiteur
		public Topo updateTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
				String langue, int nbPages, String statutTopo, Utilisateur utilisateur, Site site);

	//9-4 DELETE Topo dans l'Espace Personnel par un Utilisateur Membre ou Visiteur
		public Topo deleteTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
				String langue, int nbPages, String statutTopo, Utilisateur utilisateur, Site site);

//10-Consulter tous les Topos disponibles d'un Site d'Escalade par un Utilisateur Membre ou Visiteur
		public Page<Topo> listTopo(Long codeTopo, int page, int size);
		
//11-Réserver un Topo par un Utilisateur Membre ou Visiteur
		public Topo requestBooking(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
				String langue, int nbPages, String statutTopo, Utilisateur utilisateur, Site site);

//12-Accepter la réservation d'un Topo par un Utilisateur Membre ou Visiteur
		public Topo confirmBooking(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
				String langue, int nbPages, String statutTopo, Utilisateur utilisateur, Site site);

		
//13-Finir la réservation d'un Topo par l'Utilisateur Membre ou Visiteur Propriétaire du Topo 
		public Topo endBooking(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
				String langue, int nbPages, String statutTopo, Utilisateur utilisateur, Site site);


	
}

package fr.jeanlouispiera.metier;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import fr.jeanlouispiera.dao.ICommentaireRepository;
import fr.jeanlouispiera.entities.Commentaire;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.User;


@Service
@Transactional
public class CommentaireMetierImpl implements ICommentaireMetier  {
@Autowired
private ICommentaireRepository iCommentaireRepository;

/**
 * Cette méthode permet de créer un jeu de données dans le main au lancement en mode CREATE JPA Hibernate
 */
@Override
public Commentaire createCommentaire(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
		User user, Topo topo, Site site) {
	Commentaire c = new Commentaire(titreCommentaire, dateCommentaire, contenuCommentaire,
			user, topo, site);
	iCommentaireRepository.save(c);
	return c;
}


/**
 * Cette méthode permet de persister un commentaire
 */
@Override
public Commentaire addCommentaire(Commentaire commentaire) {
	return iCommentaireRepository.save(commentaire);
}


/**
 * Cette méthode de lire un commentaire par son id
 */
@Override
public Commentaire readCommentaire(long numCommentaire) {
	Commentaire c = iCommentaireRepository.findById(numCommentaire).get();
	if(c==null) throw new RuntimeException("Espace commentaire introuvable");
	return c;
}

/**
 * Cette méthode permet de mettre à jour un commentaire
 */
@Override
public Commentaire updateCommentaire(Commentaire commentaire) {
	return iCommentaireRepository.save(commentaire);
}


/**
 * Cette méthode permet de supprimer un commentaire
 */
@Override
public void deleteCommentaire(Long numCommentaire) {
	iCommentaireRepository.deleteById(numCommentaire);
	
}	
	
/**
 * Cette méthode permet de récupérer en base de données un commentaire sur un site
 */
@Override
public List<Commentaire> findCommentairesBySite(Site site) {
	List<Commentaire> c = iCommentaireRepository.findBySite(site);
	return c;
}

	
	
	
	
}

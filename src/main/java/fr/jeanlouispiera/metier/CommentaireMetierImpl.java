package fr.jeanlouispiera.metier;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.jeanlouispiera.dao.ICommentaireRepository;
import fr.jeanlouispiera.entities.Commentaire;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.Utilisateur;

@Service
@Transactional
public class CommentaireMetierImpl implements ICommentaireMetier  {
@Autowired
private ICommentaireRepository iCommentaireRepository;

@Override
public Commentaire createCommentaire(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
		Utilisateur utilisateur, Topo topo, Site site) {
	Commentaire c = new Commentaire(titreCommentaire, dateCommentaire, contenuCommentaire,
			utilisateur, topo, site);
	iCommentaireRepository.save(c);
	return c;
}

@Override
public Commentaire addCommentaire(Commentaire commentaire) {
	return iCommentaireRepository.save(commentaire);
}

@Override
public Commentaire readCommentaire(long numCommentaire) {
	Commentaire c = iCommentaireRepository.findById(numCommentaire).get();
	if(c==null) throw new RuntimeException("Espace commentaire introuvable");
	return c;
}

@Override
public Commentaire updateCommentaire(Commentaire commentaire) {
	return iCommentaireRepository.save(commentaire);
}

@Override
public void deleteCommentaire(Long numCommentaire) {
	iCommentaireRepository.deleteById(numCommentaire);
	
}	
	

	@Override
	public List<Commentaire> findCommentairesBySite(Site site) {
		List<Commentaire> c = iCommentaireRepository.findBySite(site);
		return c;
	}

	
	
	
	
}

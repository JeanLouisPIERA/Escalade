package fr.jeanlouispiera.metier;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Commentaire createComment(String titreCommentaire, Date dateCommentaire, String contenuCommentaire,
			Utilisateur utilisateur, Topo topo, Site site) {
		Commentaire c = new Commentaire(titreCommentaire, dateCommentaire, contenuCommentaire,
				utilisateur, topo, site);
		iCommentaireRepository.save(c);
		return c;
	}

	@Override
	public Commentaire readComment(Long numCommentaire) {
		Commentaire c = iCommentaireRepository.findById(numCommentaire).orElse(null);
		if(c==null) throw new RuntimeException("Espace utilisateur introuvable");
		return c;
		
	}

	@Override
	public Commentaire updateComment(Long numCommentaire, String titreCommentaire, Date dateCommentaire,
			String contenuCommentaire, Utilisateur utilisateur, Topo topo, Site site) {
		Commentaire c = readComment(numCommentaire);
		c.setContenuCommentaire(contenuCommentaire);
		c.setDateCommentaire(dateCommentaire);
		c.setNumCommentaire(numCommentaire);
		c.setSite(site);
		c.setTitreCommentaire(titreCommentaire);
		c.setTopo(topo);
		c.setUtilisateur(utilisateur);
		return c;
	}

	@Override
	public void deleteComment(Long numCommentaire) {
		iCommentaireRepository.delete(readComment(numCommentaire));
	}
	
}

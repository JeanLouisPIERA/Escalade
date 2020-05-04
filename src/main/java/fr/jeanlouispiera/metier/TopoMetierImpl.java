package fr.jeanlouispiera.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jeanlouispiera.dao.ITopoRepository;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.User;


@Service
@Transactional
public class TopoMetierImpl implements ITopoMetier {
	@Autowired
	private ITopoRepository iTopoRepository;

	/**
	 * Cette méthide permet de créer un jeu de données Topo à partir du Main au lancement du programme
	 */
	@Override
	public Topo createTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
			String langue, int nbPages, TopoStatut topoStatut, User user, Site site) {
		Topo t = new Topo(nomTopo, descriptionTopo, editeur, dateParution, largeur, longueur,
				langue, nbPages, topoStatut,user, site);
		iTopoRepository.save(t);
		return t;
	}
	
	/**
	 * Cette méthode permet de renseigner le propriétaie d'un Topo 
	 */
	@Override
	public void addUserToTopo(Topo topo, User user) {
		topo.setUser(user);
		
	}

	/**
	 * Cette méthode permet de persister un Topo en base de données
	 */
	@Override
	public Topo addTopo(Topo topo) {
		return iTopoRepository.save(topo);
	}
	
	/**
	 * Cette méthode permet de récupérer les informations d'un Topo persisté en base de données
	 */
	@Override
	public Topo readTopo(long codeTopo) {
		Topo t=iTopoRepository.findById(codeTopo).get();
		if(t==null) throw new RuntimeException("Espace Topo introuvable");
		return t;
	}
	
	/**
	 * Cette méthode permet de persister les mises à jour d'un Topo en base de données
	 */
	@Override
	public Topo updateTopo(Topo topo) {
		return iTopoRepository.save(topo);
	}
	
	/**
	 * Cette méthode permet de supprimer un Topo
	 */
	@Override
	public void deleteTopo(long codeTopo) {
		iTopoRepository.deleteById(codeTopo);
		
	}
	
	
	//*******AFFICHER ET SELECTIONNER LES TOPOS *****************
	
	/**
	 * Cette méthode permet de récupérer la liste de tous les topos persistés en base de données sous la forme
	 * de pages
	 */
	@Override
	public Page<Topo> findAll(Pageable pageable) {
		Page<Topo> t = iTopoRepository.findAll(pageable);
		return t;
	}
	
	/**
	 * Cette méthode permet de récupérer la liste de tous les topos d'un utilisateur persistés en base de données 
	 * sous la forme de pages
	 */
	@Override
	public Page<Topo> findByUser(User user, Pageable pageable) {
		Page<Topo> t = iTopoRepository.findByUser(user, pageable);
		return t;
	}
	
	/**
	 * Cette méthode permet de récupérer la liste de tous les topos d'un site persistés en base de données
	 */
	@Override
	public List<Topo> findToposBySite(Site site) {
		List<Topo> t = iTopoRepository.findBySite(site);
		return t;
	}

	
	
	//*******GERER LE PRET D'UN TOPO*******************
	
	
	@Override
	public Topo changerTopoStatut(Long codeTopo, TopoStatut TopoStatut1, TopoStatut TopoStatut2) {
		Topo t=readTopo(codeTopo);
		if(t.getTopoStatut().equals(TopoStatut1)){
			t.setTopoStatut(TopoStatut2);
	}
		return t;
	}
	
	
}

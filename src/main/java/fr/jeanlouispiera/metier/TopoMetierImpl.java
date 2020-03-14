package fr.jeanlouispiera.metier;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.data.domain.Page;

//import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jeanlouispiera.dao.TopoRepository;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.Utilisateur;

@Service
@Transactional
public class TopoMetierImpl implements ITopoMetier {
	@Autowired
	private TopoRepository topoRepository;

	@Override
	public Topo createTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
			String langue, int nbPages, TopoStatut topoStatut, Utilisateur utilisateur, Site site) {
		Topo t = new Topo(nomTopo, descriptionTopo, editeur, dateParution, largeur, longueur,
				langue, nbPages, topoStatut, utilisateur, site);
		topoRepository.save(t);
		return t;
	}
	

	@Override
	public Topo readTopo(Long codeTopo) {
		Topo t=topoRepository.findById(codeTopo).orElse(null);
		if(t==null) throw new RuntimeException("Espace utilisateur introuvable");
		return t;
	}

	@Override
	public Topo updateTopo(Long codeTopo, String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur,
			int longueur, String langue, int nbPages, TopoStatut topoStatut, Utilisateur utilisateur, Site site) {
		Topo t=readTopo(codeTopo);
		t.setNomTopo(nomTopo);
		t.setDateParution(dateParution);
		t.setDescriptionTopo(descriptionTopo);
		t.setEditeur(editeur);
		t.setLangue(langue);
		t.setLargeur(largeur);
		t.setLongueur(longueur);
		t.setNbPages(nbPages);
		t.setNomTopo(nomTopo);
		t.setTopoStatut(topoStatut);
		t.setUtilisateur(utilisateur);
		t.setSite(site);
		return t;
	}

	@Override
	public void deleteTopo(Long codeTopo) {
		topoRepository.delete(readTopo(codeTopo));
		
	}
/**
	@Override
	public Page<Topo> listTopo(Long codeTopo, int page, int size) {
		return topoRepository.listTopo(codeTopo, PageRequest.of(page,size));
	}
**/
	@Override
	public void requestBooking(Long codeTopo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmBooking(Long CodeTopo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endBooking(Long codeTopo) {
		// TODO Auto-generated method stub
		
	}
	
	

}

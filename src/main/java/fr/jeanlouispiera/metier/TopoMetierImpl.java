package fr.jeanlouispiera.metier;

import java.util.List;



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
	
	//********SELECTIONNER LES TOPOS A PARTIR D'UN ATTRIBUT COMMUN ******** 
	

	@Override
	public List<Topo> searchByNomTopo(String nomTopo) {
		List<Topo> t = topoRepository.findByNomTopo(nomTopo);
		return t;
	}


	@Override
	public List<Topo> searchByEditeur(String editeur) {
		List<Topo> t = topoRepository.findByEditeur(editeur);
		return t;
	}


	@Override
	public List<Topo> searchByDateParution(String dateParution) {
		List<Topo> t = topoRepository.findByDateParution(dateParution);
		return t;
	}
	
	@Override
	public List<Topo> searchByUtilisateur(Utilisateur utilisateur) {
		List<Topo> t = topoRepository.findByUtilisateur(utilisateur);
		return t;
	}


	@Override
	public List<Topo> searchBySite(Site site) {
		List<Topo> t = topoRepository.findBySite(site);
		return t;

	}

	@Override
	public List<Topo> searchByTopoStatut(TopoStatut topoStatut) {
		List<Topo> t = topoRepository.findByTopoStatut(topoStatut);
		return t;
	}
	
	//*******AFFICHER ET SELECTIONNER LES TOPOS *****************
	
	@Override
	public List<Topo> displayAllTopos() {
		List<Topo> t = topoRepository.findAll();
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
	
	@Override
	public Topo requestBooking(Long codeTopo) {
		return changerTopoStatut(codeTopo, TopoStatut.DIS, TopoStatut.DEM);
	}

	@Override
	public Topo confirmBooking(Long codeTopo) {
		return changerTopoStatut(codeTopo, TopoStatut.DEM, TopoStatut.PEC);
		
	}

	@Override
	public Topo endBooking(Long codeTopo) {
		return changerTopoStatut(codeTopo, TopoStatut.PEC, TopoStatut.DIS);
	}


	

	

}

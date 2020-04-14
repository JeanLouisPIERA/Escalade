package fr.jeanlouispiera.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jeanlouispiera.dao.ITopoRepository;
import fr.jeanlouispiera.entities.Site;
import fr.jeanlouispiera.entities.Topo;
import fr.jeanlouispiera.entities.TopoStatut;
import fr.jeanlouispiera.entities.Utilisateur;

@Service
@Transactional
public class TopoMetierImpl implements ITopoMetier {
	@Autowired
	private ITopoRepository iTopoRepository;

	@Override
	public Topo createTopo(String nomTopo, String descriptionTopo, String editeur, String dateParution, int largeur, int longueur,
			String langue, int nbPages, TopoStatut topoStatut, Utilisateur utilisateur, Site site) {
		Topo t = new Topo(nomTopo, descriptionTopo, editeur, dateParution, largeur, longueur,
				langue, nbPages, topoStatut, utilisateur, site);
		iTopoRepository.save(t);
		return t;
	}
	
	@Override
	public Topo addTopo(Topo topo) {
		return iTopoRepository.save(topo);
	}
	

	@Override
	public Topo readTopo(long codeTopo) {
		Topo t=iTopoRepository.findById(codeTopo).get();
		if(t==null) throw new RuntimeException("Espace Topo introuvable");
		return t;
	}
	
	@Override
	public Topo updateTopo(Topo topo) {
		return iTopoRepository.save(topo);
	}
	

	@Override
	public void deleteTopo(long codeTopo) {
		iTopoRepository.deleteById(codeTopo);
		
	}
	
	
	
	//********SELECTIONNER LES TOPOS A PARTIR D'UN ATTRIBUT COMMUN ******** 
	

	@Override
	public List<Topo> searchByNomTopo(String nomTopo) {
		List<Topo> t = iTopoRepository.findByNomTopo(nomTopo);
		return t;
	}


	@Override
	public List<Topo> searchByEditeur(String editeur) {
		List<Topo> t = iTopoRepository.findByEditeur(editeur);
		return t;
	}


	@Override
	public List<Topo> searchByDateParution(String dateParution) {
		List<Topo> t = iTopoRepository.findByDateParution(dateParution);
		return t;
	}
	
	@Override
	public List<Topo> searchByUtilisateur(Utilisateur utilisateur) {
		List<Topo> t = iTopoRepository.findByUtilisateur(utilisateur);
		return t;
	}


	@Override
	public List<Topo> searchBySite(Site site) {
		List<Topo> t = iTopoRepository.findBySite(site);
		return t;

	}

	@Override
	public List<Topo> searchByTopoStatut(TopoStatut topoStatut) {
		List<Topo> t = iTopoRepository.findByTopoStatut(topoStatut);
		return t;
	}
	
	//*******AFFICHER ET SELECTIONNER LES TOPOS *****************
	
	@Override
	public List<Topo> displayAllTopos() {
		List<Topo> t = iTopoRepository.findAll();
		return t;
	}
	
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

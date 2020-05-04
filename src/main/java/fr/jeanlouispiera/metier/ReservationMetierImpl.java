package fr.jeanlouispiera.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jeanlouispiera.dao.IReservationRepository;
import fr.jeanlouispiera.entities.Reservation;
import fr.jeanlouispiera.entities.Topo;



@Service
@Transactional
public class ReservationMetierImpl implements IReservationMetier{
	
	@Autowired
	private IReservationRepository iReservationRepository;

	/**
	 * Cette méthode permet de persister une demande de réservation
	 */
	@Override
	public Reservation demanderReservation(Reservation reservation) {
		return iReservationRepository.save(reservation);
	}
	
	/**
	 * Cette méthode permet de récupérer des pages de demandes de réservation 
	 */
	@Override
	public Page<Reservation> consulterReponseMesDemandesReservation(Pageable pageable) {
		Page<Reservation> r = iReservationRepository.findAll(pageable);
		return r;
	}

	/**
	 * Cette méthode permet d'afficher des pages de demande de réservtion faites par un utilisateur
	 */
	@Override
	public Page<Reservation> consulterReponseMesDemandesReservation(String username, Pageable pageable) {
		Page<Reservation> r = iReservationRepository.findByUser_Username(username, pageable);
		return r;
	}
	
	
	/**
	 * Cette méthode permet d'afficher les demandes de réservation faites à un utilisateur propriétaire d'un topo
	 */
	@Override
	public Page<Reservation> afficherDemandesReservation(String username, Pageable pageable) {
		Page<Reservation> r = iReservationRepository.findByTopo_User_Username(username, pageable);
		return r;
	}

	/**
	 * Cette méthode permet de récupérer en base de données les informations d'une réservation 
	 */
	@Override
	public Reservation readReservation(long numReservation) {
		Reservation r=iReservationRepository.findById(numReservation).get();
		if(r==null) throw new RuntimeException("Espace Reservation introuvable");
		return r;
	}
	
	/**
	 * Cette méthode permet de persister la mise à jour d'une réservation
	 */
	@Override
	public Reservation updateReservation(Reservation reservation) {
		return iReservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> findReservationByTopo(Topo topo) {
		List<Reservation> r = iReservationRepository.findByTopo(topo);
		return r;
	}

	@Override
	public void deleteReservation(long numReservation) {
		iReservationRepository.deleteById(numReservation);
		
	}
	

	
}

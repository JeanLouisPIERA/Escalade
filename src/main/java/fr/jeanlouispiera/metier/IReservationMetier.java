package fr.jeanlouispiera.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import fr.jeanlouispiera.entities.Reservation;
import fr.jeanlouispiera.entities.Topo;



public interface IReservationMetier {
	
	Reservation demanderReservation(Reservation reservation);
	
	Reservation readReservation(long numReservation);
	
	Reservation updateReservation(Reservation reservation);
	
	Page<Reservation> consulterReponseMesDemandesReservation(Pageable pageable);
	
	Page<Reservation> consulterReponseMesDemandesReservation(String username, Pageable pageable);
	
	Page<Reservation> afficherDemandesReservation(String username, Pageable pageable);
	
	List<Reservation> findReservationByTopo(Topo topo);
	
	void deleteReservation(long numReservation);
	
}

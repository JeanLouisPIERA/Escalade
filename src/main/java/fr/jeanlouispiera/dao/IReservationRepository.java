package fr.jeanlouispiera.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.jeanlouispiera.entities.Reservation;
import fr.jeanlouispiera.entities.Topo;

public interface IReservationRepository extends JpaRepository <Reservation, Long> {
	
	@Query("select r from Reservation r where r.user.username like %?1")
	   Page<Reservation> findByUser_Username(String username, Pageable pageable);

	@Query("select r from Reservation r where r.topo.user.username like %?1")
	   Page<Reservation> findByTopo_User_Username(String username, Pageable pageable);
	
	@Query
	List<Reservation> findByTopo(Topo topo);
}

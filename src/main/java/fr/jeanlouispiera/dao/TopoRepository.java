package fr.jeanlouispiera.dao;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import fr.jeanlouispiera.entities.Topo;

public interface TopoRepository extends JpaRepository<Topo, Long>{
	
	//@Query("select o from Topo o where o.topo.codeTopo=:x order by o.dateParution desc")
	//public Page<Topo> listTopo(@Param("x")Long codeTopo, Pageable pageable);

}

package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.Pays;

public interface PaysRepository extends JpaRepository<Pays, Long>{

}

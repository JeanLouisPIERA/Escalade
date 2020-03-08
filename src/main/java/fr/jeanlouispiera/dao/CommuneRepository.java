package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Long>{

}

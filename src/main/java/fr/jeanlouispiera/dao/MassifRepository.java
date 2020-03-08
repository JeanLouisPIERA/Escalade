package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.Massif;

public interface MassifRepository extends JpaRepository<Massif, Long> {

}

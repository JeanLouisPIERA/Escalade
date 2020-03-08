package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.Cotation;

public interface CotationRepository extends JpaRepository<Cotation, Long>{

}

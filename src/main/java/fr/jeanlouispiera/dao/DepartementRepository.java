package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long>{

}

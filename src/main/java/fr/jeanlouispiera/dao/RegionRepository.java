package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

}

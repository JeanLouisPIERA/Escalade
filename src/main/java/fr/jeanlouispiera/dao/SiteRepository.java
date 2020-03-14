package fr.jeanlouispiera.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.jeanlouispiera.entities.Site;

public interface SiteRepository extends JpaRepository<Site, Long>{

}

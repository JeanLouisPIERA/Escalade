package fr.jeanlouispiera.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.jeanlouispiera.entities.Utilisateur;
import fr.jeanlouispiera.entities.UtilisateurMembre;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	/**@Query("select o from UtilisateurMembre o where o.utilisateurMembre.codeUtilisateur=:x")
	public Page<UtilisateurMembre> listUtilisateurMembre(@Param("x")Long codeUtilisateur, Pageable pageable);**/
}

package fr.jeanlouispiera.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import fr.jeanlouispiera.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	/**@Query("select o from UtilisateurMembre o where o.utilisateurMembre.codeUtilisateur=:x")
	public Page<UtilisateurMembre> listUtilisateurMembre(@Param("x")Long codeUtilisateur, Pageable pageable);**/

//@Query	
//Optional<Utilisateur> findById(Long codeUtilisateur);

}

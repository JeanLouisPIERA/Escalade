package fr.jeanlouispiera.metier;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.jeanlouispiera.dao.UtilisateurRepository;
import fr.jeanlouispiera.entities.Utilisateur;
@Service
@Transactional
public class UtilisateurMetierImpl implements IUtilisateurMetier {
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public Utilisateur createUser(String nomUtilisateur, String adresseMail, String passWord) {
		Utilisateur u = new Utilisateur(nomUtilisateur, adresseMail, passWord);
		utilisateurRepository.save(u);
		return u;
	}

	@Override
	public Utilisateur readUser(Long codeUtilisateur) {
		Utilisateur u = new Utilisateur();
		try {
			u = utilisateurRepository.findById(codeUtilisateur).orElse(null);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		//if(u==null) throw new RuntimeException("Espace utilisateur introuvable");
		return u;
	}

	@Override
	public Utilisateur updateUser(Long codeUtilisateur, String passWord) {
		Utilisateur u=readUser(codeUtilisateur);
		u.setPassWord(passWord);
		return u;
	}

	@Override
	public void deleteUser(Long codeUtilisateur) {
		Utilisateur u = readUser(codeUtilisateur);
		utilisateurRepository.delete(readUser(codeUtilisateur));
		

	}
	
		

}

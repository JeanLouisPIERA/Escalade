package fr.jeanlouispiera.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_USER", discriminatorType=DiscriminatorType.STRING, length=2)
public abstract class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long codeUtilisateur;
	private String nomUtilisateur;
	private String adresseMail;
	private String passWord;
	@OneToMany(mappedBy="utilisateur", fetch=FetchType.LAZY)
	private Collection<Topo> topos;
	@OneToMany(mappedBy="utilisateur", fetch=FetchType.LAZY)
	private Collection<Commentaire> commentaires;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(Long codeUtilisateur, String nomUtilisateur, String adresseMail, String passWord) {
		super();
		this.codeUtilisateur = codeUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.adresseMail = adresseMail;
		this.passWord = passWord;
	}
	
	public Utilisateur(String nomUtilisateur, String adresseMail, String passWord) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.adresseMail = adresseMail;
		this.passWord = passWord;
	}
	public Long getCodeUtilisateur() {
		return codeUtilisateur;
	}
	public void setCodeUtilisateur(Long codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Collection<Topo> getTopos() {
		return topos;
	}
	public void setTopos(Collection<Topo> topos) {
		this.topos = topos;
	}
	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	
	

}

package fr.jeanlouispiera.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "user")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Transient
    private String passwordConfirm;
    
    @ManyToOne
    private Role role;
    
    private String adresseMail;
    
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<Topo> topos;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<Commentaire> commentaires;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;

	public User() {
		super();
	}

	public User(Long id, String username, String password, String passwordConfirm, Role role, String adresseMail,
			Collection<Topo> topos, Collection<Commentaire> commentaires, Collection<Reservation> reservations) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.role = role;
		this.adresseMail = adresseMail;
		this.topos = topos;
		this.commentaires = commentaires;
		this.reservations = reservations;
	}



public User(String username, String password, String passwordConfirm, Role role, String adresseMail,
		Collection<Topo> topos, Collection<Commentaire> commentaires, Collection<Reservation> reservations) {
	super();
	this.username = username;
	this.password = password;
	this.passwordConfirm = passwordConfirm;
	this.role = role;
	this.adresseMail = adresseMail;
	this.topos = topos;
	this.commentaires = commentaires;
	this.reservations = reservations;
}


	public User(String username, String adresseMail) {
		super();
		this.username = username;
		this.adresseMail = adresseMail;
	}
	
	

	public User(String username) {
	super();
	this.username = username;
}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
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
	
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
 
}
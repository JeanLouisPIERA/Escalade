package fr.jeanlouispiera.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Collection;


@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    private RoleEnum name;
    
    @OneToMany(mappedBy="role", fetch=FetchType.LAZY)
    private Collection<User> users;

	public Role(Long id, RoleEnum name, Collection<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, RoleEnum name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Role(RoleEnum name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleEnum getName() {
		return name;
	}

	public void setName(RoleEnum name) {
		this.name = name;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
       
}
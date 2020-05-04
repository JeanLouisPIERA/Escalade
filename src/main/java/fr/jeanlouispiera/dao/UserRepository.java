package fr.jeanlouispiera.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.jeanlouispiera.entities.User;


public interface UserRepository extends JpaRepository <User, Long> {
User findByUsername(String username);
}
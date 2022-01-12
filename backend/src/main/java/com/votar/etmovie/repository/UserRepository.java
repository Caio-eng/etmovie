package com.votar.etmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votar.etmovie.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	User findByEmail(String email);
}

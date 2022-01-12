package com.votar.etmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votar.etmovie.entities.Movie;

public interface MovieRepository  extends JpaRepository<Movie, Long>{

}

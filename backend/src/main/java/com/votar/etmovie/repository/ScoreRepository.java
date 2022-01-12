package com.votar.etmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votar.etmovie.entities.Score;
import com.votar.etmovie.entities.ScorePK;

public interface ScoreRepository  extends JpaRepository<Score, ScorePK>{

}

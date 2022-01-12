package com.votar.etmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.votar.etmovie.dto.MovieDTO;
import com.votar.etmovie.entities.Movie;
import com.votar.etmovie.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repo;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repo.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repo.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}

package com.votar.etmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.votar.etmovie.dto.MovieDTO;
import com.votar.etmovie.dto.ScoreDTO;
import com.votar.etmovie.entities.Movie;
import com.votar.etmovie.entities.Score;
import com.votar.etmovie.entities.User;
import com.votar.etmovie.repository.MovieRepository;
import com.votar.etmovie.repository.ScoreRepository;
import com.votar.etmovie.repository.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoryRepository;
	
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if ( user == null ) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMoveId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoryRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum += s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
	
	
}

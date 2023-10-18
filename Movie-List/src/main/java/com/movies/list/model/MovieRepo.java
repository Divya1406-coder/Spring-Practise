package com.movies.list.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


public interface MovieRepo extends JpaRepository<Movie, String>{
		List<Movie> ListofMoviesByActor(String name);	
}

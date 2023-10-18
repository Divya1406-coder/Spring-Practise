package com.movies.list.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class MovieListController {
	@Autowired
	private MovieRepo repo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/movies/{actor}")
	public String getMoviesList(@PathVariable("actor") String name,Model model) {
		//Movie movie = new Movie();
//		List<Movie> movielist = new ArrayList<>(); 
//		movie.setName("PS 1");
//		movie.setActor("Multi Actors");
//		movie.setDescription("Historical Story");
//		movielist.add(movie);
//		
		List<Movie> movielist = repo.ListofMoviesByActor(name);
		model.addAttribute("movies",movielist);
		return "MovieIndex";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/movies",consumes = "application/json")
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie) {
		repo.save(movie);
		return ResponseEntity.ok().build();
	}
}

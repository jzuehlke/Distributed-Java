package com.jzuehlke.springmovies.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jzuehlke.springmovies.movies.service.MovieService;
import java.util.List;

@RestController
public class MoviesController
{
    @Autowired
    private MovieService movieService;

    @RequestMapping("/movies")
    public List<Movie> getThanks() {
        return movieService.getAllMovies();
    }
    @RequestMapping("/movies/{id}")
    public Movie getMovie(@PathVariable String id) {
        return movieService.getMovie(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/movies")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/movies/{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable String id) {
        movieService.updateMovie(movie, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/movies/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
    }
}
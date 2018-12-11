package com.jzuehlke.springbootmoviesjpa.movies.controllers;

import com.jzuehlke.springbootmoviesjpa.movies.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Movie getMovie(@PathVariable String id) { return movieService.getMovie(id); }

    @RequestMapping(method= RequestMethod.POST, value="/movies")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/movies")
    public void updateMovie(@RequestBody Movie movie) {
        movieService.updateMovie(movie);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/movies/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
    }
}
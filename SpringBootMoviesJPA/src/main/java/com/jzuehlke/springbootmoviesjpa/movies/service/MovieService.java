package com.jzuehlke.springbootmoviesjpa.movies.service;

import com.jzuehlke.springbootmoviesjpa.movies.controllers.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService
{
    @Autowired
    private MoviesRepository moviesRepository;

    private static Log log = LogFactory.getLog(MovieService.class);

    public List<Movie> getAllMovies()
    {
        List<Movie> movies = new ArrayList<>();
        moviesRepository.findAll().forEach(movies::add);
        if (movies.size() == 0)
        {
            moviesRepository.save(new Movie("Nukie", "Adventure", 5));
            moviesRepository.save(new Movie("Black Dynamite", "Action", 5));
            moviesRepository.save(new Movie("Army of Darkness", "Horror", 5));
            moviesRepository.findAll().forEach(movies::add);
        }

        return movies;
    }

    public Movie getMovie(String id)
    {
        return (Movie)moviesRepository.findById(id).orElse(new Movie("Missing Team", "NA", 0));
    }

    public void addMovie(Movie movie)
    {
        log.info("Adding Movie " + movie.getName());
        moviesRepository.save(movie);
    }

    public void updateMovie(Movie movie)
    {
        log.info("Updating Movie " + movie.getName());
        moviesRepository.save(movie);
    }

    public void deleteMovie(String id)
    {
        log.info("Deleting Movie " + id);
        moviesRepository.delete(getMovie(id));
    }
}

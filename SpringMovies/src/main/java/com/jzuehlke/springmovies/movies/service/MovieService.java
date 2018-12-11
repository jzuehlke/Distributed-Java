package com.jzuehlke.springmovies.movies.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.jzuehlke.springmovies.movies.controllers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService
{
    private static Log log = LogFactory.getLog(MovieService.class);

    private List<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie("Nukie", "Adventure", 5),
            new Movie("Black Dynamite", "Action", 5),
            new Movie("Army of Darkness", "Horror", 5)
    ));

    public List<Movie> getAllMovies()
    {
        return movies;
    }

    public Movie getMovie(String id)
    {
        return movies.stream().filter(t -> t.getName().contains(id)).findFirst().get();
    }

    public void addMovie(Movie movie)
    {
        movies.add(movie);
        log.info("Adding Movie " + movie.getName());
    }

    public void updateMovie(Movie movie, String id)
    {
        for (int i = 0; i < movies.size(); i++)
        {
            Movie m = movies.get(i);
            if (m.getName().equals(id))
            {
                movies.set(i, movie);
                log.info("Updating Movie " + m.getName());
                return;
            }
        }
    }

    public void deleteMovie(String id)
    {
        movies.removeIf(t -> t.getName().equals(id));
        log.info("Deleting Movie " + id);
    }
}

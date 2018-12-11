package com.jzuehlke.springbootmoviesjpa.movies.service;

import com.jzuehlke.springbootmoviesjpa.movies.controllers.*;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movie, String>
{
}

package com.jzuehlke.springbootmoviesjpa.movies.controllers;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie
{
    @Id
    private String name;
    private String genre;
    private int rating;

    public Movie(){}

    public Movie(String name, String genre, int rating)
    {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }
}
package us.jakezuehlke.model;

public class Video
{
    private String title;
    private int year;
    private double rating;
    private String advisory;
    private String overview;
    private String storyline;
    private String country;
    private String language;
    private double budget;
    private int runtime;
    private double price;


    public Video(String title, int year, double rating, String advisory, String overview, String storyline,
                 String country, String language, double budget, int runtime, double price)
    {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.advisory = advisory;
        this.overview = overview;
        this.storyline = storyline;
        this.country = country;
        this.language = language;
        this.budget = budget;
        this.runtime = runtime;
        this.price = price;
    }

    public String getTitle() { return title; }
    public void setTitle(String name) { this.title = name; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public String getAdvisory() { return advisory; }
    public void setAdvisory(String advisory) { this.advisory = advisory; }
    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }
    public String getStoryline() { return storyline; }
    public void setStoryline(String storyline) { this.storyline = storyline; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    public int getRuntime() { return runtime; }
    public void setRuntime(int runtime) { this.runtime = runtime; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

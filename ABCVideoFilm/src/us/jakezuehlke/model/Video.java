package us.jakezuehlke.model;

public class Video
{
    private int videoNum;
    private boolean featured;
    private String title;
    private String image;
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

    public Video(int videoNum, boolean featured, String title, String image, int year, double rating, String advisory,
                 String overview, String storyline, String country, String language, double budget, int runtime, double price)
    {
        this.videoNum = videoNum;
        this.featured = featured;
        this.title = title;
        this.image = image;
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

    public int getVideoNum()
    {
        return videoNum;
    }

    public boolean isFeatured()
    {
        return featured;
    }

    public String getTitle()
    {
        return title;
    }

    public String getImage()
    {
        return image;
    }

    public int getYear()
    {
        return year;
    }

    public double getRating()
    {
        return rating;
    }

    public String getAdvisory()
    {
        return advisory;
    }

    public String getOverview()
    {
        return overview;
    }

    public String getStoryline()
    {
        return storyline;
    }

    public String getCountry()
    {
        return country;
    }

    public String getLanguage()
    {
        return language;
    }

    public double getBudget()
    {
        return budget;
    }

    public int getRuntime()
    {
        return runtime;
    }

    public double getPrice()
    {
        return price;
    }
}
package ru.example.TopFilm.dto;


public class FilmDTO {

    private int position;

    private double rating;

    private String name;

    private String originalName;

    private int year;

    private long votes;

    public FilmDTO() {
    }

    public FilmDTO(int position, double rating, String name, String originalName, int year, long votes) {
        this.position = position;
        this.rating = rating;
        this.name = name;
        this.originalName = originalName;
        this.year = year;
        this.votes = votes;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }
}

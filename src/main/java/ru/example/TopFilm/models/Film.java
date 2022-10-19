package ru.example.TopFilm.models;

import javax.persistence.*;

@Entity
@Table(name="Film")

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position")
    private int position;

    @Column(name = "rating")
    private double rating;

    @Column(name = "name")
    private String name;

    @Column(name = "alternative_name")
    private String originalName;

    @Column(name = "year")
    private int year;

    @Column(name = "votes")
    private long votes;

    public Film(){

    }

    public Film(int position, double rating, String name, String originalName, int year, long votes) {
        this.position = position;
        this.rating = rating;
        this.name = name;
        this.originalName = originalName;
        this.year = year;
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Film{" +
                "position=" + position +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", year=" + year +
                ", votes=" + votes +
                '}';
    }
}

package ru.example.TopFilm.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import ru.example.TopFilm.models.Film;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FilmMapper {
    public List<Film> map(JsonNode obj){
        List<Film> topFilms = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            Film film = new Film();
            film.setRating(Double.parseDouble(obj.get("docs").get(i).get("rating").get("imdb").toString()));
            film.setName(obj.get("docs").get(i).get("name").toString());
            film.setOriginalName(obj.get("docs").get(i).get("alternativeName").toString());
            film.setYear(Integer.parseInt(obj.get("docs").get(i).get("year").toString()));
            film.setVotes(Integer.parseInt(obj.get("docs").get(i).get("votes").get("imdb").toString()));
            topFilms.add(film);
        }
        sortFilmsByRating(topFilms);
        setPositionForFilms(topFilms);
        return topFilms;
    }
    private List<Film> sortFilmsByRating(List<Film> films){
        films.sort(Comparator.comparing(Film::getRating).reversed());
        return films;
    }

    private List<Film> setPositionForFilms(List<Film> films){
        for (int i = 0; i<10; i++){
            films.get(i).setPosition(i+1);
        }
        return films;
    }
}

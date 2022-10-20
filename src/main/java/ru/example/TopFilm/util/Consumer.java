package ru.example.TopFilm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.example.TopFilm.models.Film;
import ru.example.TopFilm.services.FilmService;

import java.util.List;

@Component
public class Consumer {
    private final FilmMapper filmMapper;

    @Autowired
    public Consumer(FilmMapper filmMapper) {
        this.filmMapper = filmMapper;
    }

    public List<Film> requestFilms(int year) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.kinopoisk.dev/movie?token=Q45NMHY-HB24ZZK-N8JG241-NCBHTT9&field=rating.kp&search=0-10&field=year&search=" + year + "&field=type&search=movie&sortField=votes.imdb&sortType=-1";
        String response = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(response);

        return filmMapper.map(obj);
    }

}

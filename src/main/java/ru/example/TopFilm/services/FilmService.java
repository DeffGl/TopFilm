package ru.example.TopFilm.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.TopFilm.models.Film;
import ru.example.TopFilm.repositories.FilmRepository;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Cacheable("films")
    public List<Film> findByYear(int year){
        log.info("find by year");
        return filmRepository.findByYear(year);
    }

    @Cacheable(value = "films", key = "#films.get(0).name")
    @Transactional
    public List<Film> save(List<Film> films){
        log.info("save");
        filmRepository.saveAll(films);
        return films;
    }
}

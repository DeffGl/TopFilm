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
    public List<Film> findAll(){
        log.info("find all");
        return filmRepository.findAll();
    }

    @Cacheable(value = "films", key = "#film")
    @Transactional
    public Film save(Film film){
        log.info("save");
        return filmRepository.save(film);
    }
}

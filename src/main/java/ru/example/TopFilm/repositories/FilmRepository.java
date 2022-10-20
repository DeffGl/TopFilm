package ru.example.TopFilm.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.TopFilm.models.Film;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    public List<Film> findByYear(int year);
}

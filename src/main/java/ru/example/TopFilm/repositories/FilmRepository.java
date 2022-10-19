package ru.example.TopFilm.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.TopFilm.models.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}

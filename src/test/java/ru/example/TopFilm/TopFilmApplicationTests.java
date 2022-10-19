package ru.example.TopFilm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.example.TopFilm.models.Film;
import ru.example.TopFilm.services.FilmService;

@Slf4j
@SpringBootTest
class TopFilmApplicationTests {
	@Autowired
	private FilmService filmService;

	@Test
	void contextLoads() {
		Film film = new Film(1, 7.5, "Film", "FilmOrig", 2005, 1505);
		Film film2 = new Film(2, 7.4, "FilmTwo", "FilmOrigTwo", 1994, 15);

		filmService.save(film);
		filmService.save(film2);
		filmService.save(film2);

		System.out.println(filmService.findAll());
		System.out.println(filmService.findAll());


	}

}

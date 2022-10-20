package ru.example.TopFilm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.example.TopFilm.models.Film;
import ru.example.TopFilm.services.FilmService;

import java.util.List;

@Slf4j
@SpringBootTest
class TopFilmApplicationTests {
	@Autowired
	private FilmService filmService;

	@Test
	void contextLoads() {
		Film film = new Film(1, 7.5, "Film", "FilmOrig", 2005, 1505);
		Film film2 = new Film(2, 7.4, "FilmTwo", "FilmOrigTwo", 1994, 15);
		Film film3 = new Film(3, 6.4, "FilmThree", "FilmOrigThree", 1969, 78561);
		Film film4 = new Film(4, 5.5, "FilmFour", "FilmOrigFour", 2020, 4452);
		Film film5 = new Film(5, 4.2, "FilmFive", "FilmOrigFive", 2005, 78);

		List<Film> films = List.of(film, film2);
		List<Film> films2 = List.of(film, film2);
		List<Film> films1 = List.of(film3, film2);
		List<Film> films3 = List.of(film4, film5);



		filmService.save(films);
		filmService.save(films2);
		filmService.save(films1);
		filmService.save(films3);

	}

}

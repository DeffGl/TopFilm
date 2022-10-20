package ru.example.TopFilm.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.TopFilm.dto.FilmDTO;
import ru.example.TopFilm.models.Film;
import ru.example.TopFilm.services.FilmService;
import ru.example.TopFilm.util.Consumer;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/top/film")
public class FilmController {

    private final FilmService filmService;
    private final ModelMapper modelMapper;
    private final Consumer consumer;

    @Autowired
    public FilmController(FilmService filmService, ModelMapper modelMapper, Consumer consumer) {
        this.filmService = filmService;
        this.modelMapper = modelMapper;
        this.consumer = consumer;
    }

    @GetMapping()
    public String getTopFilms(@RequestParam(value = "year", required = false) Optional<Integer> year,
                              Model model) throws JsonProcessingException {
        if (year.isPresent()) {

            List<Film> films = filmService.findByYear(year.get());

            if (films.isEmpty()){
                films = consumer.requestFilms(year.get());
                filmService.save(films);
            }
            List<FilmDTO> filmsDTO = films.stream().map(film -> modelMapper.map(film, FilmDTO.class)).toList();
            model.addAttribute("films", filmsDTO);
        }
        return "/topFilm";
    }
}

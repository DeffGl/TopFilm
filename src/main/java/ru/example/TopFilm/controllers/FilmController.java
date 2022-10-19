package ru.example.TopFilm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.TopFilm.models.Film;
import ru.example.TopFilm.services.FilmService;

import java.util.List;

@Controller
@RequestMapping("/top/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public String getTopFilms(Model model){
        model.addAttribute("films", filmService.findAll());
        return "/topFilm";
    }


}

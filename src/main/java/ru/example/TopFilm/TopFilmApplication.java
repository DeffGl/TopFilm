package ru.example.TopFilm;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;

@SpringBootApplication
@EnableCaching
public class TopFilmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopFilmApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}

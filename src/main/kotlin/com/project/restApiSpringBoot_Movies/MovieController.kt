package com.project.restApiSpringBoot_Movies

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieController(val movieService: MovieService) {

    @GetMapping("/movies", MediaType.APPLICATION_JSON_VALUE)
    fun getMovies(): List<Movie> = movieService.getMovies()

}
package com.project.restApiSpringBoot_Movies

import io.kotlintest.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MovieServiceTest {

    lateinit var movieService: MovieService
    lateinit var movie1: Movie
    lateinit var movie2: Movie
    lateinit var movies: List<Movie>


    @BeforeEach
    internal fun setUp() {
        movieService = MovieService()
    }

    @Test
    fun `should return list of movies`(){
        movie1 = Movie(
                "imdb01",
                "Movie1",
                "Director1",
                listOf("Actor1", "Actor2"),
                listOf("Actress1"),
                listOf("Genre1"),
                120
        )
        movie2 = Movie(
                "imdb02",
                "Movie1",
                "Director1",
                listOf("Actor1", "Actor2"),
                listOf("Actress1"),
                listOf("Genre1"),
                120)
        movies = listOf(movie1, movie2)

        movieService.getMovies() shouldBe movies
    }

    @Test
    fun `should return movie with given id`() {
        movie1 = Movie(
                "imdb01",
                "Movie1",
                "Director1",
                listOf("Actor1", "Actor2"),
                listOf("Actress1"),
                listOf("Genre1"),
                120
        )

        movieService.getMovieById("imdb01") shouldBe movie1
    }

}
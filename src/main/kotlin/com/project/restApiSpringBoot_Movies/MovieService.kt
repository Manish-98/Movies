package com.project.restApiSpringBoot_Movies

import org.springframework.stereotype.Component

@Component
class MovieService {

    private final val movies = ArrayList<Movie>()

    init {
        val movie1 = Movie(
                "imdb01",
                "Movie1",
                "Director1",
                listOf("Actor1", "Actor2"),
                listOf("Actress1"),
                listOf("Genre1"),
                120
        )
        val movie2 = Movie(
                "imdb02",
                "Movie1",
                "Director1",
                listOf("Actor1", "Actor2"),
                listOf("Actress1"),
                listOf("Genre1"),
                120
        )
        movies.add(movie1)
        movies.add(movie2)
    }

    fun getMovies(): List<Movie> = movies
    fun getMovieById(imdbId: String): Movie = movies.find { it.imdbID == imdbId } ?: Movie()


}
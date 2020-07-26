package com.project.restApiSpringBoot_Movies

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

internal class MovieControllerTest {

    @Test
    fun `should return list of movies`() {
        val movieService = mockk<MovieService>()

        val movie1 = Movie(
                "imdb01",
                "Movie1",
                "Director1",
                listOf("Actor1", "Actor2"),
                listOf("Actress1"),
                listOf("Genre1"),
                120
        )
        every { movieService.getMovies() } returns listOf(movie1)

        val mockMvc = MockMvcBuilders.standaloneSetup(MovieController(movieService)).build()
        mockMvc.perform(MockMvcRequestBuilders.get("/allMovies"))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is2xxSuccessful)

        verify { movieService.getMovies() }
    }

    @Test
    internal fun `should return movie by given imdbId`() {
        val movieService = mockk<MovieService>()
        val movie = Movie(
                "imdb01",
                "Movie1",
                "Director1",
                listOf("Actor1", "Actor2"),
                listOf("Actress1"),
                listOf("Genre1"),
                120
        )

        every { movieService.getMovieById("imdb01") } returns movie
        val mockMvc = MockMvcBuilders.standaloneSetup(MovieController(movieService)).build()
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/imdb01"))
                .andExpect(MockMvcResultMatchers.status()
                        .is2xxSuccessful)

        verify { movieService.getMovieById("imdb01") }
    }
}
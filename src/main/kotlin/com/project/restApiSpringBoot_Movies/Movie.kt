package com.project.restApiSpringBoot_Movies

data class Movie(
        val imdbID: String,
        val title: String,
        val director: String,
        val actors: List<String>,
        val actresses: List<String>,
        val genres: List<String>,
        val duration: Int
)

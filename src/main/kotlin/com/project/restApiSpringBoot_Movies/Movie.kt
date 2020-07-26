package com.project.restApiSpringBoot_Movies

data class Movie(
        val imdbID: String = "",
        val title: String = "",
        val director: String = "",
        val actors: List<String> = listOf(),
        val actresses: List<String> = listOf(),
        val genres: List<String> = listOf(),
        val duration: Int = 0
)

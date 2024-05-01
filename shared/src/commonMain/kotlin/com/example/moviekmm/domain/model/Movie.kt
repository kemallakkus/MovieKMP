package com.example.moviekmm.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterImage: String,
    val releaseDate: String
)

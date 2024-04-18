package com.example.moviekmm.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val postImage: String,
    @SerialName("release_date")
    val releaseDate: String,
)

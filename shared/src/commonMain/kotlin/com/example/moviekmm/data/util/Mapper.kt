package com.example.moviekmm.data.util

import com.example.moviekmm.data.remote.MovieRemote
import com.example.moviekmm.domain.model.Movie

internal fun MovieRemote.toMovie(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        overview = this.overview,
        posterImage = getImageUrl(this.posterImage),
        releaseDate = this.releaseDate
    )
}

private fun getImageUrl(posterImage: String) = "https://image.tmdb.org/t/p/w500/$posterImage"
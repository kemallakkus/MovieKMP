package com.example.moviekmm.data.util

import com.example.moviekmm.data.remote.MovieDetail
import com.example.moviekmm.domain.model.Movie

internal fun MovieDetail.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        image = getImage(postImage),
        releaseDate = releaseDate
    )
}

private fun getImage(postImage: String) = "https://www.themoviedb.org/t/p/w500/${postImage}"
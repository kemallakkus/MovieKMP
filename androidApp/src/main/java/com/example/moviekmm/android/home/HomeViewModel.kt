package com.example.moviekmm.android.home

import com.example.moviekmm.domain.model.Movie

class HomeViewModel {
}

data class HomeState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var movies: List<Movie> = emptyList(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false
)
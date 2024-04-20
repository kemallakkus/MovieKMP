package com.example.moviekmm.data.remote

import com.example.moviekmm.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher
) {

    suspend fun getMovies(page: Int) = withContext(dispatcher.io) {
        apiService.getMovies(page)
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io) {
        apiService.getMovie(movieId)
    }
}
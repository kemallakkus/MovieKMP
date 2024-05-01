package com.example.moviekmm.data.repository

import com.example.moviekmm.data.remote.RemoteDataSource
import com.example.moviekmm.data.util.toMovie
import com.example.moviekmm.domain.model.Movie
import com.example.moviekmm.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}
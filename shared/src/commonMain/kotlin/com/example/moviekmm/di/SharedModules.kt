package com.example.moviekmm.di

import com.example.moviekmm.data.remote.MovieService
import com.example.moviekmm.data.remote.RemoteDataSource
import com.example.moviekmm.data.repository.MovieRepositoryImpl
import com.example.moviekmm.domain.repository.MovieRepository
import com.example.moviekmm.domain.usecases.GetMovieUseCase
import com.example.moviekmm.domain.usecases.GetMoviesUseCase
import com.example.moviekmm.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single <MovieRepository> {MovieRepositoryImpl(get())}
    factory { GetMovieUseCase() }
    factory { GetMoviesUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilModule)

fun getSharedModules() = sharedModules
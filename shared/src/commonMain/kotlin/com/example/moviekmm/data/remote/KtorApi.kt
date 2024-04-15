package com.example.moviekmm.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


//d42c2f458c5fd151773ae1c9e28bdff8

//https://api.themoviedb.org/3/movie/603692?api_key=d42c2f458c5fd151773ae1c9e28bdff8
//https://api.themoviedb.org/3/movie/popular?page=1&api_key=d42c2f458c5fd151773ae1c9e28bdff8

private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = "d42c2f458c5fd151773ae1c9e28bdff8"

internal abstract class KtorApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(endPoint: String) {
        url {
            takeFrom(BASE_URL)
            path("3", endPoint)
            parameter("api_key", API_KEY)
        }
    }
}
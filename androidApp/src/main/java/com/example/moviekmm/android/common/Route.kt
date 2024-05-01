package com.example.moviekmm.android.common

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Route {
    val title: String
    val route: String
    val routeWithArgs: String
}

object Home : Route {
    override val title: String
        get() = "Movies"
    override val route: String
        get() = "home"
    override val routeWithArgs: String
        get() = route
}

object Detail : Route {
    override val title: String
        get() = "Movie Details"
    override val route: String
        get() = "detail"
    override val routeWithArgs: String
        get() = "$route/{movieId}"

    val args = listOf(navArgument("movieId") {
        type = NavType.IntType
    })
}

val movieRoutes = listOf(Home, Detail)
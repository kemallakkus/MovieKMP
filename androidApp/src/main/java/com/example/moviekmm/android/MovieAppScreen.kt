package com.example.moviekmm.android

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviekmm.android.common.Detail
import com.example.moviekmm.android.common.Home
import com.example.moviekmm.android.common.MovieToolbar
import com.example.moviekmm.android.common.movieRoutes
import com.example.moviekmm.android.detail.DetailScreen
import com.example.moviekmm.android.detail.DetailViewModel
import com.example.moviekmm.android.home.HomeScreen
import com.example.moviekmm.android.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MovieAppScreen() {

    val navController = rememberNavController()
    val homeViewModel: HomeViewModel = koinViewModel()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = movieRoutes.find {
        backStackEntry?.destination?.route == it.route ||
                backStackEntry?.destination?.route == it.routeWithArgs
    } ?: Home

    Scaffold(
        topBar = {
            MovieToolbar(
                navigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen
            ) {
                navController.navigateUp()
            }
        }
    ) { innerPaddings ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPaddings),
            startDestination = Home.routeWithArgs
        ) {
            composable(Home.routeWithArgs) {
                HomeScreen(
                    uiState = homeViewModel.uiState,
                    loadNextMovies = {
                        homeViewModel.loadMovies(forceReload = it)
                    },
                    navigateToDetail = {
                        navController.navigate(
                            "${Detail.route}/${it.id}"
                        )
                    }
                )
            }

            composable(Detail.routeWithArgs, arguments = Detail.args) {
                val movieId = it.arguments?.getInt("movieId") ?: 0
                val detailViewModel: DetailViewModel = koinViewModel(
                    parameters = { parametersOf(movieId) }
                )

                DetailScreen(uiState = detailViewModel.uiState)
            }
        }
    }
}
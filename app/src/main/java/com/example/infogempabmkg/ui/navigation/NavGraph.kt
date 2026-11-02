package com.example.infogempabmkg.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.infogempabmkg.ui.GempaViewModel
import com.example.infogempabmkg.ui.screen.DetailScreen
import com.example.infogempabmkg.ui.screen.HomeScreen
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

object AppDestinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail/{gempaId}"

    fun createDetailRoute(gempaId: String): String {
        val encodedId = URLEncoder.encode(gempaId, StandardCharsets.UTF_8.toString())
        return "detail/$encodedId"
    }
}

@Composable
fun GempaNavGraph(
    navController: NavHostController = rememberNavController(),
    viewModel: GempaViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    NavHost(
        navController = navController,
        startDestination = AppDestinations.HOME_ROUTE
    ) {
        composable(AppDestinations.HOME_ROUTE) {
            HomeScreen(
                uiState = uiState,
                searchQuery = searchQuery,
                onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
                onGempaClick = { gempa ->
                    navController.navigate(AppDestinations.createDetailRoute(gempa.uniqueId))
                },
                onRetry = { viewModel.loadGempaData() }
            )
        }

        composable(
            route = AppDestinations.DETAIL_ROUTE,
            arguments = listOf(navArgument("gempaId") { type = NavType.StringType })
        ) { backStackEntry ->
            val encodedId = backStackEntry.arguments?.getString("gempaId").orEmpty()
            val gempaId = try {
                URLDecoder.decode(encodedId, StandardCharsets.UTF_8.toString())
            } catch (e: Exception) {
                encodedId
            }
            val gempa = viewModel.getGempaById(gempaId)

            DetailScreen(
                gempa = gempa,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

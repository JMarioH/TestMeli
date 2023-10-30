package com.jmariohv.testmeli.modules.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jmariohv.testmeli.modules.navigation.NavDestination.NavSearchDetail
import com.jmariohv.testmeli.modules.navigation.NavDestination.NavSearchScreen
import com.jmariohv.testmeli.modules.search.presentation.SearchScreen
import com.jmariohv.testmeli.modules.search.presentation.SearchViewModel
import com.jmariohv.testmeli.modules.search_detail.presentation.SearchDetailScreen
import com.jmariohv.testmeli.network.NetworkStatus

@Composable
fun SearchNavScreen(
    navController: NavHostController,
    connectiveStatus: NetworkStatus.Status,
    onBackPress: () -> Unit
) {

    NavyAffiliatesHost(navController, connectiveStatus, onBackPress)
}

@Composable
fun NavyAffiliatesHost(
    navController: NavHostController,
    connectiveStatus: NetworkStatus.Status,
    onBackPress: () -> Unit
) {
    val viewmodelSearch = hiltViewModel<SearchViewModel>()

    NavHost(
        navController = navController,
        startDestination = NavSearchScreen
    ) {
        composable(route = NavSearchScreen) {
            SearchScreen(viewModel = viewmodelSearch,
                onNextScreen = {
                    navController.navigate(NavSearchDetail)
                }
            )
        }

        composable(route = NavSearchDetail) {
            SearchDetailScreen(viewModel = viewmodelSearch,
                connectiveStatus = connectiveStatus,
                onBackScreen = {
                    navController.navigate(NavSearchScreen)
                }
            )
        }
    }
}
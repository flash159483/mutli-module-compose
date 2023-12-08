package com.lighthouse.home.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.lighthouse.home.ui.HomeScreen
import com.lighthouse.home.ui.HomeViewModel

fun NavGraphBuilder.homeScreen() {
    composable(route = "Home") {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(viewModel.homeState, viewModel::onEvent)
    }
}
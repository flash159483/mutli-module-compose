package com.lighthouse.multi_module_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.lighthouse.common_ui.constant.NavigationRoute
import com.lighthouse.common_ui.theme.CustomThemeManager
import com.lighthouse.common_ui.theme.MultiModuleComposeTheme
import com.lighthouse.home.navigation.homeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CustomThemeManager.colors.backgroundColor
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoute.Home.route
                    ) {
                        homeScreen()
                    }
                }
            }
        }
    }
}

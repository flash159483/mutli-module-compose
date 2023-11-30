package com.lighthouse.common_ui.constant

sealed class NavigationRoute(var route: String) {
    object Home : NavigationRoute("Home")
}

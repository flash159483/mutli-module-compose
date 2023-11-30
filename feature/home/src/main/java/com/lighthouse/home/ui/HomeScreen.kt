package com.lighthouse.home.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.lighthouse.common_ui.util.GetComposableType

@Composable
fun HomeScreen(state: HomeState) {
    LazyColumn {
        items(state.drivenData.size, key = {
            state.drivenData[it].id
        }) {
            GetComposableType(viewType = state.drivenData[it])
        }
    }
}

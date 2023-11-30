package com.lighthouse.common_ui.util

import androidx.compose.runtime.Composable
import com.lighthouse.common_ui.component.HomeTitle
import com.lighthouse.common_ui.component.UserProfileCard
import com.lighthouse.domain.response.ViewType
import com.lighthouse.domain.response.ViewTypeVO

@Composable
fun GetComposableType(viewType: ViewTypeVO) {
    when (viewType.viewType) {
        ViewType.HomeTitleViewType -> {
            HomeTitle(data = viewType)
        }

        ViewType.UserInfoViewType -> {
            UserProfileCard(data = viewType)
        }

        else -> {
            // do nothing
        }
    }
}
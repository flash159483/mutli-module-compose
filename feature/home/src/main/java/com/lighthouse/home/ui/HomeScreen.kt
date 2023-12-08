package com.lighthouse.home.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.lighthouse.common_ui.constant.Constants
import com.lighthouse.domain.response.QuestionVO

@Composable
fun HomeScreen(state: HomeState, onEvent: (HomeEvent) -> Unit) {
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val lazyGridListState = rememberLazyListState()

    val shouldStartPaginate = remember {
        derivedStateOf {
            (lazyGridListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyGridListState.layoutInfo.totalItemsCount - 6)
        }
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value && !state.isLoading) {
            onEvent(HomeEvent.OnPagingStart)
        }
    }


    LazyColumn(
        state = lazyGridListState,
    ) {
        items(state.questions.size, key = {
            it
        }) { index ->
            QuestionTile(question = state.questions[index])
        }
    }

    LaunchedEffect(key1 = state.questions.size) {
        if (Constants.cardHeight.dp * state.questions.size < screenHeight) {
            onEvent(HomeEvent.OnPagingStart)
        }
    }
}

@Composable
fun QuestionTile(question: QuestionVO) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Black))
            .height(Constants.cardHeight.dp),
    ) {
        Text(text = question.title, maxLines = 2, modifier = Modifier.padding(8.dp))
    }
}

package com.lighthouse.common_ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.lighthouse.common_ui.util.parseRichText
import com.lighthouse.domain.response.ContentVO
import com.lighthouse.domain.response.ViewTypeVO

@Composable
fun HomeTitle(data: ViewTypeVO) {
    val content = data.content as ContentVO.HomeTitleContent
    val context = LocalContext.current
    val parsedContent by remember(key1 = data.id) {
        mutableStateOf(
            parseRichText(content.tvHomeTitle, context)
        )
    }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = parsedContent.first, inlineContent = parsedContent.second)
    }
}

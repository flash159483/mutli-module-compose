package com.lighthouse.common_ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lighthouse.common_ui.theme.CustomThemeManager
import com.lighthouse.common_ui.util.parseRichText
import com.lighthouse.domain.response.ContentVO
import com.lighthouse.domain.response.ViewTypeVO

@Composable
fun UserProfileCard(data: ViewTypeVO) {
    val content = data.content as ContentVO.UserInfoTile
    val context = LocalContext.current

    val profileName by remember(data.id) {
        mutableStateOf(parseRichText(content.tvProfileName, context))
    }

    val description by remember(data.id) {
        mutableStateOf(parseRichText(content.tvProfileIntro, context))
    }

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = CustomThemeManager.colors.backgroundColor
        ),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .allowRgb565(true)
                    .crossfade(true)
                    .data(content.ivProfileImg.image)
                    .build(),
                contentDescription = "profile image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .height(content.ivProfileImg.height.dp)
                    .width(content.ivProfileImg.width.dp)
                    .padding(8.dp)
            )

            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = profileName.first, inlineContent = profileName.second)
                Text(text = description.first, inlineContent = description.second)
            }
        }

    }
}
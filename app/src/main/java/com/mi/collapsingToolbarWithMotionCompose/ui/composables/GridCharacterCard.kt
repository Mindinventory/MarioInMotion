package com.mi.collapsingToolbarWithMotionCompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.mi.collapsingToolbarWithMotionCompose.R
import com.mi.collapsingToolbarWithMotionCompose.data.mockdata.ListPreviewParameterProvider
import com.mi.collapsingToolbarWithMotionCompose.data.model.MiItem
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.CollapsingToolbarWithMotionComposeTheme
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.GoldYellow
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.Gray245
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.MarioRedDark

@Composable
fun GridCharacterCard(
    miItem: MiItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.aspectRatio(0.66f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray245)
        ) {
            miItem.itemImage?.let { painterResource(it) }?.let {
                Image(
                    painter = it,
                    contentDescription = miItem.itemDescription,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .padding(35.dp)
                        .fillMaxWidth()
                )
            }
            TopBar()
            miItem.itemName?.let { BottomBar(it) }
        }
    }
}

@Composable
private fun BoxScope.TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.093f)
            .background(MarioRedDark)
            .padding(horizontal = 8.dp, vertical = 2.dp)
            .align(Alignment.TopCenter)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.75f)
                .wrapContentWidth()
                .align(Alignment.CenterStart),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Golden star 1",
                tint = GoldYellow
            )
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Golden star 2",
                tint = GoldYellow
            )
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Golden star 3",
                tint = GoldYellow
            )
        }

        Row(
            modifier = Modifier
                .fillMaxHeight(0.75f)
                .wrapContentWidth()
                .align(Alignment.CenterEnd),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_coin),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp)),
                contentDescription = "Coin"
            )
            Text(
                text = "87",
                color = Color.Black,
                modifier = Modifier,
                fontFamily = FontFamily(
                    Font(R.font.super_mario_bros, FontWeight.Normal)
                ),
            )
        }
    }
}

@Composable
private fun BoxScope.BottomBar(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.14f)
            .background(MarioRedDark)
            .align(Alignment.BottomCenter)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            fontFamily = FontFamily(
                Font(R.font.super_mario_bros, FontWeight.Normal)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GridItemCardPreview(
    @PreviewParameter(ListPreviewParameterProvider::class) list: List<MiItem>
) {
    CollapsingToolbarWithMotionComposeTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            list.take(2).forEach {
                GridCharacterCard(
                    miItem = it,
                    modifier = Modifier
                        .padding(2.dp)
                        .weight(1f)
                        .wrapContentHeight()
                )
            }
        }
    }
}
package com.mi.collapsingToolbarWithMotionCompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.compose.ui.unit.sp
import com.mi.collapsingToolbarWithMotionCompose.R
import com.mi.collapsingToolbarWithMotionCompose.data.mockdata.ListPreviewParameterProvider
import com.mi.collapsingToolbarWithMotionCompose.data.model.MiItem
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.Black
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.CoinCount
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.CollapsingToolbarWithMotionComposeTheme

@Composable
fun GridCharacterCard(
    miItem: MiItem, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.aspectRatio(0.84f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
//                .background(CardBackground)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_card_bg),
                contentDescription = "Card background",
                modifier = Modifier.fillMaxSize()
            )
            miItem.itemImage?.let { painterResource(it) }?.let {
                Image(
                    painter = it,
                    contentDescription = miItem.itemDescription,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
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
            .background(Black.copy(alpha = 0.4f))
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
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "Golden star 1"
            )
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "Golden star 2"
            )
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "Golden star 3"
            )
        }

        Row(
            modifier = Modifier
                .fillMaxHeight(2f)
                .wrapContentWidth()
                .align(Alignment.CenterEnd),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_coin),
                contentScale = ContentScale.Fit,
                modifier = Modifier.clip(RoundedCornerShape(5.dp)),
                contentDescription = "Coin"
            )
            Text(
                text = "87",
                color = CoinCount,
                modifier = Modifier,
                fontFamily = FontFamily(
                    Font(R.font.kid_games, FontWeight.Normal)
                ),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
private fun BoxScope.BottomBar(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.16f)
            .background(Black.copy(alpha = 0.3f))
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
            color = CoinCount,
            fontFamily = FontFamily(
                Font(R.font.kid_games, FontWeight.Normal)
            ),
            fontSize = 14.sp
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
                    miItem = it, modifier = Modifier
                        .padding(2.dp)
                        .weight(1f)
                        .wrapContentHeight()
                )
            }
        }
    }
}
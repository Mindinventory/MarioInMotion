package com.mi.collapsingToolbarWithMotionCompose.ui.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.mi.collapsingToolbarWithMotionCompose.R
import com.mi.collapsingToolbarWithMotionCompose.data.mockdata.ListPreviewParameterProvider
import com.mi.collapsingToolbarWithMotionCompose.data.model.MiItem
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.CollapsingToolbarWithMotionComposeTheme
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.MarioRedDark
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.MarioRedLight

@OptIn(ExperimentalMotionApi::class)
@Composable
fun MarioMotionHandler(
    list: List<MiItem>,
    columns: Int,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    progress: Float
) {
    val context = LocalContext.current

    val chunkedList = remember(list, columns) {
        list.chunked(columns)
    }

    // To include raw file, the JSON5 script file
    val motionScene = remember {
        context.resources.openRawResource(R.raw.motion_scene_mario)
            .readBytes()
            .decodeToString()   //readBytes -> cuz we want motionScene in a String format
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .fillMaxSize()
            .background(MarioRedLight)
    ) {

        /**
         * bg-image
         **/
        Image(
            painter = painterResource(id = R.drawable.ic_mario_level),
            contentDescription = "Toolbar Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .layoutId("collapsing_box")
                .fillMaxWidth()
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = size.height / 3,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient, blendMode = BlendMode.Multiply)
                    }
                },
            alignment = BiasAlignment(0f, 1f - ((1f - progress) * 0.50f)),
        )

        /**
         * Text - Collapsing
         */
        Text(
            text = stringResource(id = R.string.collapsing_text_minion),
            color = MarioRedDark,
            modifier = Modifier
                .layoutId("motion_text")
                .zIndex(1f),
            fontFamily = FontFamily(
                Font(R.font.super_mario_bros, FontWeight.Light)
            ),
            fontSize = 14.sp
        )

        /**
         * Main image
         **/
        Image(
            painter = painterResource(id = R.drawable.ic_mario_reversed),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .layoutId("content_img")
                .clip(RoundedCornerShape(5.dp)),
            contentDescription = "Animating Mario Image"
        )

        /**
         * Grid
         **/
        Column(
            modifier = modifier
                .verticalScroll(scrollState)
                .layoutId("data_content")
                .background(MarioRedLight),
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(contentPadding.calculateTopPadding())
            )

            chunkedList.forEach { chunk ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {

                    Spacer(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(contentPadding.calculateStartPadding(LocalLayoutDirection.current))
                    )

                    chunk.forEach { listItem ->
                        GridCharacterCard(
                            miItem = listItem,
                            modifier = Modifier
                                .padding(2.dp)
                                .weight(1f)
                        )
                    }

                    val emptyCells = columns - chunk.size
                    if (emptyCells > 0) {
                        Spacer(modifier = Modifier.weight(emptyCells.toFloat()))
                    }

                    Spacer(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(contentPadding.calculateEndPadding(LocalLayoutDirection.current))
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            )
        }

        /**
         * piranha flower
         **/
        Image(
            painter = painterResource(id = R.drawable.ic_piranha_flower),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .layoutId("piranha_flower"),
            contentDescription = "Piranha Flower"
        )

        /**
         * piranha tunnel
         **/
        Image(
            painter = painterResource(id = R.drawable.ic_piranha_tunnel),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .layoutId("piranha_tunnel"),
            contentDescription = "Piranha Tunnel"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GridItemHandlerPreview(
    @PreviewParameter(ListPreviewParameterProvider::class) list: List<MiItem>
) {
    CollapsingToolbarWithMotionComposeTheme {
        MarioMotionHandler(
            list = list,
            columns = 2,
            modifier = Modifier.fillMaxSize(),
            progress = 0.5f
        )
    }
}
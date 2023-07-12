package com.mi.collapsingToolbarWithMotionCompose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mi.collapsingToolbarWithMotionCompose.data.mockdata.populateList
import com.mi.collapsingToolbarWithMotionCompose.extra.animationScrollflags.MiExitUntilCollapsedState
import com.mi.collapsingToolbarWithMotionCompose.ui.composables.*
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.CollapsingToolbarWithMotionComposeTheme

val MinToolbarHeight = 96.dp
val MaxToolbarHeight = 176.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenContent() {
    val marioToolbarHeightRange = with(LocalDensity.current) {
        MinToolbarHeight.roundToPx()..MaxToolbarHeight.roundToPx()
    }
    val toolbarState = rememberSaveable(saver = MiExitUntilCollapsedState.Saver) {
        MiExitUntilCollapsedState(marioToolbarHeightRange)
    }
    val scrollState = rememberScrollState()
    toolbarState.scrollValue = scrollState.value

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = {
            MarioMotionHandler(
                list = populateList(),
                columns = 2,
                modifier = Modifier.fillMaxSize(),
                scrollState = scrollState,
                progress = toolbarState.progress
            )
        })
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreenContent() {
    CollapsingToolbarWithMotionComposeTheme {
        MainScreenContent()
    }
}
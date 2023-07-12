package com.mi.collapsingToolbarWithMotionCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mi.collapsingToolbarWithMotionCompose.ui.MainScreenContent
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.CollapsingToolbarWithMotionComposeTheme
import com.mi.collapsingToolbarWithMotionCompose.ui.theme.MarioRedDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CollapsingToolbarWithMotionComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val systemUiController = rememberSystemUiController()
                    val useDarkIcons = MaterialTheme.colors.isLight

                    // To set the status bar color
                    SideEffect {
                        systemUiController.setSystemBarsColor(
                            color = MarioRedDark,
                            darkIcons = useDarkIcons
                        )
                    }
                    MainScreenContent()
                }
            }
        }
    }
}
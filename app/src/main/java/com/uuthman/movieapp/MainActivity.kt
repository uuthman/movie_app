package com.uuthman.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import coil.annotation.ExperimentalCoilApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.uuthman.movieapp.presentation.NavGraphs
import com.uuthman.movieapp.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
